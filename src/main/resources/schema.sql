CREATE TABLE IF NOT EXISTS role (
  RoleId INT(11)      NOT NULL UNIQUE AUTO_INCREMENT,
  Title  VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (RoleId)
);

CREATE TABLE IF NOT EXISTS employee (
  EmployeeId    INT(11)      NOT NULL UNIQUE AUTO_INCREMENT,
  AcademicTitle VARCHAR(255) NOT NULL,
  Degree        VARCHAR(255) NOT NULL,
  JobTitle      VARCHAR(255) NOT NULL,
  Name          VARCHAR(255) NOT NULL,
  Patronymic    VARCHAR(255) NOT NULL,
  Surname       VARCHAR(255) NOT NULL,
  PRIMARY KEY (EmployeeId)
);

CREATE TABLE IF NOT EXISTS user
(
  UserId     INT(11) PRIMARY KEY                                                  NOT NULL AUTO_INCREMENT,
  CreateTime TIMESTAMP                                                            NOT NULL,
  Email      VARCHAR(255)                                                         NOT NULL UNIQUE,
  Login      VARCHAR(255)                                                         NOT NULL UNIQUE,
  Password   VARCHAR(255)                                                         NOT NULL,
  EmployeeId INT(11)                                                              NOT NULL,
  RoleId     INT(11)                                                              NOT NULL,
  FOREIGN KEY (RoleId) REFERENCES role (RoleId),
  FOREIGN KEY (EmployeeId) REFERENCES employee (EmployeeId)
);

INSERT IGNORE INTO role (Title)
VALUES ('SUPER_ADMIN');
SET @admin_role = LAST_INSERT_ID();

INSERT IGNORE INTO employee (AcademicTitle, Degree, JobTitle, Name, Patronymic, Surname)
VALUES ('Stub', 'Stub', 'Stub', 'Roman', 'Boris', 'Dashkovskyy');
SET @admin_employee = LAST_INSERT_ID();

INSERT IGNORE INTO user (`CreateTime`, `Email`, `Login`, `Password`, `EmployeeId`, `RoleId`)
VALUES ('2017-02-05 05:40:19', 'mineholst@gmail.com', 'admin', '$2a$12$0ywBYfgYOf3AjzgXlGiyZuD2mnSRfFF8YMt/NpDO5MqiJZyZEMHDy', @admin_employee, @admin_role);

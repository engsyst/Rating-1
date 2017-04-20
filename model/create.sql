-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema indplan
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `indplan` ;

-- -----------------------------------------------------
-- Schema indplan
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `indplan` DEFAULT CHARACTER SET utf8 ;
USE `indplan` ;

-- -----------------------------------------------------
-- Table `activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `activity` ;

CREATE TABLE IF NOT EXISTS `activity` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `deadline` DATE NULL DEFAULT NULL,
  `end` DATE NULL DEFAULT NULL,
  `place` VARCHAR(255) NULL DEFAULT NULL,
  `start` DATE NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `type` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `parent_id` INT(11) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC),
  INDEX `fk_category_category1_idx` (`parent_id` ASC),
  CONSTRAINT `fk_category_category1`
    FOREIGN KEY (`parent_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `academicTitle` VARCHAR(45) NULL DEFAULT NULL,
  `degree` VARCHAR(45) NULL DEFAULT NULL,
  `jobTitle` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(32) NOT NULL,
  `patronymic` VARCHAR(32) NOT NULL,
  `surname` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `IDX_EMPLOYEE_NAME` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `worktype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `worktype` ;

CREATE TABLE IF NOT EXISTS `worktype` (
  `id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `work` ;

CREATE TABLE IF NOT EXISTS `work` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(255) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `doc` VARCHAR(1000) NULL DEFAULT NULL,
  `title` VARCHAR(255) NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_work_type1_idx` (`type_id` ASC),
  CONSTRAINT `fk_work_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `worktype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `employee_has_work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_has_work` ;

CREATE TABLE IF NOT EXISTS `employee_has_work` (
  `work_id` INT(11) NOT NULL,
  `employee_id` INT(11) NOT NULL,
  PRIMARY KEY (`work_id`, `employee_id`),
  INDEX `FK_tngryr7saghkm7yvgcfaoreve` (`employee_id` ASC),
  CONSTRAINT `FK_lug03g6srnq0tpbbudl8lbef7`
    FOREIGN KEY (`work_id`)
    REFERENCES `work` (`id`),
  CONSTRAINT `FK_tngryr7saghkm7yvgcfaoreve`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `permission` ;

CREATE TABLE IF NOT EXISTS `permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `permissionname` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_d1i3urbmkgvotk58derno6qq9` (`permissionname` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `rolename` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_nctmxadhieiw7aduxjy4dfglt` (`rolename` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role_permission` ;

CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` INT(11) NOT NULL,
  `permission_id` INT(11) NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`),
  INDEX `FK_fn4pldu982p9u158rpk6nho5k` (`permission_id` ASC),
  CONSTRAINT `FK_fn4pldu982p9u158rpk6nho5k`
    FOREIGN KEY (`permission_id`)
    REFERENCES `permission` (`id`),
  CONSTRAINT `FK_j89g87bvih4d6jbxjcssrybks`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `enabled` BIT(1) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `employee_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_r1usl9qoplqsbrhha5e0niqng` (`employee_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `FK_r1usl9qoplqsbrhha5e0niqng`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_role` ;

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `FK_it77eq964jhfqtu54081ebtio` (`role_id` ASC),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `work_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `work_has_category` ;

CREATE TABLE IF NOT EXISTS `work_has_category` (
  `work_id` INT(11) NOT NULL,
  `category_id` INT(11) NOT NULL,
  PRIMARY KEY (`work_id`, `category_id`),
  INDEX `FK_3u63c75kytr3j13ahulrvk215` (`category_id` ASC),
  CONSTRAINT `FK_1vorqkg4wkv99odv6upme7rsx`
    FOREIGN KEY (`work_id`)
    REFERENCES `work` (`id`),
  CONSTRAINT `FK_3u63c75kytr3j13ahulrvk215`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Data for table `employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `employee` (`id`, `academicTitle`, `degree`, `jobTitle`, `name`, `patronymic`, `surname`) VALUES (1, 'NULL', 'NULL', 'админ', 'Админ', 'Админович', 'Админов');
INSERT INTO `employee` (`id`, `academicTitle`, `degree`, `jobTitle`, `name`, `patronymic`, `surname`) VALUES (2, 'NULL', 'NULL', 'доцент', 'Доцент', 'Доцентович', 'Доцентов');

COMMIT;


-- -----------------------------------------------------
-- Data for table `permission`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `permission` (`id`, `permissionname`) VALUES (4, 'ADD_CATEGORY');
INSERT INTO `permission` (`id`, `permissionname`) VALUES (1, 'EDIT_SELF_PLAN');
INSERT INTO `permission` (`id`, `permissionname`) VALUES (3, 'MAKE_DEP_REPORT');
INSERT INTO `permission` (`id`, `permissionname`) VALUES (2, 'MAKE_SELF_REPORT');

COMMIT;


-- -----------------------------------------------------
-- Data for table `role`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `role` (`id`, `rolename`) VALUES (1, 'ADMIN');
INSERT INTO `role` (`id`, `rolename`) VALUES (3, 'DEP_ADMIN');
INSERT INTO `role` (`id`, `rolename`) VALUES (4, 'DEP_OPERATOR');
INSERT INTO `role` (`id`, `rolename`) VALUES (2, 'EMPLOYEE');

COMMIT;


-- -----------------------------------------------------
-- Data for table `role_permission`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (1, 4);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (2, 1);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (2, 2);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (3, 1);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (3, 2);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `user` (`id`, `createTime`, `email`, `enabled`, `password`, `username`, `employee_id`) VALUES (1, '2017-04-19 14:19:22', 'admin@x.x', 1, 'admin', 'admin', 1);
INSERT INTO `user` (`id`, `createTime`, `email`, `enabled`, `password`, `username`, `employee_id`) VALUES (2, '2017-04-19 14:19:22', 'empl@x.x', 1, 'empl', 'empl', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `indplan`;
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

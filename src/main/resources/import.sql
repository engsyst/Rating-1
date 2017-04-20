INSERT INTO `permission` VALUES (1,'EDIT_SELF_PLAN'),(2,'MAKE_SELF_REPORT'),(3,'MAKE_DEP_REPORT'),(4,'ADD_CATEGORY');
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'EMPLOYEE'),(3,'DEP_ADMIN'),(4,'DEP_OPERATOR');
INSERT INTO `role_permission` VALUES (1,4),(2,1),(2,2),(3,1),(3,2),(3,3);
INSERT INTO `employee` VALUES (1,NULL,NULL,'админ','Админ','Админович','Админов'),(2,NULL,NULL,'доцент','Доцент','Доцентович','Доцентов');
INSERT INTO `user`(`Email`,`enabled`,`Password`,`Username`,`Employee_Id`)  VALUES ('admin@x.x',b'1','admin','admin',1),('empl@x.x',b'1','empl','empl',2);
INSERT INTO `user_role` VALUES (1,1),(2,2);

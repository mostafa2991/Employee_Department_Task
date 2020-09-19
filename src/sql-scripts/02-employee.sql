CREATE DATABASE  IF NOT EXISTS `empitblocks` ;
USE `empitblocks`;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `department`;
DROP TABLE IF EXISTS `emp_dep`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(45) unique  NOT NULL,
`department_id` int(11) NOT NULL,

FOREIGN KEY (department_id) REFERENCES department(id) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `department` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(45) unique NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES (1,'Nagy Mohamed',5),
							  (2,'Ramy Sayed ',1),
							  (3,'Mona Ahmed ',2),
							  (4,'Mostafa Moosa ',3),
							  (5,'Marna Adel ',2),
							  (6,'Soma Hussin ',2),
							  (7,'Raly Elshazly ',2),
							  (8,'Doda wezo ',5),
							  (9,'lamia Adly ',5),
							  (10,'Ramy mandela ',5);
							  
INSERT INTO `department`VALUES(1,'Sales'),
							  (2,'IT'),
							  (3,'Java Developer'),
							  (4,'Engineer'),
							  (5,'HR');
							  



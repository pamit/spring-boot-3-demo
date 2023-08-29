--CREATE DATABASE  IF NOT EXISTS `employee_directory`;
--USE `employee_directory`;
USE `student_tracker`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'John','Smith','a@a.com'),
	(2,'Paul','Young','a@a.com'),
	(3,'Brian','Adams','a@a.com'),
	(4,'Gordon','Summer (Sting)','a@a.com'),
	(5,'David','Gilmour','a@a.com');

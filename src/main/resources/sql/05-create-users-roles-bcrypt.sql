USE `student_tracker`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.bcryptcalculator.com/encode
--
-- Default passwords here are: test123
--

INSERT INTO `users`
VALUES
('john','{bcrypt}$2a$10$l8tG7b5JMrabAXXwzkBqNusG8vu280EM/n47Wu6JOIi5//ZOFT/SO',1),
('joe','{bcrypt}$2a$10$l8tG7b5JMrabAXXwzkBqNusG8vu280EM/n47Wu6JOIi5//ZOFT/SO',1),
('jim','{bcrypt}$2a$10$l8tG7b5JMrabAXXwzkBqNusG8vu280EM/n47Wu6JOIi5//ZOFT/SO',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('joe','ROLE_EMPLOYEE'),
('joe','ROLE_MANAGER'),
('jim','ROLE_EMPLOYEE'),
('jim','ROLE_MANAGER'),
('jim','ROLE_ADMIN');

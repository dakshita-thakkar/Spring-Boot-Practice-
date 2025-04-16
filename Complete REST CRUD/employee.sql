CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`
(
`id` int not null auto_increment,
`first_name` varchar(50) default null,
`last_name` varchar(50) default null,
`email` varchar(50) default null,
PRIMARY KEY(`id`)
)auto_increment=1, engine=InnoDB;

INSERT INTO employee VALUES

(1, 'Dakshita', 'Thakkar', 'dakshita@gmail.com'),
(2, 'Renu', 'Rao', 'renu@gmail.com'),
(3, 'Sushmita', 'Shetty', 'sushmita@gmail.com'),
(4, 'Ravish', 'Rozario', 'ravish@gmail.com'),
(5, 'Aditya' , 'Patil', 'aditya@gmail.com')
;

SELECT * FROM employee;


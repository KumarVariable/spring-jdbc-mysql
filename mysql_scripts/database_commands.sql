CREATE DATABASE institute;

USE institute;

CREATE TABLE course_information (
  course_id varchar(30) NOT NULL,
  course_name varchar(30) NOT NULL,
  course_trainer_name varchar(30) NOT NULL,
  course_duration int(10) NOT NULL,
  course_total_seats int(10) NOT NULL,
  course_fees double DEFAULT '0',
  course_description varchar(200) DEFAULT NULL,
  course_start_date date DEFAULT NULL,
  course_end_date date DEFAULT NULL,
  UNIQUE KEY `course_id` (`course_id`),
  UNIQUE KEY `course_name` (`course_name`)
);

SELECT * FROM course_information;
/***************************************************************
*MySQL Database Commands for CRUD operations
*
* Database : institute
* Table Name : course_information
*
****************************************************************/

/* Create Database : institute */
CREATE DATABASE institute;

USE institute;


/* Create Table : course */
CREATE TABLE course(
    id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    course_id varchar(30)NOT NULL UNIQUE,
    course_name varchar(30)NOT NULL UNIQUE,
    course_trainer_name varchar(30)NOT NULL,
    course_duration int(10)DEFAULT '0',
    course_total_seats int(10)DEFAULT '0',
    course_fees double DEFAULT '0',
    course_description varchar(200)DEFAULT 'NA',
    course_start_date datetime DEFAULT CURRENT_TIMESTAMP,
    course_end_date datetime DEFAULT CURRENT_TIMESTAMP 
);

/* Select records from table */
SELECT id,
    course_id,
    course_name,
    course_trainer_name,
    course_duration,
    course_total_seats,
    course_fees,
    course_description,
    course_start_date,
    course_end_date
FROM course;


/* Insert into table : course */
INSERT INTO course(
course_id,
course_name,
course_trainer_name,
course_duration,
course_total_seats,
course_fees,
course_description,
course_start_date,
course_end_date)
VALUES(
<{id: }>,
<{course_id: }>,
<{course_name: }>,
<{course_trainer_name: }>,
<{course_duration: 0}>,
<{course_total_seats: 0}>,
<{course_fees: 0}>,
<{course_description: NA}>,
<{course_start_date: CURRENT_TIMESTAMP}>,
<{course_end_date: CURRENT_TIMESTAMP}>
);

/* Update course into the table */
UPDATE course SET
course_id = <{course_id: }>,
course_name = <{course_name: }>,
course_trainer_name = <{course_trainer_name: }>,
course_duration = <{course_duration: 0}>,
course_total_seats = <{course_total_seats: 0}>,
course_fees = <{course_fees: 0}>,
course_description = <{course_description: NA}>,
course_start_date = <{course_start_date: CURRENT_TIMESTAMP}>,
course_end_date = <{course_end_date: CURRENT_TIMESTAMP}>
WHERE id = <{expr}> ;

/* Delete course from table */
DELETE FROM course
WHERE <{where_expression}> ;
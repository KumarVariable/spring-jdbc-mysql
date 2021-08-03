package com.mysql.spring.persistence;

import java.util.List;

import com.mysql.spring.model.Course;

/**
 * Interface to define abstract API's that performs CRUD 
 * operations on object of type @Course.
 * 
 * 
 * @author metanoia
 * @version 1.0
 */
public interface CourseDao {

	/**
	 * Read operation to get all available course from the database.
	 */
	public List<Course> readAllCourses();

	/**
	 * Create operation to add a new course into the database.
	 */
	public Boolean createCourse(Course course);

	/**
	 * Update operation to update details of a course into database.
	 */
	public int updateCourse(Course course, String courseId);

	/**
	 * Delete operation to remove record of a course from the database.
	 */
	public int deleteCourse(String courseId);

}

package com.mysql.spring.resultset.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mysql.spring.model.Course;

/**
 * Map each row of the ResultSet(database record) to instance of Course class.
 * 
 * @author metanoia
 * @version 1.0
 */
public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Course course = new Course();

		course.setCourseId(resultSet.getString("course_id"));
		course.setCourseName(resultSet.getString("course_name"));
		course.setCourseTrainerName(resultSet.getString("course_trainer_name"));
		course.setCourseDuration(resultSet.getInt("course_duration"));
		course.setCourseDescription(resultSet.getString("course_description"));
		course.setCourseFees(resultSet.getDouble("course_fees"));

		String strStartDate = resultSet.getDate("course_start_date").toString();

		String strEndtDate = resultSet.getDate("course_end_date").toString();

		course.setCourseStartDate(strStartDate);
		course.setCourseEndDate(strEndtDate);

		return course;
	}

}

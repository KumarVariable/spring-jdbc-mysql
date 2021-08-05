package com.mysql.spring.persistence.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.mysql.spring.model.Course;
import com.mysql.spring.persistence.CourseDao;
import com.mysql.spring.resultset.mapper.CourseRowMapper;

/**
 * 
 * Implementation of abstract API's of {@linkplain CourseDao}
 * 
 * @author metanoia
 * @version 1.0
 */
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String CREATE_COURSE = "INSERT INTO COURSE (COURSE_ID, COURSE_NAME, COURSE_TRAINER_NAME, COURSE_DURATION, "
			+ " COURSE_TOTAL_SEATS, COURSE_FEES, COURSE_DESCRIPTION, COURSE_START_DATE, COURSE_END_DATE ) "
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

	private static final String READ_ALL_COURSES = "SELECT ID, COURSE_ID, COURSE_NAME, COURSE_TRAINER_NAME, COURSE_DURATION, "
			+ " COURSE_TOTAL_SEATS, COURSE_FEES, COURSE_DESCRIPTION, COURSE_START_DATE, COURSE_END_DATE FROM COURSE ";

	private static final String UPDATE_COURSE_BY_ID = "UPDATE COURSE SET COURSE_NAME = ?, COURSE_TRAINER_NAME = ?, COURSE_DURATION = ?,"
			+ " COURSE_TOTAL_SEATS = ?, COURSE_FEES = ?, COURSE_DESCRIPTION = ?, COURSE_START_DATE = ?, COURSE_END_DATE = ? WHERE COURSE_ID = ? ";

	private static final String DELETE_BY_ID = "DELETE FROM COURSE WHERE COURSE_ID = ? ";

	/**
	 * 
	 * @see PreparedStatementCallback. doInPreparedStatement() gets called by
	 *      JdbcTemplate.execute() with an active JDBC prepared statement.No
	 *      need to care about closing the statement or the connection or about
	 *      handling transactions.
	 * 
	 * @return false - if the first result is an updatecount or there is no
	 *         result.
	 */
	@Override
	public Boolean createCourse(Course course) {

		boolean isRowInserted = jdbcTemplate.execute(CREATE_COURSE,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(
							PreparedStatement preparedStmnt)
							throws SQLException, DataAccessException {

						preparedStmnt.setString(1, course.getCourseId());
						preparedStmnt.setString(2, course.getCourseName());
						preparedStmnt.setString(3,
								course.getCourseTrainerName());
						preparedStmnt.setInt(4, course.getCourseDuration());
						preparedStmnt.setInt(5, course.getCourseTotalSeats());
						preparedStmnt.setDouble(6, course.getCourseFees());
						preparedStmnt.setString(7,
								course.getCourseDescription());
						
						Date startDateSqlFormat = Date.valueOf(course.getCourseStartDate());
						Date endDateSqlFormat = Date.valueOf(course.getCourseEndDate());
						
						preparedStmnt.setDate(8, startDateSqlFormat);
						preparedStmnt.setDate(9, endDateSqlFormat);

						return preparedStmnt.execute();
					}
				});
		return isRowInserted;
	}

	@Override
	public List<Course> readAllCourses() {
		List<Course> courseList = jdbcTemplate.query(READ_ALL_COURSES,
				new CourseRowMapper());
		return courseList;
	}

	@Override
	public int updateCourse(Course course, String courseId) {

		String courseName = course.getCourseName();
		String courseTrainerName = course.getCourseTrainerName();
		int courseDuration = course.getCourseDuration();
		int courseTotalSeats = course.getCourseTotalSeats();
		double courseFees = course.getCourseFees();
		String courseDescription = course.getCourseDescription();
		Date courseStartDate = Date.valueOf(course.getCourseStartDate());
		Date courseEndDate = Date.valueOf(course.getCourseEndDate());

		Object[] params = {courseName, courseTrainerName, courseDuration,
				courseTotalSeats, courseFees, courseDescription,
				courseStartDate, courseEndDate, courseId};

		int[] types = {Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.DOUBLE, Types.VARCHAR, Types.DATE,
				Types.DATE, Types.VARCHAR};

		int numberOfUpdatedRows = jdbcTemplate.update(UPDATE_COURSE_BY_ID,
				params, types);
		return numberOfUpdatedRows;
	}

	@Override
	public int deleteCourse(String courseId) {
		int numberOfDeletedRows = jdbcTemplate.update(DELETE_BY_ID, courseId);
		return numberOfDeletedRows;
	}

}

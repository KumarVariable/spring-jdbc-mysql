package com.mysql.spring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ObjectUtils;

import com.mysql.spring.config.ApplicationConfiguration;
import com.mysql.spring.model.Course;
import com.mysql.spring.persistence.CourseDao;

public class BasicSpringLab1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		CourseDao courseDao = (CourseDao) context.getBean("courseDao");

		// Uncomment below code to execute - Create Operation

		/*
		 * Course course = dummyInsertCourseData();
		 * 
		 * if(!ObjectUtils.isEmpty(course.getCourseId())) {
		 * 
		 * Boolean isCourseCreated = courseDao.createCourse(course);
		 * System.out.println( "Must return false as no resultset = " +
		 * isCourseCreated);
		 * 
		 * }
		 * 
		 */

		// Read Operation
		List<Course> courseList = courseDao.readAllCourses();

		if (courseList != null && courseList.size() > 0) {
			for (Course courseObj : courseList) {
				System.out.println("Course =  " + courseObj.toString());
			}
		}

		// Uncomment below code to execute - Update Operation

		/*
		 * Course updateCourse = dummyUpdateCourseData(); int rowUpdated =
		 * courseDao.updateCourse(updateCourse, "BOOT-2135");
		 * System.out.println("Number of updated row = " + rowUpdated);
		 * 
		 */

		// Uncomment below code to execute - Delete Operation

		/*
		 * 
		 * int rowDeletedCount = courseDao.deleteCourse("Java-11");
		 * System.out.println("Number of deleted row = " + rowDeletedCount);
		 * 
		 */

		context.close();

	}

	/**
	 * Helper method to return dummy 'Course' to Insert.
	 * 
	 * The method takes Calendar class to get current date and yesterday's date
	 * to pass as start date and end date respectively.
	 * 
	 * @return Course
	 */

	public static Course dummyInsertCourseData() {
		Course course = new Course();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dummyEndDate = formatter.format(calendar.getTime());

		calendar.add(Calendar.DATE, -1);

		String dummyStartDate = formatter.format(calendar.getTime());

		course.setCourseId("Java-11");
		course.setCourseName("Open JDK 11");
		course.setCourseTrainerName("Amazon");
		course.setCourseDuration(4);
		course.setCourseTotalSeats(30);
		course.setCourseFees(8000);
		course.setCourseDescription("Learn Amazon Corretto Open Jdk");
		course.setCourseStartDate(dummyStartDate);
		course.setCourseEndDate(dummyEndDate);

		return course;

	}

	/**
	 * Helper method to return dummy 'Course' to Update.
	 * 
	 * The method takes Calendar class to get current date and day before yesterday's date
	 * to pass as start date and end date respectively.
	 * 
	 * @return Course
	 */

	public static Course dummyUpdateCourseData() {
		Course course = new Course();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String dummyEndDate = formatter.format(calendar.getTime());

		calendar.add(Calendar.DATE, -2);

		String dummyStartDate = formatter.format(calendar.getTime());

		course.setCourseName("MongoDB Complete Guide");
		course.setCourseTrainerName("MongoDB Univerity");
		course.setCourseDuration(3);
		course.setCourseTotalSeats(39);
		course.setCourseFees(10000);
		course.setCourseDescription("Basic of MongoDB");
		course.setCourseStartDate(dummyStartDate);
		course.setCourseEndDate(dummyEndDate);

		return course;

	}

}

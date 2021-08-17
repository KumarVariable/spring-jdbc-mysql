package com.mysql.spring;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ObjectUtils;

import com.mysql.spring.config.ApplicationConfiguration;
import com.mysql.spring.model.Course;
import com.mysql.spring.persistence.CourseDao;

public class BasicSpringLab1 {

    public static void main(String[] args) {

	Logger log = Logger.getLogger(BasicSpringLab1.class.getName());

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
		ApplicationConfiguration.class);

	CourseDao courseDao = (CourseDao) context.getBean("courseDao");
	String courseId = "";

	log.info("Create Operation");

	Course course = dummyInsertCourseData();

	if (!ObjectUtils.isEmpty(course.getCourseId())) {

	    Boolean isCourseCreated = courseDao.createCourse(course);
	    System.out.println("Must return false as no resultset = " + isCourseCreated);

	}

	log.info("Read Operation");

	List<Course> courseList = courseDao.readAllCourses();

	if (courseList != null && courseList.size() > 0) {
	    for (Course courseObj : courseList) {
		log.info("Course =  " + courseObj.toString());
		courseId = courseObj.getCourseId();
	    }
	}

	log.info("Update Operation");

	Course updateCourse = dummyUpdateCourseData();
	int rowUpdated = courseDao.updateCourse(updateCourse, courseId);
	log.info("Number of updated row = " + rowUpdated);

	log.info("Delete Operation");

	int rowDeletedCount = courseDao.deleteCourse(courseId);
	log.info("Number of deleted row = " + rowDeletedCount);

	context.close();

    }

    /**
     * Helper method to return dummy 'Course' to Insert.
     * 
     * The method takes Calendar class to get current date and yesterday's date to
     * pass as start date and end date respectively.
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
	
	LocalDateTime now = LocalDateTime.now();
	
	int seconds = now.getSecond();
	String courseId = "Java-".concat(String.valueOf(seconds));

	course.setCourseId(courseId);
	course.setCourseName("Open Java 11".concat(courseId));
	course.setCourseTrainerName("Amazon Services");
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
     * The method takes Calendar class to get current date and day before
     * yesterday's date to pass as start date and end date respectively.
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

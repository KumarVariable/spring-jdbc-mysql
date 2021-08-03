package com.mysql.spring.model;

/**
 * Class represents information for a course.
 * 
 * @author metanoia
 * @version 1.0
 */
public class Course {

	public int id;
	public int courseDuration;
	public int courseTotalSeats;

	public double courseFees;

	public String courseId;
	public String courseName;
	public String courseTrainerName;
	public String courseDescription;

	public String courseStartDate;
	public String courseEndDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	public int getCourseTotalSeats() {
		return courseTotalSeats;
	}
	public void setCourseTotalSeats(int courseTotalSeats) {
		this.courseTotalSeats = courseTotalSeats;
	}
	
	public double getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(double courseFees) {
		this.courseFees = courseFees;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseTrainerName() {
		return courseTrainerName;
	}
	public void setCourseTrainerName(String courseTrainerName) {
		this.courseTrainerName = courseTrainerName;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	
	public String getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseDuration=" + courseDuration
				+ ", courseTotalSeats=" + courseTotalSeats + ", courseFees="
				+ courseFees + ", courseId=" + courseId + ", courseName="
				+ courseName + ", courseTrainerName=" + courseTrainerName
				+ ", courseDescription=" + courseDescription
				+ ", courseStartDate=" + courseStartDate + ", courseEndDate="
				+ courseEndDate + "]";
	}
	
	

}

package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CourseAndCredit {
	private int year;
	private int semester;
	
	@NotEmpty(message="The courseCode cannot be empty")
	@Size(min=7, max=20, message="CourseCode must be between 7 and 20 chars")
	private String courseCode;
	
	@NotEmpty(message="The title cannot be empty")
	@Size(min=3, max=100, message="courseName must be between 3 and 100 chars")
	private String courseName;
	
	@NotEmpty(message="The kind cannot be empty")
	@Size(min=3, max=100, message="kind must be between 3 and 100 chars")
	private String kind;
	
	private int credit;
	
	public CourseAndCredit() {
		
	}
	
	public CourseAndCredit(String kind, int credit) {
		this.kind = kind;
		this.credit = credit;
	}
	
	public CourseAndCredit(int year, int semester, String courseCode, String courseName, String kind, int credit) {
		this.year = year;
		this.semester = semester;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.kind = kind;
		this.credit = credit;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public String getcourseCode() {
		return courseCode;
	}
	
	public void setcourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getcourseName() {
		return courseName;
	}
	
	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getkind() {
		return kind;
	}
	
	public void setkind(String kind) {
		this.kind = kind;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [year=" + year + ", semester=" + semester + ", courseCode=" + courseCode + 
				", " + "courseName=" + courseName	+ ", kind=" + kind + ", credit=" + credit + "]";
	}
}

package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.CourseAndCredit;

public class DataMapper implements RowMapper<CourseAndCredit> {

	public CourseAndCredit mapRow(ResultSet rs, int rowNum) throws SQLException {

		CourseAndCredit CourseAndCredit = new CourseAndCredit();

		CourseAndCredit.setYear(rs.getInt("year"));
		CourseAndCredit.setSemester(rs.getInt("semester"));
		CourseAndCredit.setcourseCode(rs.getString("courseCode"));
		CourseAndCredit.setcourseName(rs.getString("courseName"));
		CourseAndCredit.setkind(rs.getString("kind"));
		CourseAndCredit.setCredit(rs.getInt("credit"));

		return CourseAndCredit;
	}

}

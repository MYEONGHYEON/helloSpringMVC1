package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.CourseAndCredit;

@Repository
public class DataDAO {

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from coursecredit";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	// querying and returning a single object
	public CourseAndCredit getCourse(String courseCode) {
		String sqlStatement = "select * from coursecredit where courseCode=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {courseCode}, new DataMapper());
	}

	// querying and returning multiple object
	public List<CourseAndCredit> getCourses() {
		String sqlStatement = "select * from coursecredit";

		return jdbcTemplateObject.query(sqlStatement, new DataMapper());
	}
	
	public boolean insert(CourseAndCredit courseandcredit) {
		int year = courseandcredit.getYear();
		int semester = courseandcredit.getSemester();
		String courseCode = courseandcredit.getcourseCode();
		String courseName = courseandcredit.getcourseName();
		String kind = courseandcredit.getkind();
		int credit = courseandcredit.getCredit();
		
		String sqlStatement = "insert into coursecredit (year, semester, courseCode, courseName, kind, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year, semester, courseCode, courseName, kind, credit}) == 1);
	}
	
	public boolean update(CourseAndCredit courseandcredit) {
		int year = courseandcredit.getYear();
		int semester = courseandcredit.getSemester();
		String courseCode = courseandcredit.getcourseCode();
		String courseName = courseandcredit.getcourseName();
		String kind = courseandcredit.getkind();
		int credit = courseandcredit.getCredit();
		
		String sqlStatement = "update coursecredit set year=?, semester=?, courseName=?, kind=?, credit=? where courseCode=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year, semester, courseName, kind, credit, courseCode}) == 1);
	}
	
	public boolean delete(String courseCode) {
		String sqlStatement = "delete from coursecredit where courseCode=?";
		
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{courseCode}) == 1);
	}

	public List<CourseAndCredit> getYearAndSemester() {
		String sqlStatement = "select distinct year, semester from coursecredit where year!=2017";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<CourseAndCredit>() {

			@Override
			public CourseAndCredit mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				CourseAndCredit courseandcredit = new CourseAndCredit();

				courseandcredit.setYear(rs.getInt("year"));
				courseandcredit.setSemester(rs.getInt("semester"));
				
				return courseandcredit;
			}
		});
	}

	public List<CourseAndCredit> getCourseBySemester(int year, int semester) {
		String sqlStatement = "select * from coursecredit where year=? and semester=?";

		return (jdbcTemplateObject.query(sqlStatement, new Object[]{year, semester}, new DataMapper()));
	}
	
	public int getCreditBySemester(int year, int semester) {
		String sqlStatement = "select sum(credit) from coursecredit where year=? and semester=?";
		
		return (jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{year, semester}, Integer.class));
	}
	
	public List<CourseAndCredit> getKindList() {
		String sqlStatement = "select distinct kind from coursecredit";

		return jdbcTemplateObject.query(sqlStatement, new RowMapper<CourseAndCredit>() {

			@Override
			public CourseAndCredit mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				CourseAndCredit courseandcredit = new CourseAndCredit();

				courseandcredit.setkind(rs.getString("kind"));
				
				return courseandcredit;
			}
		});
	}
	
	public int getCreditByKind(String kind) {
		String sqlStatement = "select sum(credit) from coursecredit where kind=? and year!=2017";
		
		return (jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{kind}, Integer.class));
	}
	
	public int getSumCredit() {
		String sqlStatement = "select sum(credit) from coursecredit where year!=2017";

		return (jdbcTemplateObject.queryForObject(sqlStatement, Integer.class));
	}

	public List<CourseAndCredit> getRegisteredCourses() {
		String sqlStatement = "select * from coursecredit where year=2017 and semester=1";

		return (jdbcTemplateObject.query(sqlStatement, new DataMapper()));
	}
}

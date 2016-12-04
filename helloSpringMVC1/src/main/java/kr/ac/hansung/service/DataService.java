package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.DataDAO;
import kr.ac.hansung.model.CourseAndCredit;

@Service
public class DataService {
	
	private DataDAO datadao;

	@Autowired
	public void setdatadao(DataDAO datadao) {
		this.datadao = datadao;
	}
	
	public List<CourseAndCredit> getYearAndSemester() {
		return datadao.getYearAndSemester();
	}
	
	public List<CourseAndCredit> getCourseBySemester(int year, int semester) {
		return datadao.getCourseBySemester(year, semester);
	}
	
	public int getCreditBySemester(int year, int semester) {
		return datadao.getCreditBySemester(year, semester);
	}
	
	public List<CourseAndCredit> getKindList() {
		return datadao.getKindList();
	}
	
	public int getCreditByKind(String kind) {
		return  datadao.getCreditByKind(kind);
	}
	
	public int getSumCredit() {
		return datadao.getSumCredit();
	}
	
	public void insert(CourseAndCredit coursecredit) {
		datadao.insert(coursecredit);
	}
	
	public List<CourseAndCredit> getCourseRegistereds() {
		return datadao.getRegisteredCourses();
	}

}

package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.CourseAndCredit;
import kr.ac.hansung.service.DataService;

@Controller
public class DataController {
	
	private DataService courseService;
	
	@Autowired
	public void setCourseService(DataService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping("/CreditKindOfSemester")
	public String CreditKindOfSemester(Model model) {
		
		List<CourseAndCredit> creditBySemester = courseService.getYearAndSemester();
		
		for(int i=0; i<creditBySemester.size(); i++) {
			creditBySemester.get(i).setCredit(courseService.getCreditBySemester
					(creditBySemester.get(i).getYear(), creditBySemester.get(i).getSemester()));
		}
		
		model.addAttribute("coursecredit", creditBySemester);
		
		return "CreditKindOfSemester"; 
	}

	@RequestMapping("/CourseKindOfSemester")
	public String CourseKindOfSemester(Model model, String year, String semester) {
		
		List<CourseAndCredit> courseBySemesterList = 
				courseService.getCourseBySemester(Integer.parseInt(year), Integer.parseInt(semester));

		model.addAttribute("coursecredit", courseBySemesterList);

		return "CourseKindOfSemester";
	}

	@RequestMapping("/CreditKindOfDivision")
	public String CreditKindOfDivision(Model model) {

		List<CourseAndCredit> creditByDivisionList = courseService.getKindList();
		
		for(int i=0; i<creditByDivisionList.size(); i++) {
			creditByDivisionList.get(i).setCredit(courseService.getCreditByKind
					(creditByDivisionList.get(i).getkind()));
		}

		creditByDivisionList.add(new CourseAndCredit("ÃÑ ÇÐÁ¡", courseService.getSumCredit()));

		model.addAttribute("coursecredit", creditByDivisionList);

		return "CreditKindOfDivision";
	}
	
	@RequestMapping("/registercourses")
	public String registercourses(Model model) {
		
		model.addAttribute("coursecredit",new CourseAndCredit());
		
		return "CoursesRegister";
	}
	
	@RequestMapping("/doregister")
	public String doRegister(Model model, @Valid CourseAndCredit course, BindingResult result) {
		
		courseService.insert(course);
		
		return "SuccessRegister";
	}
	
	@RequestMapping("/CourseRegistereds")
	public String showCourseRegistered(Model model) {

		 List<CourseAndCredit> CourseRegisteredsrList = courseService.getCourseRegistereds();

		model.addAttribute("coursecredit", CourseRegisteredsrList);
		
		return "CourseRegistered";
	}
}

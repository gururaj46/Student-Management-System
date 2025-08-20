package com.student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.services.StudentServices;



@Controller
public class StudentControllers {
	@Autowired
	StudentServices service;
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student st ) {
		service.addStudent(st);
		return "index";
	}
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll,Model model){
		Student st = service.searchStudent(roll);
		 model.addAttribute("Student",st);
		return "displayStudent";
	}
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st ) {
		service.updateStudent(st);
		return "index";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll ) {
		service.deleteStudent(roll);
		return "index";
	}
	
	@GetMapping("/fetchAllStudents")
	public String fetchAllStudents(Model model){
		List<Student> stList =  service.fetchAllStudents();
		model.addAttribute("studentList",stList);
		return "displayAllStudents";
	}
	
	@GetMapping("/deleteAllStudents")
	public String deleteStudents(){
		service.deleteAllStudents();
		return "index";
	}
}

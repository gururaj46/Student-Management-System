package com.student.management.services;

import java.util.List;

import com.student.management.entities.Student;

public interface StudentServices {
	String addStudent(Student st);
	String updateStudent(Student st);
	Student searchStudent(int roll);
	String deleteStudent(int roll);
	
	List<Student> fetchAllStudents();
	String deleteAllStudents();
}

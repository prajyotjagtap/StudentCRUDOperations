package com.example.StudentCrud.service;

import java.util.List;

import com.example.StudentCrud.entity.Student;

public interface StudentService
{
	List<Student> getAllStudents();

	Student getStudentById(Long studId);

	Student createStudent(Student student);

	Student updateStudent(Long studId, Student student);

	void deleteStudent(Long studId);

	Student getStudentByContactNumber(String studCon);
}

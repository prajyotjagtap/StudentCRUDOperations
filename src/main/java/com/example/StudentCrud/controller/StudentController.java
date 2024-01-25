package com.example.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentCrud.entity.Student;
import com.example.StudentCrud.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<?> getAllStudents()
	{
		List<Student> students = studentService.getAllStudents();

		if (students.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("There is no single student found. Add a student first.");
		}

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/{studId}")
	public ResponseEntity<?> getStudentById(@PathVariable Long studId)
	{
		Student student = studentService.getStudentById(studId);

		List<Student> students = studentService.getAllStudents();

		if (student != null)
		{
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Student with ID " + studId + " not found. Please check and try again.");
		}
	}

	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody Student student)
	{

		if (studentService.getStudentByContactNumber(student.getStudCon()) != null)
		{
			return ResponseEntity.badRequest()
					.body("Contact number already exists. Please use another contact number.");
		}

		Student createdStudent = studentService.createStudent(student);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Student created successfully." + "\n" + "Student Info: " + createdStudent.toString());
	}

	@PutMapping("/{studId}")
	public ResponseEntity<?> updateStudent(@PathVariable Long studId, @RequestBody Student student)
	{
		Student updatedStudent = studentService.updateStudent(studId, student);
		if (updatedStudent != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Student with ID " + studId + "Updated successfully."
					+ "\n" + " Updated Info: " + updatedStudent.toString());
		} else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Student with ID " + studId + " not found. Please check and try again.");
		}
	}

	@DeleteMapping("/{studId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long studId)
	{
		Student student = studentService.getStudentById(studId);
		if (student != null)
		{
			studentService.deleteStudent(studId);
			return new ResponseEntity<>("Student with ID " + studId + " deleted.", HttpStatus.OK);
		} else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Student with ID " + studId + " not found. Please check ID and try again.");
		}
	}

}

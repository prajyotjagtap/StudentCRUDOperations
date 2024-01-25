package com.example.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.entity.Student;
import com.example.StudentCrud.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long studId)
	{
		return studentRepository.findById(studId).orElse(null);
	}

	@Override
	public Student createStudent(Student student)
	{
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long studId, Student student)
	{
		if (studentRepository.existsById(studId))
		{
			student.setStudId(studId);
			return studentRepository.save(student);
		}
		return null;
	}

	@Override
	public void deleteStudent(Long studId)
	{
		studentRepository.deleteById(studId);
	}

	@Override
	public Student getStudentByContactNumber(String studCon)
	{
		return studentRepository.findByStudCon(studCon);
	}
}

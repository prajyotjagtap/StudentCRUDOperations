package com.example.StudentCrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentCrud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	Student findByStudCon(String studCon);
}

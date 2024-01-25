package com.example.StudentCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studId;

	private String studName;
	private Integer studAge;
	private String studCourse;

	@Column(unique = true)
	private String studCon;

	public Student()
	{
		super();
	}

	public Student(Long studId, String studName, Integer studAge, String studCourse, String studCon)
	{
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.studCourse = studCourse;
		this.studCon = studCon;
	}

	@Override
	public String toString()
	{
		return "Student{" + "studId=" + studId + ", studName='" + studName + '\'' + ", studAge=" + studAge
				+ ", studCourse='" + studCourse + '\'' + ", studCon='" + studCon + '\'' + '}';
	} // we use this because after updating it has to show updated info with message

	public Long getStudId()
	{
		return studId;
	}

	public void setStudId(Long studId)
	{
		this.studId = studId;
	}

	public String getStudName()
	{
		return studName;
	}

	public void setStudName(String studName)
	{
		this.studName = studName;
	}

	public Integer getStudAge()
	{
		return studAge;
	}

	public void setStudAge(Integer studAge)
	{
		this.studAge = studAge;
	}

	public String getStudCourse()
	{
		return studCourse;
	}

	public void setStudCourse(String studCourse)
	{
		this.studCourse = studCourse;
	}

	public String getStudCon()
	{
		return studCon;
	}

	public void setStudCon(String studCon)
	{
		this.studCon = studCon;
	}

}

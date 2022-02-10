package com.mouritech.swagger3springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.swagger3springbootdemo.entity.Student;
import com.mouritech.swagger3springbootdemo.respository.StudentRepository;

@RestController
@RequestMapping("student/api/v1")
public class StudentController {
	
	@Autowired
	StudentRepository stdRepo;
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student){
		return stdRepo.save(student);
	}
	
	@GetMapping("/student/{sid}")
	public Student getStudentById(@PathVariable("sid") Long studentId) throws Exception{
		return stdRepo.findById(studentId)
				      .orElseThrow(() ->new Exception("student not found"));
	}

}

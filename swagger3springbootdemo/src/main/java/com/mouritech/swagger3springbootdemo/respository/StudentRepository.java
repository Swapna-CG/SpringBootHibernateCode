package com.mouritech.swagger3springbootdemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.swagger3springbootdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.springbootcrud.demo.Repository;

import com.springbootcrud.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Override
    List<Student> findAll();
}

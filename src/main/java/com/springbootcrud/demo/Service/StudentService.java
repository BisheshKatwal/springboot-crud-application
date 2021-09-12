package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<Student> findAll();

    Optional<Student> findById(Integer id);

    void saveStudent(Student student);

    void deleteStudent(Integer id);

    void assignProf(Integer stdId, Integer profId);

    void updateStudent(Student student, Integer id);


}

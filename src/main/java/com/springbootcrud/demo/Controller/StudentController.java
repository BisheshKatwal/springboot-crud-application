package com.springbootcrud.demo.Controller;

import com.springbootcrud.demo.Service.StudentService;
import com.springbootcrud.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("")
    public void createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentFromID(@PathVariable Integer studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Integer studentId) {
       studentService.updateStudent(student, studentId);
        return new ResponseEntity<>("Student data Updated Sucessfully!",HttpStatus.OK);
    }

    @PostMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @PostMapping("assign/{stdId}/to/{profId}")
    public ResponseEntity<String> assignProfToStd( @PathVariable(name = "stdId") Integer stdId, @PathVariable(name = "profId") Integer profId)
    {
        studentService.assignProf(stdId, profId);
        return new ResponseEntity<>("Professor Assigned to Student Sucessfully!", HttpStatus.OK);
    }

}

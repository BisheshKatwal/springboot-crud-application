package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.Repository.ProfessorRepository;
import com.springbootcrud.demo.Repository.StudentRepository;
import com.springbootcrud.demo.entity.Professor;
import com.springbootcrud.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public StudentServiceImpl() {
//        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void assignProf(Integer stdId, Integer profId) {
        Optional<Student> std = studentRepository.findById(stdId);
        Assert.isTrue(std.isPresent(),"Student not found!");
        Optional<Professor> prof = professorRepository.findById(profId);
        Assert.isTrue(prof.isPresent(),"Professor not found");

        std.get().setProfessor(prof.get());
        saveStudent(std.get());
    }

    @Override
    public void updateStudent(Student student, Integer id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        Assert.isTrue(studentOpt.isPresent(), "Student Not found for id: " + id);

        if (student.getName() != null)
            studentOpt.get().setName(student.getName());
        if (student.getAddress() != null)
            studentOpt.get().setAddress(student.getAddress());
        if (student.getGrade() != 0)
            studentOpt.get().setGrade(student.getGrade());
        if (student.getProfessor() != null)
            studentOpt.get().setProfessor(student.getProfessor());

        saveStudent(studentOpt.get());

    }
}

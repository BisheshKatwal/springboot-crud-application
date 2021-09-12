package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.Repository.StudentRepository;
import com.springbootcrud.demo.entity.Professor;
import com.springbootcrud.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService = new StudentServiceImpl();

    @Mock
    Professor professor;
//    public Professor professor = new Professor(1, "Prof. SS", "Kirtipur", "Maths");


    @Test
    public void testCreateStudents() {
        Student std = new Student(1, "Bishesh Katwal", "Bhaktapur", 12, professor);

        studentService.saveStudent(std);

        verify(studentRepository, times(1)).save(std);


    }

    @Test
    public void getAllStudentsTest() {

        List<Student> stdList = new ArrayList<>();
        Student std = new Student(1, "Bishesh Katwal", "Bhaktapur", 12, professor);
        Student stdTwo = new Student(2, "Bharat Joshi", "Lalitpur", 11, professor);

        stdList.add(std);
        stdList.add(stdTwo);

        when(studentRepository.findAll()).thenReturn(stdList);

        List<Student> list = studentService.findAll();
        assertEquals(2, list.size());
        verify(studentRepository, times(1)).findAll();

    }

    @Test
    public void testGetStudentById() {

        Student std = new Student(1, "Bishesh Katwal", "Bhaktapur", 12, professor);
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(std));

        Optional<Student> stdOpt = studentService.findById(1);
        assertEquals(stdOpt.get().getName(), std.getName());
        assertEquals(stdOpt.get().getAddress(), std.getAddress());
        assertEquals(stdOpt.get().getGrade(), std.getGrade());
        assertEquals(stdOpt.get().getProfessor(), std.getProfessor());

    }

    @Test
    public void testUpdateStudents() {
        Student oldStd = new Student(1, "Bishesh Katwal", "Bhaktapur", 12, professor);
        Student newStd = new Student(2, "Bishesh Katwal", "Kaushaltar", 13, professor);

        when(studentRepository.findById(1)).thenReturn(Optional.of(oldStd));

//
        studentService.updateStudent(newStd, 1);

        assertEquals(newStd.getName(), oldStd.getName());
        assertEquals(newStd.getAddress(), oldStd.getAddress());
        assertEquals(newStd.getGrade(), oldStd.getGrade());
    }

    @Test
    public void testDeleteStudent() {
        Student std = new Student(1, "Bishesh Katwal", "Bhaktapur", 12, professor);
//        when(studentRepository.findById(1)).thenReturn(Optional.of(std));
        studentService.saveStudent(std);
        studentService.deleteStudent(1);
        List<Student> studentOptional = studentService.findAll();
        assertEquals(0, studentOptional.size());
        // checking the no. of times the delete method is called
        verify(studentRepository, times(1)).deleteById(1);


    }

}
package com.springbootcrud.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name="name", length = 25)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "grade")
    private Integer grade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    //constructors
    public Student(Integer id, String name, String address, Integer grade, Professor professor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.grade = grade;
        this.professor = professor;
    }


    public Student() {

    }

    //Getter and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}

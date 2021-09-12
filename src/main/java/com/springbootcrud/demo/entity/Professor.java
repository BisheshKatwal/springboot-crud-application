package com.springbootcrud.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", length = 30)
    private Integer profId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "subject", length = 30)
    private String subject;

    @OneToMany(mappedBy = "professor")
    private List<Student> students;

    //Constructors

    public Professor(Integer profId, String name, String address, String subject) {
        this.profId = profId;
        this.name = name;
        this.address = address;
        this.subject = subject;
    }

    public Professor()
    {

    }


    //Getters and Setters

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

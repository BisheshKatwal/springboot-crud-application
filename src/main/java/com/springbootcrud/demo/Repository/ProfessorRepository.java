package com.springbootcrud.demo.Repository;

import com.springbootcrud.demo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor,Integer> {

}

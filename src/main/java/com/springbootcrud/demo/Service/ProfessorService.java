package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {

    List<Professor> findAll();

    Optional<Professor> findById(Integer profId);

    void saveProfessor(Professor professor);

    void deleteProfessorById(Integer profId);

    void updateProfessor(Professor professor, Integer profId);
}

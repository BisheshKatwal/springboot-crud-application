package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.Repository.ProfessorRepository;
import com.springbootcrud.demo.entity.Professor;
import com.springbootcrud.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(Integer profId) {
        return professorRepository.findById(profId);
    }

    @Override
    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);

    }

    @Override
    public void deleteProfessorById(Integer profId) {
        Optional<Professor> prof = professorRepository.findById(profId);
        Assert.isTrue(prof.isPresent(), "No professor found with id: " + profId);
        professorRepository.deleteById(profId);

    }

    @Override
    public void updateProfessor(Professor professor, Integer profId) {
        Optional<Professor> professorOptional = findById(profId);
        Assert.isTrue(professorOptional.isPresent(), "Student Not found for id: " + profId);

        if (professor.getName() != null)
            professorOptional.get().setName(professor.getName());
        if (professor.getAddress() != null)
            professorOptional.get().setAddress(professor.getAddress());
        if (professor.getSubject() != null)
            professorOptional.get().setSubject(professor.getSubject());

        saveProfessor(professorOptional.get());
    }
}

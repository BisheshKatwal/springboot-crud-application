package com.springbootcrud.demo.Service;

import com.springbootcrud.demo.Repository.ProfessorRepository;
import com.springbootcrud.demo.entity.Professor;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorServiceImplTest {

    @Mock
    ProfessorRepository professorRepository;

    @InjectMocks
    ProfessorService professorService = new ProfessorServiceImpl();

    @Test
    public void testCreateProfessor()
    {
        Professor prof = new Professor(1," Prof. SS","Kirtipur","Maths");
        professorService.saveProfessor(prof);

        verify(professorRepository,times(1)).save(prof);
    }

    @Test
    public void testGetAllProfessors()
    {
        List<Professor> professorList = new ArrayList<>();
        Professor profOne = new Professor(1," Prof. SS","Kirtipur","Maths");
        Professor profTwo = new Professor(2," Prof. AK","Pulchowk","Science");

        professorList.add(profOne);
        professorList.add(profTwo);

        when(professorRepository.findAll()).thenReturn(professorList);

        List<Professor> professors = professorService.findAll();
        assertEquals(2,professors.size());
        assertEquals(professorList.size(),professors.size());
    }

    @Test
    public void testGetProfById()
    {
        Professor prof = new Professor(1," Prof. SS","Kirtipur","Maths");
        when(professorRepository.findById(1)).thenReturn(java.util.Optional.of(prof));

        Optional<Professor> professor = professorService.findById(1);
        assertEquals(prof.getName(),professor.get().getName());
        assertEquals(prof.getAddress(),professor.get().getAddress());
        assertEquals(prof.getSubject(),professor.get().getSubject());

    }

    @Test
    public void testUpdateProfessor()
    {
        Professor oldProf = new Professor(1," Prof. SS","Kirtipur","Maths");
        Professor newProf = new Professor(1," Prof. AK","Pulchowk","Science");

        when(professorRepository.findById(1)).thenReturn(Optional.of(oldProf));
        professorService.updateProfessor(newProf,1);

        assertEquals(newProf.getName(),oldProf.getName());
        assertEquals(newProf.getAddress(),oldProf.getAddress());
        assertEquals(newProf.getSubject(),oldProf.getSubject());

    }

    @Test
    public void testDeleteProfessor()
    {
        Professor prof = new Professor(1," Prof. SS","Kirtipur","Maths");
       when(professorRepository.findById(1)).thenReturn(Optional.of(prof));
        professorService.saveProfessor(prof);

        professorService.deleteProfessorById(1);
        List<Professor> professors = professorService.findAll();
        assertEquals(0,professors.size());

        verify(professorRepository,times(1)).deleteById(1);


    }

}
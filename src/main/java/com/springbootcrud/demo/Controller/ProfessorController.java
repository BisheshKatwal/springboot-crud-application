package com.springbootcrud.demo.Controller;

import com.springbootcrud.demo.Service.ProfessorService;
import com.springbootcrud.demo.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("")
    public List<Professor> getAllProf()
    {
        return professorService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<String> createNewProf(@RequestBody Professor professor)
    {
        professorService.saveProfessor(professor);
        return new ResponseEntity<>("Professor Created Sucesfully!", HttpStatus.OK);
    }

    @PostMapping("/update/{profId}")
    public ResponseEntity<String> updateProf (@RequestBody Professor professor, @PathVariable Integer profId)
    {
        professorService.updateProfessor(professor,profId);
        return new ResponseEntity<>("Professor data updates sucessfully!",HttpStatus.OK);
    }

    @PostMapping("/delete/{profId}")
    public ResponseEntity<String> deleteProf(@PathVariable Integer profId)
    {
        try{
            professorService.deleteProfessorById(profId);
            return new ResponseEntity<>("Prof Deleted!", HttpStatus.OK);
        }
        catch (RuntimeException e)
        {
            return new ResponseEntity<>("Prof cannot be deleted(Assigned to student)!",HttpStatus.FORBIDDEN);
        }


    }
}

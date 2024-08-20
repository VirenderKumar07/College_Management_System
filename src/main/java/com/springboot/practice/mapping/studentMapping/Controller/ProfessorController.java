package com.springboot.practice.mapping.studentMapping.Controller;

import com.springboot.practice.mapping.studentMapping.Entities.ProfessorEntity;
import com.springboot.practice.mapping.studentMapping.Service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return  professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ProfessorEntity assignProfessorToStudent(@PathVariable Long professorId,
                                                    @PathVariable Long studentId){
        return professorService.assignProfessorToStudent(professorId, studentId);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public ProfessorEntity assignProfessorToSubject(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId){
        return professorService.assignProfessorToSubject(professorId, subjectId);
    }















}

package com.springboot.practice.mapping.studentMapping.Controller;

import com.springboot.practice.mapping.studentMapping.Entities.SubjectEntity;
import com.springboot.practice.mapping.studentMapping.Service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping(path ="/{subjectId}" )
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubjectRecord(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubjectRecord(subjectEntity);
    }


 }

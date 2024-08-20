package com.springboot.practice.mapping.studentMapping.Controller;

import com.springboot.practice.mapping.studentMapping.Entities.StudentEntity;
import com.springboot.practice.mapping.studentMapping.Entities.SubjectEntity;
import com.springboot.practice.mapping.studentMapping.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path= "/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentId){
        return studentService.createNewStudent(studentId);
    }

    @PutMapping(path = "/{studentId}/subjects/{subjectId}")
    public StudentEntity assignSubjectToStudent(@PathVariable Long studentId,
                                                @PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId, subjectId);
    }
}

package com.springboot.practice.mapping.studentMapping.Controller;


import com.springboot.practice.mapping.studentMapping.Entities.AdmissionEntity;
import com.springboot.practice.mapping.studentMapping.Service.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admission")
@RequiredArgsConstructor
public class AdmissionController {

    private final AdmissionService admissionService;


    @GetMapping(path = "/admission")
    public AdmissionEntity getAdmissionById(@PathVariable Long admissionId){
        return admissionService.getAdmissionById(admissionId);
    }

    @PostMapping
    public AdmissionEntity createNewStudentRecord(@RequestBody AdmissionEntity admissionId){
        return admissionService.createNewStudentRecord(admissionId);
    }

    @PutMapping(path = "/{admissionId}/student/{studentId}")
    public AdmissionEntity admissionRecordOfStudent(@RequestBody Long admissionId,
                                                    @RequestBody Long studentId){
        return admissionService.admissionRecordOfStudent(admissionId, studentId);
    }
}

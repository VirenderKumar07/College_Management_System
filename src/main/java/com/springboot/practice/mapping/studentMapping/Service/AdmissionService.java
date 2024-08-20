package com.springboot.practice.mapping.studentMapping.Service;

import com.springboot.practice.mapping.studentMapping.Entities.AdmissionEntity;
import com.springboot.practice.mapping.studentMapping.Entities.StudentEntity;
import com.springboot.practice.mapping.studentMapping.Repository.AdmissionRepository;
import com.springboot.practice.mapping.studentMapping.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmissionService {

    private  final StudentRepository studentRepository;
    private final AdmissionRepository admissionRepository;

    public AdmissionEntity getAdmissionById(Long admissionId) {
        return admissionRepository.findById(admissionId).orElse(null);

    }

    public AdmissionEntity createNewStudentRecord(AdmissionEntity admissionId) {
        return admissionRepository.save(admissionId);
    }

    public AdmissionEntity admissionRecordOfStudent(Long admissionId, Long studentId) {
        Optional<AdmissionEntity> admissionEntity=admissionRepository.findById(admissionId);
        Optional<StudentEntity> studentEntity=studentRepository.findById(studentId);

        return admissionEntity.flatMap(admission ->
                studentEntity.map(student -> {

                    admission.setStudent(student);
                    return admissionRepository.save(admission);
                })).orElse(null);
    }
}

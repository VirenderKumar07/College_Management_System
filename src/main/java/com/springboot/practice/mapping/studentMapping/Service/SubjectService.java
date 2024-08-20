package com.springboot.practice.mapping.studentMapping.Service;

import com.springboot.practice.mapping.studentMapping.Entities.SubjectEntity;
import com.springboot.practice.mapping.studentMapping.Repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createNewSubjectRecord(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}

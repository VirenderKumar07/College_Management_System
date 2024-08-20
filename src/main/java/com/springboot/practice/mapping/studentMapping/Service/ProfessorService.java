package com.springboot.practice.mapping.studentMapping.Service;

import com.springboot.practice.mapping.studentMapping.Entities.ProfessorEntity;
import com.springboot.practice.mapping.studentMapping.Entities.StudentEntity;
import com.springboot.practice.mapping.studentMapping.Entities.SubjectEntity;
import com.springboot.practice.mapping.studentMapping.Repository.ProfessorRepository;
import com.springboot.practice.mapping.studentMapping.Repository.StudentRepository;
import com.springboot.practice.mapping.studentMapping.Repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private  final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity=studentRepository.findById(studentId);

        return professorEntity.flatMap(professor ->
                studentEntity.map(student -> {
                    student.getProfessors().add(professor);
                    professor.getStudents().add(student);
                    professorRepository.save(professor);
                    return professor;
                })
        ).orElse(null);
    }

    public ProfessorEntity assignProfessorToSubject(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity=professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity =subjectRepository.findById(subjectId);


        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject->{
                    subject.setProfessors(professor);
                    subjectRepository.save(subject);

                    professor.getTeachingSubject().add(subject);
                    return professor;
                })
        ).orElse(null);

    }
}

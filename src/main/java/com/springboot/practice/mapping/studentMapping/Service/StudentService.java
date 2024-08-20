package com.springboot.practice.mapping.studentMapping.Service;

import com.springboot.practice.mapping.studentMapping.Entities.StudentEntity;
import com.springboot.practice.mapping.studentMapping.Entities.SubjectEntity;
import com.springboot.practice.mapping.studentMapping.Repository.StudentRepository;
import com.springboot.practice.mapping.studentMapping.Repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private  final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentId) {
        return studentRepository.save(studentId);

    }

    public StudentEntity assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional<StudentEntity> studentEntity=studentRepository.findById(studentId);
        Optional<SubjectEntity> subjectEntity=subjectRepository.findById(subjectId);

        return studentEntity.flatMap(student ->
                subjectEntity.map(subject -> {
                    subject.getStudents().add(student);
                    student.getSubjects().add(subject);
                    studentRepository.save(student);
                    return student;
                })
        ).orElse(null);
    }
}

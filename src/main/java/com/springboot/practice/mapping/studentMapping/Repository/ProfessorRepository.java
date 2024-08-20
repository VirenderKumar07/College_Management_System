package com.springboot.practice.mapping.studentMapping.Repository;

import com.springboot.practice.mapping.studentMapping.Entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}

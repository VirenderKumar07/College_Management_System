package com.springboot.practice.mapping.studentMapping.Repository;

import com.springboot.practice.mapping.studentMapping.Entities.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionEntity, Long> {
}

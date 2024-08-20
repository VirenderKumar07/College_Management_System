package com.springboot.practice.mapping.studentMapping.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private AdmissionEntity admission;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<ProfessorEntity> professors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student_subject_map",
            joinColumns = @JoinColumn(name = "Student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @JsonIgnore
    private Set<SubjectEntity> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}

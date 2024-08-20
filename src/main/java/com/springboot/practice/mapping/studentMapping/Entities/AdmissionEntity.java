package com.springboot.practice.mapping.studentMapping.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer fees;

    @OneToOne
    @JoinColumn(name = "Student_record")
    @JsonIgnore
    private StudentEntity student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdmissionEntity that)) return false;
        return getId() == that.getId() && Objects.equals(getFees(), that.getFees()) && Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFees());
    }
}

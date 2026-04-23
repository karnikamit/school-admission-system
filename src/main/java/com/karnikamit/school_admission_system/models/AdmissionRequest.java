package com.karnikamit.school_admission_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="admissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String address;

    @Column(name = "uniform_required")
    private boolean uniformRequired;
}

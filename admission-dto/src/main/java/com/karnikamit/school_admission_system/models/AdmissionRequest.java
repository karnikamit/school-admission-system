package com.karnikamit.school_admission_system.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="admission_request")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isUniformRequired() {
        return uniformRequired;
    }

    public void setUniformRequired(boolean uniformRequired) {
        this.uniformRequired = uniformRequired;
    }
}


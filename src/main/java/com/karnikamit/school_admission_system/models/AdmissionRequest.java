package com.karnikamit.school_admission_system.models;

public class AdmissionRequest {
    private String name;
    private int age;
    private String address;
    private boolean uniformRequired;

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

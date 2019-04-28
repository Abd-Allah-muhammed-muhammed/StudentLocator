package com.example.studentlocator;

public class ModelAttend {
    private String Student_id ;
    private String Material ;

    public ModelAttend(String student_id, String material) {
        Student_id = student_id;
        Material = material;
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }
}

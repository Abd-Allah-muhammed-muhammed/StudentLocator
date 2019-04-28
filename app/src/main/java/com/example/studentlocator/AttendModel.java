package com.example.studentlocator;

public class AttendModel {
    private String id ;
    private String materials_id;

    public AttendModel(String id, String materials_id) {
        this.id = id;
        this.materials_id = materials_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterials_id() {
        return materials_id;
    }

    public void setMaterials_id(String materials_id) {
        this.materials_id = materials_id;
    }
}

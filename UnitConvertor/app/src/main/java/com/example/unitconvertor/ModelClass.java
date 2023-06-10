package com.example.unitconvertor;

public class ModelClass {

    private String unit_name;
    private int imgid;

    public ModelClass(String unit_name, int imgid) {
        this.unit_name = unit_name;
        this.imgid = imgid;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}

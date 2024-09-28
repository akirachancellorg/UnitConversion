package com.apc.entjavamid40.model;

public class UnitLength {

    private String unit;
    private double value;

    public UnitLength(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public UnitLength() {
        
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
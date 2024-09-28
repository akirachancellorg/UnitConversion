package com.apc.entjavamid40.model;

public class ErrorResponse {
    private String error;
    private String value;
    private String unit1;
    private String unit2;

    public ErrorResponse(String errorMessage, String value, String unit1, String unit2) {
        this.error = errorMessage;
        this.value = value;
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    // Getters and setters
    public String getError() {
        return error;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }
}

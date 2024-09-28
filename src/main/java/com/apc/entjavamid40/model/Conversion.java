package com.apc.entjavamid40.model;

public class Conversion {

    public UnitLength from;
    private UnitLength to;

    public Conversion(UnitLength from, UnitLength to) {
        this.from = from;
        this.to = to;
    }

    public UnitLength getFrom() {
        return from;
    }

    public void setFrom(UnitLength from) {
        this.from = from;
    }

    public UnitLength getTo() {
        return to;
    }

    public void setTo(UnitLength to) {
        this.to = to;
    }

}
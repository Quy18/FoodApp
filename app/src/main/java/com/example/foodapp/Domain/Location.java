package com.example.foodapp.Domain;

public class Location {
    private int Id;
    private String Loc;

    public Location() {
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return Loc;
    }
}

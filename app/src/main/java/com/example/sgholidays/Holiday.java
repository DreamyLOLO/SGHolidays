package com.example.sgholidays;

public class Holiday {
    private String name;
    private String date;
    private int image;

    public Holiday(String name, String date, int image) {
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDate() { return date; }

    public int getImage() {
        return image;
    }


}

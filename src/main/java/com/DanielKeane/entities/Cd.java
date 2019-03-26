package com.DanielKeane.entities;

public class Cd {

    private String name;
    private String imageUrl;
    private String about;

    public Cd(String name, String imageUrl, String about) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}

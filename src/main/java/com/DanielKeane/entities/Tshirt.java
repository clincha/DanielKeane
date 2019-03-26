package com.DanielKeane.entities;

public class Tshirt {

    private String name;
    private String imageUrl;
    private int cost;

    public Tshirt(String name, String imageUrl, int cost) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cost=" + cost +
                '}';
    }
}

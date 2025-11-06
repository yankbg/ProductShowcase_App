package com.example.task08.Models;

public class ProductModel {

    private int imgpath;
    private int rating;
    private String name;
    private String price;

    public ProductModel() {
    }

    public ProductModel(int imgpath, int rating, String name, String price) {
        this.imgpath = imgpath;
        this.rating = rating;
        this.name = name;
        this.price = price;
    }

    public int getImgpath() {
        return imgpath;
    }

    public void setImgpath(int imgpath) {
        this.imgpath = imgpath;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

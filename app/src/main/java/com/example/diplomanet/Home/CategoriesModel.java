package com.example.diplomanet.Home;

public class CategoriesModel {
    int Image;
    String Titile;

    public CategoriesModel(int image, String titile) {
        Image = image;
        Titile = titile;
    }

    public int getImage() {
        return Image;
    }

    public String getTitile() {
        return Titile;
    }
}

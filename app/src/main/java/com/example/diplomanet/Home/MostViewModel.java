package com.example.diplomanet.Home;

public class MostViewModel {

    int ImageView;
    String TextView;

    public MostViewModel(int imageView, String textView) {
        ImageView = imageView;
        TextView = textView;
    }

    public int getImageView() {
        return ImageView;
    }

    public String getTextView() {
        return TextView;
    }
}

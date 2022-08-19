package com.example.bookshop.Model;

public class AnhQuangCao {
    private int id;
    private int image_anh;

    public AnhQuangCao() {
    }

    public AnhQuangCao(int id, int image_anh) {
        this.id = id;
        this.image_anh = image_anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage_anh() {
        return image_anh;
    }

    public void setImage_anh(int image_anh) {
        this.image_anh = image_anh;
    }
}

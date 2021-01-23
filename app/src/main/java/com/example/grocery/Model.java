package com.example.grocery;

public class Model {
    private int img;
    private String title,price,unit,quantity,discount;

    public Model(int id,String price,String discount,String title,String unit,String quantity)
    {
        img= id;
        this.price=price;
        this.discount=discount;
        this.title=title;
        this.unit=unit;
        this.quantity= quantity;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}

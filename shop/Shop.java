package com.ubb.shop.domain;

public class Shop {

    private String name;
    private String product;
    private String address;

    public Shop(String name, String product, String address) {
        this.name = name;
        this.product = product;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

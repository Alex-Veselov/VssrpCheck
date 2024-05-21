package com.service.Models;

import javax.persistence.*;

@Entity
@Table(name = "Phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Description")
    private String description;

    @Column(name = "Availability")
    private Boolean availability;

    // Конструкторы, геттеры и сеттеры

    public Phone() {
    }

    public Phone(String brand, String model, Double price, String description, Boolean availability) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}

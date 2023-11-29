package com.car.proauto.domain.items.car.model;

import com.car.proauto.domain.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class CarModel extends BaseModel {

    @Column(name = "manufacturer",nullable = false)
    private String manufacturer;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "yearOfRelease",nullable = false)
    private Integer yearOfRelease;

    @Column(name = "volume",nullable = false)
    private Double volume;

    @Column(name = "emergency",nullable = false)
    private Boolean emergency;

    public CarModel() {
    }

    public CarModel(String manufacturer, String name, String description, Double price, Integer yearOfRelease, Double volume, Boolean emergency) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.description = description;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.volume = volume;
        this.emergency = emergency;
    }

}

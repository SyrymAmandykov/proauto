package com.car.proauto.domain.items.user.model;

import com.car.proauto.domain.base.BaseModel;
import com.car.proauto.domain.items.car.model.CarModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "users")
@Getter
@Setter
public class UserModel extends BaseModel {

    @Column(name = "userName",nullable = false)
    private String login;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CarModel> cars;

    public UserModel() {
    }

    public UserModel(String login, String password, String name, String lastName, List<CarModel> cars) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.cars = cars;
    }
}

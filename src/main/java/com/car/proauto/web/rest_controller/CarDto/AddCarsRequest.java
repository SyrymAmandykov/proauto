package com.car.proauto.web.rest_controller.CarDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCarsRequest {

    private String manufacturer;
    private String name;
    private String description;
    private Double price;
    private Integer yearOfRelease;
    private Double volume;
    private Boolean emergency;


}

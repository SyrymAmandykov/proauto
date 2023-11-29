package com.car.proauto.domain.items.car.dto;

import com.car.proauto.domain.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDto implements BaseDto {

    private String manufacturer;
    private String name;
    private String description;
    private Double price;
    private Integer yearOfRelease;
    private Double volume;
    private Boolean emergency;
}

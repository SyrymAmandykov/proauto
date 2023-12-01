package com.car.proauto.domain.items.car.service;

import com.car.proauto.domain.items.car.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto addNewCar(String manufacturer,String name,String description,Double price,Integer yearOfRelease,Double volume,Boolean emergency);
    List<CarDto> getAllCarsByManufacturer(String manufacturer);
    CarDto getCarById(Long id);
    CarDto updateCar(Long id,String manufacturer,String name,String description,Double price,Integer yearOfRelease,Double volume,Boolean emergency);
    void deleteCarById(Long id);
}

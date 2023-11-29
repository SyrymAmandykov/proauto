package com.car.proauto.domain.items.car.service;

import com.car.proauto.domain.items.car.CarMapper;
import com.car.proauto.domain.items.car.dto.CarDto;
import com.car.proauto.domain.items.car.model.CarModel;
import com.car.proauto.domain.items.car.model.CarRepository;
import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplements implements CarService {
    private final CarMapper carMapper;
    private final CarRepository carRepository;


    public CarServiceImplements(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto addNewCar(String manufacturer, String name, String description, Double price, Integer yearOfRelease, Double volume, Boolean emergency) {
        CarModel carModel = carRepository.save(
                new CarModel(
                        manufacturer,
                        name,
                        description,
                        price,
                        yearOfRelease,
                        volume,
                        emergency
                        )

        );

        return carMapper.toDtoCar(carModel);
    }

    @Override
    public List<CarDto> getAllCarsByManufacturer(String manufacturer){
        List<CarModel> carModel = carRepository.findAllCarsByManufacturer(manufacturer);
        return carModel.stream()
                .map(CarMapper::toDtoCar)
                .toList();
    }

    @Override
    public CarDto getCarById(Long id) {
        CarModel carModel = carRepository.findById(id);
        return CarMapper.toDtoCar(carModel);
    }

    @Override
    public CarDto updateCar(Long id,String manufacturer,String name,String description,Double price,Integer yearOfRelease,Double volume,Boolean emergency) {
        CarModel updatedCarModel = carRepository
                .findById(id)
                .orElseThrow();
        if (updatedCarModel.getId() == null) {
            throw new IllegalArgumentException(("Car id not found"));
        }

        updatedCarModel.setId(id);
        updatedCarModel.setManufacturer(manufacturer);
        updatedCarModel.setName(name);
        updatedCarModel.setDescription(description);
        updatedCarModel.setPrice(price);
        updatedCarModel.setYearOfRelease(yearOfRelease);
        updatedCarModel.setVolume(volume);
        updatedCarModel.setEmergency(emergency);


        return carMapper.toDtoCar(updatedCarModel);

    }

    @Override
    public void deleteCarById(Long id) {
        carRepository
                .deleteById(id);
    }

}

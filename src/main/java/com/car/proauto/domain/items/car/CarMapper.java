package com.car.proauto.domain.items.car;

import com.car.proauto.domain.items.car.dto.CarDto;
import com.car.proauto.domain.items.car.model.CarModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CarMapper {

    CarDto toDtoCar(CarModel carModel);

    CarModel toModelCar(CarDto carDto);
}

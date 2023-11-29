package com.car.proauto.domain.items.car.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Long> {

    List<CarModel> findAllCarsByManufacturer(String manufacturer);
}

package com.car.proauto.domain.items.user.service;

import com.car.proauto.domain.items.car.model.CarModel;
import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.dto.UserPublicDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);
    UserPublicDto getUserByDetails(Long id);

    UserDto updateUser(Long id, String login, String password, String name, String lastName,List<Long> carsIds);

    void deleteUserById(Long id);

    /*Login*/
    UserDto getUserByLoginAndPassword(String login, String password);
}

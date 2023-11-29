package com.car.proauto.domain.items.user.service;

import com.car.proauto.domain.items.car.model.CarModel;
import com.car.proauto.domain.items.car.model.CarRepository;
import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.dto.UserPublicDto;
import com.car.proauto.domain.items.user.model.UserModel;
import com.car.proauto.domain.items.user.model.UserRepository;
import com.car.proauto.domain.items.user.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final UserMapper userMapper;

    public UserServiceImplements(UserRepository userRepository, CarRepository carRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto addNewUser(String login, String password, String name, String lastName) {
        UserModel userModel = userRepository.save(
                new UserModel(
                        login,
                        password,
                        name,
                        lastName,
                        new ArrayList<CarModel>()
                )
        );

        return userMapper.toDtoUser(userModel);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserModel> userModel = userRepository.findAll();
        return userModel.stream()
                .map(UserMapper::toDtoUser)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        UserModel userModel = userRepository.findById(id);
        return userMapper.toDtoUser(userModel);
    }

    @Override
    public UserPublicDto getUserByDetails(Long id){
        UserModel userModel = userRepository.findById(id);
        return userMapper.toPublicUser(userModel);
    }


    @Override
    public UserDto getUserByLoginAndPassword(String login, String password) {
        UserModel userModel = userRepository.findFirstByLoginAndPassword(login,password);
        return userMapper.toDtoUser(userModel);
    }

    @Override
    public UserDto updateUser(Long id, String login, String password, String name, String lastName, List<Long> carsIds) {
        UserModel updatedUserModel = userRepository
                .findById(id)
                .orElseThrow();
        List<CarModel> updatedCar = carRepository.findAllById(carsIds);

        if (updatedUserModel.getId() == null) {
            throw new IllegalArgumentException(("User id not found"));
        }

        updatedUserModel.setId(id);
        updatedUserModel.setLogin(login);
        updatedUserModel.setPassword(password);
        updatedUserModel.setName(name);
        updatedUserModel.setLastName(lastName);
        updatedUserModel.setCars(updatedCar);

        return userMapper.toDtoUser(updatedUserModel);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository
                .deleteById(id);
    }
}

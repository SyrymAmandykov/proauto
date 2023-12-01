package com.car.proauto.web.rest_controller;

import com.car.proauto.domain.items.car.CarMapper;
import com.car.proauto.domain.items.car.service.CarService;
import com.car.proauto.domain.items.user.UserMapper;
import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.service.UserService;
import com.car.proauto.web.rest_controller.CarDto.AddCarsRequest;
import com.car.proauto.web.rest_controller.userDto.AddUsersRequest;
import com.car.proauto.web.rest_controller.userDto.GetAllUsersResponse;
import com.car.proauto.web.rest_controller.userDto.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final CarService carService;
    private final UserMapper userMapper;
    private final CarMapper carMapper;

    public UserController(UserService userService, CarService carService, UserMapper userMapper, CarMapper carMapper) {
        this.userService = userService;
        this.carService = carService;
        this.userMapper = userMapper;
        this.carMapper = carMapper;
    }


    @GetMapping("/users")
    @ResponseBody
    public GetAllUsersResponse getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new GetAllUsersResponse(users);
    }

    @PostMapping("/users")
    @ResponseBody
    public UserDto addNewUser(
            @RequestBody AddUsersRequest addUsersRequest
            ) {
        return userService.addNewUser(
                addUsersRequest.getLogin(),
                addUsersRequest.getPassword(),
                addUsersRequest.getName(),
                addUsersRequest.getLastName()
        );
    }

//    @PutMapping("/users")
//    @ResponseBody
//    public UserDto updateUser(
//            @RequestBody UpdateUserRequest updateUserRequest
//            ) {
//
//        return userService.updateUser(
//                updateUserRequest.getId(),
//                updateUserRequest.getLogin(),
//                updateUserRequest.getPassword(),
//                updateUserRequest.getName(),
//                updateUserRequest.getLastName(),
//                updateUserRequest.getCars()
//                        .stream()
//                        .map(carMapper::toDtoCar)
//                        .toList()
//        );
//    }
}

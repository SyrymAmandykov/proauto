package com.car.proauto.domain.items.user.dto;

import com.car.proauto.domain.base.BaseDto;
import com.car.proauto.domain.items.car.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto implements BaseDto {

    private Long id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private List<CarDto> cars;
}

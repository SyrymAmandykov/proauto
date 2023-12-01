package com.car.proauto.web.rest_controller.userDto;

import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.dto.UserPublicDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPublicUsersResponse {

    private List<UserPublicDto> users;
}

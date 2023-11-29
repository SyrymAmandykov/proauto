package com.car.proauto.domain.items.user;

import com.car.proauto.domain.items.car.CarMapper;
import com.car.proauto.domain.items.user.dto.UserDto;
import com.car.proauto.domain.items.user.dto.UserPublicDto;
import com.car.proauto.domain.items.user.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {CarMapper.class},injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    //подтяни с модельки все параметры что обьявлены внутри UserDto
    UserDto toDtoUser(UserModel userModel);

    //подтяни с модельки лишь те что обьявлены внутри UserPublicDto
    UserPublicDto toPublicUser(UserModel userModel);

    //и наоборот
    UserModel toModelUser(UserDto userDto);
    UserModel toModelPublicUser(UserPublicDto userPublicDto);
}

package com.swino.microservicespring.mapper;

import com.swino.microservicespring.dto.UserDto;
import com.swino.microservicespring.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto userEntityToUserDto(UserEntity user);
    UserEntity userDtoToUserEntity(UserDto userDto);
}

package com.armatin.dto.UserDto;

import com.armatin.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    UserDto toDto(User user);

    @Mappings({
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "password", target = "password")
            })
    User toEntity(UserDto userDto);
}

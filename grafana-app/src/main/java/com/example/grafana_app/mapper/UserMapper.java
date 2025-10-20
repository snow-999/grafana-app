package com.example.grafana_app.mapper;

import com.example.grafana_app.dto.UserDto;
import com.example.grafana_app.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
        UserDto mapToDto(UserEntity userEntity);
        UserEntity mapToEntity(UserDto userDto);
}

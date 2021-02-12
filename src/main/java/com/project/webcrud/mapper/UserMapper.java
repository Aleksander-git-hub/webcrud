
package com.project.webcrud.mapper;

import com.project.webcrud.dto.UserDto;
import com.project.webcrud.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserDto userDto);

    UserDto toDto(UserEntity userEntity);
}

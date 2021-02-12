package com.project.webcrud.mapper;

import com.project.webcrud.dto.PlainUserDto;
import com.project.webcrud.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlainUserMapper {

    PlainUserDto toPlainDto(UserEntity userEntity);
}

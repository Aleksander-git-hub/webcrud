package com.project.webcrud.dto;

import com.project.webcrud.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlainUserDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private Integer age;

    private Boolean deleted;

public static PlainUserDto toDto(UserEntity userEntity) {
        PlainUserDto plainUserDto = new PlainUserDto();
        plainUserDto.setId(userEntity.getId());
        plainUserDto.setFirstName(userEntity.getFirstName());
        plainUserDto.setSecondName(userEntity.getSecondName());
        plainUserDto.setEmail(userEntity.getEmail());
        plainUserDto.setDeleted(userEntity.getDeleted());
        return plainUserDto;
    }

}

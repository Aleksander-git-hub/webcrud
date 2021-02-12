package com.project.webcrud.dto;

import com.project.webcrud.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private Integer age;

    private Boolean deleted;

    private List<BookDto> books;

   /* public static UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setSecondName(userEntity.getSecondName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setDeleted(userEntity.getDeleted());
        userDto.setBooksDto(userEntity.getBooks().stream().map(BookDto::toDto).collect(Collectors.toList()));
        return userDto;
    }*/
}

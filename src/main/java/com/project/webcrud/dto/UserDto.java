package com.project.webcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private List<PlainBookDto> books;
    //private List<BookDto> books;
}

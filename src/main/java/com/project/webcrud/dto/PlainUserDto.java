package com.project.webcrud.dto;

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
}

package com.project.webcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlainBookDto {

    private Long id;

    private String title;

    private Double price;

    private Boolean deleted;
}

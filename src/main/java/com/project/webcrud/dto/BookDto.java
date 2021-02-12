package com.project.webcrud.dto;

import com.project.webcrud.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    private Double price;

    private Boolean deleted;

    private PlainUserDto user;
    //private PlainUserDto plainUserDto;

    /*public static BookDto toDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setPrice(bookEntity.getPrice());
        bookDto.setPlainUserDto(PlainUserDto.toDto(bookEntity.getUser()));
        return bookDto;
    }*/
}

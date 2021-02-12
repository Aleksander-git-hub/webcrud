package com.project.webcrud.entity;

import com.project.webcrud.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;

    private Boolean deleted = false;

    @ManyToOne
    private UserEntity user;

    /*public static BookEntity toEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity
    }*/
}

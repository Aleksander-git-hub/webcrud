package com.project.webcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private Integer age;

    private Boolean deleted = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<BookEntity> books;
}

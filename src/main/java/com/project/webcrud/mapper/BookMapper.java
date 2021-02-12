package com.project.webcrud.mapper;

import com.project.webcrud.dto.BookDto;
import com.project.webcrud.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(BookDto bookDto);

    BookDto toDto(BookEntity bookEntity);
}

package com.project.webcrud.mapper;

import com.project.webcrud.dto.PlainBookDto;
import com.project.webcrud.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlainBookMapper {

    PlainBookDto toPlainDto(BookEntity bookEntity);
}

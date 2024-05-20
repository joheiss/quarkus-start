package com.jovisco.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jovisco.domain.Book;
import com.jovisco.dtos.BookDto;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    Book toEntity(BookDto dto);
    BookDto toDto(Book book);

}

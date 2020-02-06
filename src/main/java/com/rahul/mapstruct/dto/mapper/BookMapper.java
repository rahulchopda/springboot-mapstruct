package com.rahul.mapstruct.dto.mapper;


import com.rahul.mapstruct.dao.entity.Book;
import com.rahul.mapstruct.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {LibraryMapper.class})
public interface BookMapper extends EntityMapper<BookDTO, Book> {
    
    @Mapping(source = "library.id", target = "libraryId")
    BookDTO toDataObject(final Book book);
    
    List<BookDTO> toDataObject(final List<Book> book);
    
    @Mapping(source = "libraryId", target = "library")
    Book toEntity(final BookDTO bookDTO);
    
    List<Book> toEntity(final List<BookDTO> bookDTOs);
    
    default Book fromId(final UUID id) {
        if (id == null) {
            return null;
        }
        final Book book = new Book();
        book.setId(id);
        return book;
    }
}

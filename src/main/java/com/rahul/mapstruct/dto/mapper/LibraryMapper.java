package com.rahul.mapstruct.dto.mapper;

import com.rahul.mapstruct.dao.entity.Library;
import com.rahul.mapstruct.dto.LibraryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface LibraryMapper extends EntityMapper<LibraryDTO, Library> {
    
    @Mapping(source = "books", target = "bookDTOs")
    LibraryDTO toDataObject(final Library library);
    
    Library toEntity(final LibraryDTO libraryDTO);
    
    default Library fromId(final UUID id) {
        if (id == null) {
            return null;
        }
        final Library library = new Library();
        library.setId(id);
        return library;
    }
    
}

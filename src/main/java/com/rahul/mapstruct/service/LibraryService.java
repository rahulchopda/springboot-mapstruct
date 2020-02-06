package com.rahul.mapstruct.service;

import com.rahul.mapstruct.dao.entity.Book;
import com.rahul.mapstruct.dao.entity.Library;
import com.rahul.mapstruct.dao.repository.BookRepository;
import com.rahul.mapstruct.dao.repository.LibraryRepository;
import com.rahul.mapstruct.dto.LibraryDTO;
import com.rahul.mapstruct.dto.mapper.BookMapper;
import com.rahul.mapstruct.dto.mapper.LibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LibraryService {
    
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final LibraryMapper libraryMapper;
    private final BookMapper bookMapper;
    
    @Autowired
    public LibraryService(final LibraryRepository libraryRepository, final BookRepository bookRepository, final LibraryMapper libraryMapper, final BookMapper bookMapper) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
        this.libraryMapper = libraryMapper;
        this.bookMapper = bookMapper;
    }
    
    public LibraryDTO save(final LibraryDTO libraryDTO) {
        final Library library = libraryMapper.toEntity(libraryDTO);
        final Library createdLibrary = libraryRepository.save(library);
        final List<Book> books = new ArrayList<>();
        
        libraryDTO.getBookDTOs().forEach(bookDTO -> {
            final Book book = bookMapper.toEntity(bookDTO);
            book.setLibrary(createdLibrary);
            books.add(book);
        });
        createdLibrary.setBooks(books);
        bookRepository.saveAll(books);
        return libraryMapper.toDataObject(createdLibrary);
    }
}


package com.darllen.sizani.service;

import com.darllen.sizani.dto.BookDTO;
import com.darllen.sizani.dto.ResponseDTO;
import com.darllen.sizani.entity.Book;
import com.darllen.sizani.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    public BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseDTO create(BookDTO bookDTO){

        Book bookToSave = Book.builder()
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .author(bookDTO.getAuthor())
                .publisher(bookDTO.getPublisher())
                .build();

        Book savedBook = bookRepository.save(bookToSave);
        return ResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();
    }
}

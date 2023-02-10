package com.darllen.sizani.service;

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

    public ResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return ResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();
    }
}

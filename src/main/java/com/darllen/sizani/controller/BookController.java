package com.darllen.sizani.controller;

import com.darllen.sizani.dto.ResponseDTO;
import com.darllen.sizani.entity.Book;
import com.darllen.sizani.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    public BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping()
    public ResponseDTO create(@RequestBody Book book){
        Book savedBook = bookRepository.save(book);
        return ResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();
    }
}

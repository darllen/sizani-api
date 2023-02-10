package com.darllen.sizani.controller;

import com.darllen.sizani.dto.ResponseDTO;
import com.darllen.sizani.entity.Book;
import com.darllen.sizani.repository.BookRepository;
import com.darllen.sizani.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    public BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseDTO create(@RequestBody Book book){
        return bookService.create(book);
    }
}

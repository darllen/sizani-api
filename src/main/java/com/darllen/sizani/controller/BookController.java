package com.darllen.sizani.controller;

import com.darllen.sizani.dto.BookDTO;
import com.darllen.sizani.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    public BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @PostMapping()
//    public ResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
//        return bookService.create(bookDTO);
//    }

    @PostMapping
    @ResponseBody
    private String create(@RequestBody BookDTO book){
        BookDTO savedBook = bookService.create(book);
        return "Book created with ID: " + savedBook.getId();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BookDTO getByID(@PathVariable Long id){
        return bookService.getByID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Long id){
        return bookService.delete(id);
    }

    @GetMapping
    @ResponseBody
    public List<BookDTO> getAll(){
        return bookService.getAll();
    }
}

package com.darllen.sizani.service;

import com.darllen.sizani.dto.BookDTO;
import com.darllen.sizani.dto.ResponseDTO;
import com.darllen.sizani.entity.Book;
import com.darllen.sizani.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    public BookRepository bookRepository;
    private static final Map<Long, BookDTO> books = new HashMap<>();


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public ResponseDTO create(BookDTO bookDTO){
//
//        Book bookToSave = Book.builder()
//                .title(bookDTO.getTitle())
//                .isbn(bookDTO.getIsbn())
//                .author(bookDTO.getAuthor())
//                .publisher(bookDTO.getPublisher())
//                .build();
//
//        Book savedBook = bookRepository.save(bookToSave);
//        return ResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();
//    }

    public BookDTO create(BookDTO book) {
        Long id = books.keySet().size() + 1L;
        book.setId(id);

        books.put(id, book);
        return book;
    }

    public BookDTO getByID(Long id) {
        return books.get(id);
    }

    public List<BookDTO> getAll() {
        return new ArrayList<>(books.values());
    }

    public String delete(Long id) {
        books.remove(id);
        return "deleted!";
    }
}

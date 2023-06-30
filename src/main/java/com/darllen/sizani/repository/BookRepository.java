package com.darllen.sizani.repository;

import com.darllen.sizani.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

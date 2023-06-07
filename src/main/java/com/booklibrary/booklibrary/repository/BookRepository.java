package com.booklibrary.booklibrary.repository;

import com.booklibrary.booklibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByName(String name);
}

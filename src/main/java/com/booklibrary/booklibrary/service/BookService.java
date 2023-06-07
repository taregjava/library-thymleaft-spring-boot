package com.booklibrary.booklibrary.service;

import com.booklibrary.booklibrary.entity.Book;


import java.util.List;


public interface BookService {


    public Book saveBook(Book book);

    String checkUnique(Integer id, String name);

    List<Book> getAllBook();
}

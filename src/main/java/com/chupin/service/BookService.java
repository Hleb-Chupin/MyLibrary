package com.chupin.service;

import com.chupin.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(int id);

    void save(Book book);

    void update(Book book);

    void delete(Book book);
}

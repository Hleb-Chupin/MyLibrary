package com.chupin.dao;

import com.chupin.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAll();

    Book getById(int id);

    void save(Book book);

    void update(Book book);

    void deleteById(Book book);
}

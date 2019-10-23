package com.chupin.service;

import com.chupin.dao.BookDAO;
import com.chupin.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAll() {
        return this.bookDAO.getAll();
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return this.bookDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Book book) {
        this.bookDAO.save(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        this.bookDAO.update(book);

    }

    @Override
    @Transactional
    public void delete(Book book) {
        this.bookDAO.deleteById(book);
    }
}

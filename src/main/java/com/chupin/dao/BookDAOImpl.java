package com.chupin.dao;

import com.chupin.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList =  session.createQuery("from Book").list();
        return bookList;
    }

    @Override
    public Book getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Book) session.get(Book.class, id);
    }

    @Override
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void deleteById(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);

    }
}

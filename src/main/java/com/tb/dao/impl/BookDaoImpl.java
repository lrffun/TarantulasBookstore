package com.tb.dao.impl;

import com.tb.dao.IBookDao;
import com.tb.domain.Book;

import java.util.List;


public class BookDaoImpl implements IBookDao {

    IBookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }


    @Override
    public Book findBooksById(String id) {
        return bookDao.findBooksById(id);
    }

    @Override
    public List<Book> findBooksByName(String name) {
        return bookDao.findBooksByName(name);
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void update( Book book) {
        bookDao.update(book);
    }

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    public IBookDao getBookDao() {
        return bookDao;
    }
}

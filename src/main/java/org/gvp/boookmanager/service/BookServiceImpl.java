package org.gvp.boookmanager.service;

import org.gvp.boookmanager.dao.BookDao;
import org.gvp.boookmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {


    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book get(long id, long userId) {
        return bookDao.get(id, userId);
    }


    @Override
    @Transactional
    public void delete(long id, long userId) {
        bookDao.delete(id, userId);
    }

    @Override
    @Transactional
    public Book create(Book book, long userId) {
        return bookDao.save(book, userId);
    }

    @Override
    @Transactional
    public Book update(Book book, long userId) {
        book.setReadAlready(false);
        return  bookDao.save(book, userId);
    }

    @Override
    public List<Book> getAll(long userId) {
        return bookDao.getAll(userId);
    }

    @Override
    @Transactional
    public void makeRead(long id, boolean readAlready, long userId) {
        Book book = get(id, userId);
        book.setReadAlready(readAlready);
        bookDao.save(book, userId);
    }

}

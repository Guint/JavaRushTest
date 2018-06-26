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
    public Book create(Book book, int userId) {
        return bookDao.save(book, userId);
    }

    @Override
    @Transactional
    public Book update(Book book, int userId) {
        return  bookDao.save(book, userId);
    }

    @Override
    public List<Book> getALL(long userId) {
        return bookDao.getAll(userId);
    }

    @Override
    public void makeRead(Book book, long userId) {
        book.setReadAlready(true);
        bookDao.save(book, userId);
    }


    public List<Book> search(String searchText) {
        return bookDao.search(searchText);
    }
}

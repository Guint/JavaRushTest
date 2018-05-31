package org.gvp.boookmanager.service;

import org.gvp.boookmanager.dao.BookDao;
import org.gvp.boookmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {


    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void makeRead(Book book) {
        book.setReadAlready(true);
        bookDao.save(book);
    }

    @Override
    @Transactional
    public Book save(Book book) {
        book.setReadAlready(false);
        return bookDao.save(book);
    }


    @Override
    @Transactional
    public boolean delete(Long id) {
        return bookDao.delete(id);
    }


    @Override
    @Transactional
    public Book get(Long id) {
        return bookDao.get(id);
    }

    @Override
    @Transactional
    public List<Book> getALL() {
        return bookDao.getAll();
    }


    @Transactional
    public List<Book> search(String searchText) {
        return bookDao.search(searchText);
    }
}

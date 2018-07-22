package org.gvp.boookmanager.dao;

import org.gvp.boookmanager.model.Book;

import java.util.List;

public interface BookDao {

    Book save(Book book, long userId);

    boolean delete(long id, long userId);

    Book get(long id, long userId);

    List<Book> getAll(long userId);

}

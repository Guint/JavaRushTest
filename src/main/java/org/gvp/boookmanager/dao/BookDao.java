package org.gvp.boookmanager.dao;

import org.gvp.boookmanager.model.Book;

import java.util.List;

public interface BookDao {
    Book save(Book book);

    boolean delete(Long id);

    Book get(Long id);

    List<Book> getAll();

    List<Book> search(String searchText);
}

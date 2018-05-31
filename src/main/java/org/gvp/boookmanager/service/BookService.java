package org.gvp.boookmanager.service;

import org.gvp.boookmanager.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    boolean delete(Long id);

    Book get(Long id);

    List<Book> getALL();

    List<Book> search(String searchText);

    void makeRead(Book book);
}

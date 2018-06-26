package org.gvp.boookmanager.service;
import org.gvp.boookmanager.model.Book;

import java.util.List;

public interface BookService {
    Book get(long id, long userId);

    void delete(long id, long userId);

    Book create(Book book, int userId);

    Book update(Book book, int userId);

    List<Book> getALL(long userId);

    List<Book> search(String searchText);

    void makeRead(Book book, long userId);
}

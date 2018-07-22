package org.gvp.boookmanager.service;
import org.gvp.boookmanager.model.Book;

import java.util.List;

public interface BookService {
    Book get(long id, long userId);

    void delete(long id, long userId);

    Book create(Book book, long userId);

    Book update(Book book, long userId);

    List<Book> getAll(long userId);

    void makeRead(long id, boolean readAlready, long userId);
}

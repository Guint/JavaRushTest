package org.gvp.service;

import org.gvp.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    void makeRead(Book book);

    Book getBookById(int id);

    List<Book> listBooks();

    List<Book> searchBooks(String searchParameter, String searchText);

}

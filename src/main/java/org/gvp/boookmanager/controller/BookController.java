package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.model.Book;
import org.gvp.boookmanager.service.BookService;
import org.gvp.boookmanager.support.security.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
        return bookService.getALL(authorizedUser.getId());
    }

    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book get(@PathVariable("id") long id, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        return bookService.get(id, authorizedUser.getId());
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id, @AuthenticationPrincipal AuthorizedUser authorizedUser){
        bookService.delete(id, authorizedUser.getId());
    }

   @PostMapping()
    public void update(@Valid @ModelAttribute Book book, @AuthenticationPrincipal AuthorizedUser authorizedUser){
        if(book.getId() == null) {
            bookService.create(book, authorizedUser.getId());
        } else {
            bookService.update(book, authorizedUser.getId());
        }
    }
    
}

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
@RequestMapping(value = "/bookmanager/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll(@AuthenticationPrincipal AuthorizedUser authorizedUser) {
        return bookService.getAll(authorizedUser.getId());
    }

    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book get(@PathVariable("id") long id) {
        return bookService.get(id, AuthorizedUser.id());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id){
        bookService.delete(id, AuthorizedUser.id());
    }

   @PostMapping()
    public void update(@Valid @ModelAttribute Book book){
        if(book.getId() == null) {
            bookService.create(book, AuthorizedUser.id());
        } else {
            bookService.update(book, AuthorizedUser.id());
        }
    }

    @PostMapping(value = "/{id}")
    public void makeRead(@PathVariable("id") int id, @RequestParam("readAlready") boolean readAlready) {
        bookService.makeRead(id, readAlready, AuthorizedUser.id());
    }
}

package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.model.Book;
import org.gvp.boookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
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
    public List<Book> getAll() {
        return bookService.getALL(1);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable("id") long id) {
        return bookService.get(id, 1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id){
        bookService.delete(id, 1);
    }

   /* @PostMapping()
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "bookForm";
        }
        bookService.save(book);
        return "redirect:/books";
    }**/
    
}

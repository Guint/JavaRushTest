package org.gvp.boookmanager.controller;

import org.gvp.boookmanager.model.Book;
import org.gvp.boookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller()
public class BookController {

    private BookService bookService;
    private int currentPage = 0;
    private String sort = "books";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public String listBooks(@RequestParam(required = false) Integer page, Model model) {
        sort = "books";
        model.addAttribute("book", new Book());
        List<Book> books = bookService.getALL();
        setPaging(page, model, books);
        return "books";
    }

    @GetMapping(value = "/addForm")
    public String bookAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping(value = "/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "bookForm";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete/{id}")
    public String removeBook(@PathVariable("id") Long id){
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping(value = "editForm")
    public String bookEditForm(@RequestParam(name = "id") Long id, Model model){
        model.addAttribute("book", bookService.get(id));
        return "bookForm";

    }

    @RequestMapping(value = "makeRead/{id}")
    public String makeRead(@PathVariable("id") Long id){
        Book book = bookService.get(id);
        bookService.makeRead(book);
        return "redirect:/books";
    }


    @GetMapping(value = "books/search")
    public String booksSearch(@RequestParam("searchText")String searchText,
                              Model model) {
        List<Book> books = bookService.search(searchText);
        model.addAttribute("listBooks", books);
        return "search";
    }

    private void setPaging(Integer page, Model model, List<Book> books) {
        PagedListHolder<Book> pagedListHolder = new PagedListHolder<>(books);
        pagedListHolder.setPageSize(10);

        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        model.addAttribute("currentSort", sort);

        if (page == null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;

        model.addAttribute("page", page);
        currentPage = page;

        pagedListHolder.setPage(page - 1);
        model.addAttribute("listBooks", pagedListHolder.getPageList());
    }
}

package com.example.webbookstore.controller;

import com.example.webbookstore.model.Book;
import com.example.webbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // list
    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("")
    public ModelAndView listQuestion(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Book> books;
        if(search.isPresent()){
            books = bookService.search(search.get(), pageable);
        }
        else books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("book", books);
        return modelAndView;
    }
}

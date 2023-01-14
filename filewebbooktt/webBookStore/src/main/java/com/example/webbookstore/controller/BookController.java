package com.example.webbookstore.controller;

import com.example.webbookstore.model.Book;
import com.example.webbookstore.model.Category;
import com.example.webbookstore.payload.response.ResponseMessage;
import com.example.webbookstore.service.BookService;
import com.example.webbookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    // list
    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Book>> getAllBookPage(@PageableDefault(size = 8)Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<Book>> getByNamePage(@RequestParam String name, @PageableDefault(size = 8) Pageable pageable) {
        Page<Book> books = bookService.findBookByNameContaining(name, pageable);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/foreign")
    public ResponseEntity<List<Book>> getByForeign(){
        return new ResponseEntity<>(bookService.findBookByForeign(), HttpStatus.OK);
    }

    @GetMapping("/news")
    public ResponseEntity<List<Book>> getByNews(){
        return new ResponseEntity<>(bookService.findBookByNews(), HttpStatus.OK);
    }

    @GetMapping("/vietnam")
    public ResponseEntity<List<Book>> getByVietnam(){
        return new ResponseEntity<>(bookService.findBookByVietnam(), HttpStatus.OK);
    }

    @GetMapping("/children")
    public ResponseEntity<List<Book>> getByChildren(){
        return new ResponseEntity<>(bookService.findBookByChildren(), HttpStatus.OK);
    }



}

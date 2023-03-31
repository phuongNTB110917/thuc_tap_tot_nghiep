package com.example.hue.controllers;

import com.example.hue.models.entity.Book;
import com.example.hue.services.BookService;
import com.example.hue.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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

// detail
    @GetMapping("/findById")
    public ResponseEntity<Book> findById(@RequestParam Integer id) {
        System.out.println("Find by id");
        Book book = bookService.findById(id);
        System.out.println(book.getId());
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Book>> search(@RequestParam String q, @PageableDefault(size = 8) Pageable pageable) {
        System.out.println("Search value = " + q);
        return new ResponseEntity<>(bookService.search(q, pageable), HttpStatus.OK);
    }

    //    @GetMapping("/search")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<Book>> getByNamePage(@RequestParam String name, @PageableDefault(size = 8) Pageable pageable) {
//        Page<Book> books = bookService.findBookByNameContaining(name, pageable);
//        return ResponseEntity.ok(books);
//    }


}

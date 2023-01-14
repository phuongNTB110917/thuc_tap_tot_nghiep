package com.example.webbookstore.service;

import com.example.webbookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Page<Book>findBookByNameContaining(String name, Pageable pageable);

    List<Book>findBookByForeign();

    List<Book>findBookByNews();

    List<Book>findBookByVietnam();

    List<Book>findBookByChildren();

    List<Book> findBookByNumberRecord(int numberRecord);

//    Page<Book> search(String book, Pageable page);
}

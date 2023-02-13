package com.example.hue.services;


import com.example.hue.models.entity.Book;
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

//    List<Book> findBookByNumberRecord(int numberRecord);

    Book findById(Integer id);

}

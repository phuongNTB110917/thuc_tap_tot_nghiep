package com.example.webbookstore.service.impl;

import com.example.webbookstore.model.Book;
import com.example.webbookstore.repository.BookRepository;
import com.example.webbookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book>findBookByNameContaining(String name, Pageable pageable) {
        return bookRepository.findBookByNameContaining(name, pageable);
    }

    @Override
    public List<Book> findBookByForeign() {
        return bookRepository.findBookByForeign();
    }

    @Override
    public List<Book> findBookByNews() {
        return bookRepository.findBookByNews();
    }

    @Override
    public List<Book> findBookByVietnam() {
        return bookRepository.findBookByVietnam();
    }

    @Override
    public List<Book> findBookByChildren() {
        return bookRepository.findBookByChildren();
    }


    @Override
    public List<Book> findBookByNumberRecord(int numberRecord) {
        return bookRepository.findBookByNumberRecord(numberRecord);
    }

//    @Override
//    public Page<Book> search(String book, Pageable pageable) {
//        return bookRepository.search(book, pageable);
//    }
}

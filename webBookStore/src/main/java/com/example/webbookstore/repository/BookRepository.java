package com.example.webbookstore.repository;

import com.example.webbookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book limit :numberRecord", nativeQuery = true)
    List<Book> findBookByNumberRecord(int numberRecord);

    @Query(value = "select * from book join category on book.category_id = category.id " +
            "where book.name like %:search% or book.author like %:search% or category.name like %:search%",
            countQuery = "select count(*) from book join category on book.category_id = category.id " +
                    "where book.name like %:search% or book.author like %:search% or category.name like %:search%",
            nativeQuery = true)
    Page<Book> search(String search, Pageable page);

}

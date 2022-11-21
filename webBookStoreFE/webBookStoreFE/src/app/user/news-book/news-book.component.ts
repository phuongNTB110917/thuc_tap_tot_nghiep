import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/book';
import {BookService} from '../service/book.service';

@Component({
  selector: 'app-news-book',
  templateUrl: './news-book.component.html',
  styleUrls: ['./news-book.component.css']
})
export class NewsBookComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllNews();
  }

  getAllNews() {
    return this.bookService.getNewsBook().subscribe(books => {
      this.books = books;
    });
  }
}


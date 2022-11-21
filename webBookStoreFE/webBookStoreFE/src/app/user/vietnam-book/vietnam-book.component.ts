import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/book';
import {BookService} from '../service/book.service';

@Component({
  selector: 'app-vietnam-book',
  templateUrl: './vietnam-book.component.html',
  styleUrls: ['./vietnam-book.component.css']
})
export class VietnamBookComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllVietnam();
  }

  getAllVietnam() {
    return this.bookService.getVietnamBook().subscribe(books => {
      this.books = books;
    });
  }
}

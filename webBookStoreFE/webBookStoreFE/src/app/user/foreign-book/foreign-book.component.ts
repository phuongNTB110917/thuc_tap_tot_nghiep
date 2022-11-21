import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/book';
import {BookService} from '../service/book.service';

@Component({
  selector: 'app-foreign-book',
  templateUrl: './foreign-book.component.html',
  styleUrls: ['./foreign-book.component.css']
})
export class ForeignBookComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllForeign();
  }

  getAllForeign() {
    return this.bookService.getForeignBook().subscribe(books => {
      this.books = books;
    });
  }

}

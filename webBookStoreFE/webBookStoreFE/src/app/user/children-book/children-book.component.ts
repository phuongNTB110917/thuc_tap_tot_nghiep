import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/book';
import {BookService} from '../service/book.service';

@Component({
  selector: 'app-children-book',
  templateUrl: './children-book.component.html',
  styleUrls: ['./children-book.component.css']
})
export class ChildrenBookComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllChildren();
  }

  getAllChildren() {
    return this.bookService.getChildrenBook().subscribe(books => {
      this.books = books;
    });
  }

}

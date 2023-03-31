import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/book';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BookService} from '../service/book.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  name: string;
  id: number;

  totalPage = 0;
  indexPagination = 0;
  formSearch: FormGroup = new  FormGroup({
    searchValue: new FormControl('',
      [Validators.pattern('^[a-zA-Z\\d .@-]*$')])
  });

  constructor(private bookService: BookService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllHome(0);
    this.formSearch = new FormGroup({
      searchValue: new FormControl('', Validators.required)
    });
  }

  getAllHome(page: number) {
    this.bookService.getAllBookPage(page).subscribe((data: any) => {
        this.books = data.content;
        this.totalPage = data.totalPages;
        this.indexPagination = data.pageable.pageNumber;
        console.log(this.indexPagination);
        console.log(this.totalPage);
      },
    );
  }

  firstPage() {
    this.indexPagination = 0;
    this.getAllHome(this.indexPagination);
  }

  previousPage() {
    if (this.indexPagination > 0) {
      this.indexPagination = this.indexPagination - 1;
      this.getAllHome(this.indexPagination);
    }
  }

  nextPage() {
    if (this.indexPagination !== this.totalPage) {
      this.indexPagination += 1;
      this.getAllHome(this.indexPagination);
    }
  }

  lastPage() {
    this.indexPagination = this.totalPage - 1 ;
    this.getAllHome(this.indexPagination);
  }

  // onSearch() {
  //   // this.router.navigateByUrl('/search?name=' + this.formSearch.get('searchValue').value + '&page=1');
  //   const nameSearch = this.formSearch.value;
  //   // if (nameSearch.trim() === '') {
  //   //   nameSearch = 'null';
  //   // }
  //   this.bookService.getSearch(nameSearch.searchValue, this.indexPagination).subscribe((data: any) => {
  //     this.books = data.content;
  //     if (this.books.length === 0) {
  //       console.log(this.books);
  //     }
  //   });
  // }

  onSearch(){
    console.log(this.formSearch.value);
    // this.router.navigateByUrl('/search?q=' + this.formSearch.get('searchValue').value + '&page=1');
    const search =this.formSearch.value;
    this.bookService.search(search.searchValue, this.indexPagination).subscribe((data:any)=>{
      this.books = data.content;
      if (this.books.length === 0){
        console.log(this.books);
      }
    })
  }

}


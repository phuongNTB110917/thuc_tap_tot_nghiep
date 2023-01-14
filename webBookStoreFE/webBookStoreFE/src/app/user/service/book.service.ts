import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../../model/book';

const API_URL_BOOK = 'http://localhost:8080/api/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/findAll');
  }

  getAllBookPage(page: number): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/all' + '?page=' + page);
  }

  getSearch(name: string, page: number): Observable<Book> {
    return this.http.get<Book>(API_URL_BOOK + '/search?name=' + name + '&page=' + page);
  }

  getNewsBook(): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/news');
  }

  getForeignBook(): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/foreign');
  }

  getVietnamBook(): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/vietnam');
  }

  getChildrenBook(): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL_BOOK + '/children');
  }
}

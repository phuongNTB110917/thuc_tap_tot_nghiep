import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TokenStorageService} from '../../_services/token-storage.service';
import {BehaviorSubject, Observable} from 'rxjs';
import {CartItem} from '../../model/cart-item';
import {ResponseMessage} from '../../model/response-message';
import {Book} from '../../model/book';

const API_URL = 'http://localhost:8080/api/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItems$ = new BehaviorSubject<CartItem[]>([]);

  constructor(private http: HttpClient,
              private storageService: TokenStorageService) { }

  reloadCartItems() {
    this.getCartItemByUserId(this.storageService.getUser().id).subscribe(
      cartItems => this.cartItems$.next(cartItems)
    );
  }

  getCartItemByUserId(id: number): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(API_URL + '/getCartByUserId?id=' + id);
  }

  addToCart(amount: number, cartId: number, bookId: number): Observable<ResponseMessage> {
    return this.http.get<ResponseMessage>(API_URL + '/addToCart?'
      + 'amount=' + amount
      + '&cartId=' + cartId
      + '&bookId=' + bookId);
  }

  updateCartItem(amount: number, cartItemId: number, bookId: number): Observable<ResponseMessage> {
    return this.http.get<ResponseMessage>(API_URL + '/updateCartItem?'
      + 'amount=' + amount
      + '&cartItemId=' + cartItemId
      + '&bookId=' + bookId
    );
  }

  deleteCartItem(cartItemId: number): Observable<ResponseMessage> {
    return this.http.delete<ResponseMessage>(API_URL + '/delete?cartItemId=' + cartItemId);
  }
}

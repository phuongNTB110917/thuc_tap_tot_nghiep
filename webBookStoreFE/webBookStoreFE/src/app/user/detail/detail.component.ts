import {Component, ElementRef, OnInit} from '@angular/core';
import {Book} from '../../model/book';
import {FormBuilder} from '@angular/forms';
import {SecurityService} from '../service/security.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {BookService} from '../service/book.service';
import {TokenStorageService} from '../../_services/token-storage.service';
import {CartService} from '../service/cart.service';
import {CartItem} from '../../model/cart-item';
import {CartStorageService} from '../../_services/cart-storage.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  id: number;
  book: Book;
  descriptions: string[];
  isViewDesc = true;

  constructor(private el: ElementRef,
              private formBuild: FormBuilder,
              private bookService: BookService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private cartService: CartService,
              private cartStorageService: CartStorageService,
              private storageService: TokenStorageService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.id = Number(param.get('id'));
      this.bookService.findById(this.id).subscribe(b => {
        this.book = b;
        this.descriptions = b.description.split('\n');
      });
    });
  }

  changeView() {
    this.isViewDesc = !this.isViewDesc;
  }

  addToCart() {
    const inputQuantity = this.el.nativeElement.querySelector('.input-change-quantity');
    const amount = inputQuantity.value;
    if (amount > 0) {
      if (this.storageService.checkIsLogin()) {
        this.cartService.addToCart(amount, this.storageService.getUser().cart.id , this.book.id).subscribe(
          next => {
            this.toastr.success('Thêm vào giỏ hàng thành công !!!');
            this.cartService.reloadCartItems();
          }
        );
      } else {
        const cartItem: CartItem = {
          amount: Number(amount),
          book: this.book
        };
        this.cartStorageService.addToCart(cartItem);
      }
    }
  }

  subQuantity() {
    const inputQuantity = this.el.nativeElement.querySelector('.input-change-quantity');
    if (inputQuantity.value > 1) {
      inputQuantity.value--;
    }

  }

  addQuantity() {
    const inputQuantity = this.el.nativeElement.querySelector('.input-change-quantity');
    inputQuantity.value++;
  }
}

package com.example.hue.controllers;

import com.example.hue.common.response.MessageResponse;
import com.example.hue.models.entity.Book;
import com.example.hue.models.entity.CartItem;
import com.example.hue.services.BookService;
import com.example.hue.services.CartItemService;
import com.example.hue.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BookService bookService;

//  nhận giỏ hàng theo Id người dùng
    @GetMapping("/getCartByUserId")
    public ResponseEntity<List<CartItem>> getCartByUserId(@RequestParam Integer id) {
        return new ResponseEntity<>(cartItemService.findAllCartItemsByUser(id), HttpStatus.OK);
    };

//    thêm vào giỏ hàng
    @GetMapping("/addToCart")
    public ResponseEntity<MessageResponse> addToCart(@RequestParam int amount,
                                                     @RequestParam Integer cartId,
                                                     @RequestParam Integer bookId) {
        Book book = bookService.findById(bookId);

        int record;
        CartItem cartItem = cartItemService.findByCartIdAndBookId(cartId, bookId);
        if(cartItem == null) {
            if(book.getAmount() < amount){
                return new ResponseEntity<>(new MessageResponse("Sản phẩm tối đa còn lại trong hệ thống là "
                        + book.getAmount()), HttpStatus.BAD_REQUEST);
            }
            record = cartItemService.save(amount, cartId, bookId);
        } else {
            if(book.getAmount() < amount + cartItem.getAmount()){
                return new ResponseEntity<>(new MessageResponse("Sản phẩm tối đa còn lại trong hệ thống là "
                        + book.getAmount()), HttpStatus.BAD_REQUEST);
            }
            record = cartItemService.update(cartItem.getId(), amount + cartItem.getAmount());
        }
        if(record <= 0) {
            return new ResponseEntity<>(new MessageResponse("Lỗi không thêm được sản phẩm vào giỏ hàng"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MessageResponse("Thêm vào giỏ hàng thành công !!!"), HttpStatus.OK);
    };

//    Cập nhật giỏ hàng
    @GetMapping("/updateCartItem")
    public ResponseEntity<MessageResponse> create(@RequestParam int amount,
                                                  @RequestParam Integer cartItemId,
                                                  @RequestParam Integer bookId) {
        Book book = bookService.findById(bookId);

        if(book.getAmount() < amount){
            return new ResponseEntity<>(new MessageResponse("Sản phẩm tối đa còn lại trong hệ thống là " + book.getAmount()), HttpStatus.BAD_REQUEST);
        }
        int record = 0;
        CartItem cartItem = cartItemService.findById(cartItemId);
        if(cartItem == null) {
            return new ResponseEntity<>(new MessageResponse("Không tìm thấy giỏ hàng !!!"), HttpStatus.BAD_REQUEST);
        } else {
            record = cartItemService.update(cartItemId, amount);
        }
        if(record <= 0) {
            return new ResponseEntity<>(new MessageResponse("Lỗi không thêm được sản phẩm vào giỏ hàng"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MessageResponse("Thêm vào giỏ hàng thành công !!!"), HttpStatus.OK);
    };

//    Xoá
    @DeleteMapping("/delete")
    public ResponseEntity<MessageResponse> delete(@RequestParam Integer cartItemId) {
        int record = 0;
        CartItem cartItem = cartItemService.findById(cartItemId);
        if(cartItem == null) {
            return new ResponseEntity<>(new MessageResponse("Không tìm thấy giỏ hàng !!!"), HttpStatus.BAD_REQUEST);
        } else {
            record = cartItemService.update(cartItemId, 0);
        }
        if(record <= 0) {
            return new ResponseEntity<>(new MessageResponse("Lỗi không thêm được sản phẩm vào giỏ hàng"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MessageResponse("Thêm vào giỏ hàng thành công !!!"), HttpStatus.OK);
    };
}

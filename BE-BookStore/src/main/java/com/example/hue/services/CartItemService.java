package com.example.hue.services;

import com.example.hue.models.entity.CartItem;

import java.util.List;

public interface CartItemService {

    CartItem findByCartIdAndBookId(Integer cartId, Integer bookId);

    List<CartItem> findAllCartItemsByUser(Integer userId);

    int save(int amount, Integer cartId, Integer bookId);

    int update(Integer id, int amount);

    CartItem findById(Integer id);

}

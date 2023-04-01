package com.example.hue.services.impl;

import com.example.hue.models.entity.CartItem;
import com.example.hue.repositories.CartItemRepository;
import com.example.hue.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem findByCartIdAndBookId(Integer cartId, Integer bookId) {
        return cartItemRepository.findByCartIdAndBookId(cartId, bookId);
    }

    @Override
    public List<CartItem> findAllCartItemsByUser(Integer userId) {
        return cartItemRepository.findCartItemsByUserId(userId);
    }

    @Override
    public int save(int amount, Integer cartId, Integer bookId) {
        return cartItemRepository.save(amount, cartId, bookId);
    }

    @Override
    public int update(Integer id, int amount) {
        return cartItemRepository.update(id, amount);
    }

    @Override
    public CartItem findById(Integer id) {
        return cartItemRepository.findById(id).orElse(null);
    }
}

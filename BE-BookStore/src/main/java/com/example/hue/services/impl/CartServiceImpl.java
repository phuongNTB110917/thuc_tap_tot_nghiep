package com.example.hue.services.impl;

import com.example.hue.models.entity.Cart;
import com.example.hue.repositories.CartRepository;
import com.example.hue.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}

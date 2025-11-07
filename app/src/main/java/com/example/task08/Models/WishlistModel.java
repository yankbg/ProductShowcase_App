package com.example.task08.Models;

import java.util.ArrayList;
import java.util.List;

public class WishlistModel {
    List<ProductModel> wishlist;
    private static WishlistModel instance;

    public WishlistModel() {
    }

    public WishlistModel(List<ProductModel> wishlist) {
        this.wishlist = wishlist;
    }

    public List<ProductModel> getWishlist() {
        return wishlist;
    }
    public static synchronized WishlistModel getInstance() {
        if (instance == null) {
            instance = new WishlistModel();
        }
        return instance;
    }
}

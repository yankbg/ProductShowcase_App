package com.example.task08.Models;

import java.util.ArrayList;
import java.util.List;

public class WishlistModel {
    List<ProductModel> wishlist;

    public WishlistModel(List<ProductModel> wishlist) {
        this.wishlist = wishlist;
    }

    public List<ProductModel> getWishlist() {
        return wishlist;
    }
}

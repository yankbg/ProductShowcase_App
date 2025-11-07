package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.task08.Adapters.ProductCardAdapter;
import com.example.task08.Adapters.WishlistAdapter;
import com.example.task08.Models.ProductModel;
import com.example.task08.Models.WishlistModel;

import java.util.List;

public class WishlistActivity extends AppCompatActivity implements WishlistAdapter.ItemClickListener{

    RecyclerView recyclerView;
    List<ProductModel> wishlist;
    WishlistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


        WishlistModel wishlistModel = new WishlistModel();
        wishlist = wishlistModel.getWishlist();
        adapter = new WishlistAdapter(this,wishlist);
        recyclerView = findViewById(R.id.wishlist_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onItemClick(View view, int position) {
        //    Toast.makeText(this, "You clicked " + myadapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this,ProductDetailActivity.class);
//        intent.putExtra("product_name", myadapter.getItem(position).getName());
//        intent.putExtra("product_image", myadapter.getItem(position).getImgpath());
//        intent.putExtra("product_price", myadapter.getItem(position).getPrice());
//        intent.putExtra("product_rating", myadapter.getItem(position).getRating());
//        intent.putExtra("product_position", position);
//        startActivity(intent);
    }
}
package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task08.Models.ProductModel;
import com.example.task08.Models.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView productImgDetail;
    TextView productPriceDetail, productNamedeatail, productDescDetail;
    RatingBar productRatingDeatail;
    Button addWishBtn;
    String[] desc;
    List<ProductModel> wishlist;
    WishlistModel wishlistModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        desc = getResources().getStringArray(R.array.product_desc);
        productDescDetail = findViewById(R.id.detail_product_description);
        productImgDetail  = findViewById(R.id.detail_product_image);
        productRatingDeatail = findViewById(R.id.detail_product_rating);
        productNamedeatail = findViewById(R.id.detail_product_name);
        productPriceDetail = findViewById(R.id.detail_product_price);
        addWishBtn = findViewById(R.id.button_add_to_wishlist);

        setup();

        addWishBtn.setOnClickListener(view -> addWishBtnClicked());
    }

    private void addWishBtnClicked() {
        String nameDetail = getIntent().getStringExtra("product_name");
        String priceDetail = getIntent().getStringExtra("product_price");
        int ratingDetail = getIntent().getIntExtra("product_rating",0);
        int imgDetail = getIntent().getIntExtra("product_image",0);
        int position = getIntent().getIntExtra("product_position",0);
        wishlist = new ArrayList<ProductModel>();
        ProductModel productModel = new ProductModel(imgDetail,ratingDetail,nameDetail,priceDetail);
//        wishlist.add(productModel);
//        wishlistModel = new WishlistModel(wishlist);
//        Toast.makeText(this,"product added sucessfully in wishlist",Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(this,WishlistActivity.class);
//        startActivity(i);


        if (!wishlist.contains(productModel)) {
            wishlist.add(productModel);  // Add product to wishlist data source
            wishlistModel = (WishlistModel) WishlistModel.getInstance().getWishlist();
//            notifyDataSetChanged(); // Refresh if necessary
            Intent i = new Intent(this,WishlistActivity.class);
            startActivity(i);
            Toast.makeText(this, productModel.getName() + " added to wishlist", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, productModel.getName() + " is already in wishlist", Toast.LENGTH_SHORT).show();
        }


    }

    private void setup() {
        String nameDetail = getIntent().getStringExtra("product_name");
        String priceDetail = getIntent().getStringExtra("product_price");
        int ratingDetail = getIntent().getIntExtra("product_rating",0);
        int imgDetail = getIntent().getIntExtra("product_image",0);
        int position = getIntent().getIntExtra("product_position",0);
        productImgDetail.setImageResource(imgDetail);
        productNamedeatail.setText(nameDetail);
        productPriceDetail.setText(priceDetail);
        productRatingDeatail.setRating( ratingDetail);
        productDescDetail.setText(desc[position]);
    }

}
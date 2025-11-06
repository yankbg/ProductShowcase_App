package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView productImgDetail;
    TextView productPriceDetail, productNamedeatail, productDescDetail;
    RatingBar productRatingDeatail;
    Button addWishBtn;
    String[] desc;
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
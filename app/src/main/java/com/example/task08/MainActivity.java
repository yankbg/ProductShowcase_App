package com.example.task08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.task08.Adapters.ProductCardAdapter;
import com.example.task08.Models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductCardAdapter.ItemClickListener{

    public  final Integer[] images = { R.drawable.sl190,
            R.drawable.sl280, R.drawable.sl300, R.drawable.sl350, R.drawable.sl500_1998, R.drawable.sl500,
            R.drawable.slr231, R.drawable.sl63};
    public String[] product_name;
    public String[] product_price;
    public int[] product_rating;
    RecyclerView recyclerView;
    List<ProductModel> productList;
    ProductCardAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product_name = getResources().getStringArray(R.array.product_name);
        product_price = getResources().getStringArray(R.array.product_price);
        product_rating = getResources().getIntArray(R.array.product_rating);

        productList = new ArrayList<ProductModel>();
        for (int i = 0; i < images.length; i++) {
            ProductModel product = new ProductModel( images[i],product_rating[i], product_name[i], product_price[i]);
            productList.add(product);
        }


        myadapter = new ProductCardAdapter(this,productList);
        recyclerView = findViewById(R.id.recycler_card_product);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter.setClickListener(this);
        recyclerView.setAdapter(myadapter);
//        recyclerView.setOnItemClickListener(this);
    }
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//        Toast toast = Toast.makeText(getApplicationContext(),
//                "Item " + (position + 1) + ": " + productList.get(position).getName(),
//                Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
//        toast.show();
//    }
@Override
public void onItemClick(View view, int position) {
    Toast.makeText(this, "You clicked " + myadapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();
}

}
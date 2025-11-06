package com.example.task08.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task08.Models.ProductModel;
import com.example.task08.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCardAdapter extends RecyclerView.Adapter<ProductCardAdapter.MyViewHolder> {
    private List<ProductModel> productList;
    private LayoutInflater mInflater;
    private static ItemClickListener mClickListener;

    // data is passed into the constructor
    ProductCardAdapter(Context context, List<ProductModel> productList) {
        this.mInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ProductCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_product_row, parent, false);
        return new ProductCardAdapter.MyViewHolder(view);

    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull ProductCardAdapter.MyViewHolder holder, int position) {
        holder.productprofile.setImageResource(productList.get(position).getImgpath());
        holder.tvProductName.setText(productList.get(position).getName());
        holder.tvPrice.setText(productList.get(position).getPrice());
        holder.productRating.setRating(productList.get(position).getRating());

    }
    @Override
    public int getItemCount() {
        return productList.size();
    }
    public  void setAttendanceList(ArrayList<ProductModel> newList) {
        productList = newList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvProductName,tvPrice;
        RatingBar productRating;
        ImageView productprofile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.product_title);
            tvPrice = itemView.findViewById(R.id.product_price);
            productprofile = itemView.findViewById(R.id.product_image);
            productRating = itemView.findViewById(R.id.productRatingBar);

        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // convenience method for getting data at click position
    ProductModel getItem(int id) {
        return productList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

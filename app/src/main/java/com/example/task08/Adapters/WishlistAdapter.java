package com.example.task08.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task08.Models.ProductModel;
import com.example.task08.Models.WishlistModel;
import com.example.task08.R;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.MyViewHolder> {
    private List<ProductModel> Wishlist;
    private LayoutInflater mInflater;
    private static WishlistAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public WishlistAdapter(Context context, List<ProductModel> Wishlist) {
        this.mInflater = LayoutInflater.from(context);
        this.Wishlist = Wishlist != null ? Wishlist : new ArrayList<>();
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public WishlistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wishlist_item_row, parent, false);
        return new WishlistAdapter.MyViewHolder(view);

    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull WishlistAdapter.MyViewHolder holder, int position) {
        holder.productprofile.setImageResource(Wishlist.get(position).getImgpath());
        holder.tvProductName.setText(Wishlist.get(position).getName());
        holder.tvPrice.setText(Wishlist.get(position).getPrice());
        holder.productRating.setRating(Wishlist.get(position).getRating());
        holder.addbtn.setOnClickListener(v -> {
            Wishlist.remove(position);
            WishlistModel wishlistModel = new WishlistModel(Wishlist);

        });

    }
    @Override
    public int getItemCount() {
        return Wishlist == null ? 0 : Wishlist.size();
    }
    public  void setAttendanceList(ArrayList<ProductModel> newList) {
        Wishlist = newList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvProductName,tvPrice;
        RatingBar productRating;
        ImageView productprofile;
        Button addbtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvProductName = itemView.findViewById(R.id.wishlist_product_name);
            tvPrice = itemView.findViewById(R.id.wishlist_product_price);
            productprofile = itemView.findViewById(R.id.wishlist_product_image);
            productRating = itemView.findViewById(R.id.wishlist_product_rating);
            addbtn = itemView.findViewById(R.id.button_remove);

        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // convenience method for getting data at click position
    public ProductModel getItem(int id) {
        return Wishlist.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(WishlistAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


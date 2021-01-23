package com.example.grocery;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    ImageView pic;
    ImageButton inc,dec;
    LinearLayout disc_layout;
    TextView price,title,unit,quantity,discount;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        pic= itemView.findViewById(R.id.imageView);
        inc= itemView.findViewById(R.id.add);
        dec= itemView.findViewById(R.id.subtract);
        price= itemView.findViewById(R.id.price);
        title= itemView.findViewById(R.id.title);
        unit= itemView.findViewById(R.id.unit);
        quantity= itemView.findViewById(R.id.quantity);
        discount= itemView.findViewById(R.id.discount_amount);
        disc_layout= itemView.findViewById(R.id.dsc_layout);
    }
}

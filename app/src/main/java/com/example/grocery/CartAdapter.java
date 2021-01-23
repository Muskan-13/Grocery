package com.example.grocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    ArrayList<Model> data;
    public CartAdapter(ArrayList<Model> data)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.pic.setImageResource(data.get(position).getImg());
        holder.title.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice());
        holder.unit.setText(data.get(position).getUnit());
        holder.quantity.setText(data.get(position).getQuantity());

        if(Integer.parseInt(data.get(position).getDiscount())>0)
        {
            holder.disc_layout.setVisibility(View.VISIBLE);
            holder.discount.setText(data.get(position).getDiscount());
        }

        holder.inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val= Integer.parseInt(data.get(position).getQuantity()) ;
                val+=1;
                data.get(position).setQuantity(String.valueOf(val));
                holder.quantity.setText(String.valueOf(val));
            }
        });
        holder.dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val= Integer.parseInt(data.get(position).getQuantity()) ;
                if(val>1)
                 val-=1;
                data.get(position).setQuantity(String.valueOf(val));
                holder.quantity.setText(String.valueOf(val));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

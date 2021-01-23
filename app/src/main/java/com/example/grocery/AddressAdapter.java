package com.example.grocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<RadioViewHolder> {

    ArrayList<AddressModel> data;

    public AddressAdapter(ArrayList<AddressModel> data)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public RadioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_radio,parent,false);
        return new RadioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioViewHolder holder, int position) {

       holder.radioButton.setText(data.get(position).getUserName() + "\n" +
               data.get(position).getAddress1() + ", " + data.get(position).getAddress2() + "\n" +
               data.get(position).getCity() + " - " + data.get(position).getUserPinCode() + "\n" + data.get(position).getState()+ "\n" + "Phone number - "+ data.get(position).getUserPhoneNo() );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

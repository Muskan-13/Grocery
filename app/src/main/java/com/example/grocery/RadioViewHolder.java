package com.example.grocery;

import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RadioViewHolder extends RecyclerView.ViewHolder {

    RadioButton radioButton;

    public RadioViewHolder(@NonNull View itemView) {
        super(itemView);
        radioButton= itemView.findViewById(R.id.radioButton);
    }
}

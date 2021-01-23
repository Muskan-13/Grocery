package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {

    ArrayList<AddressModel>  addressList = new ArrayList<>();
    Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Button address = findViewById(R.id.address_btn);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, AddNewAddress.class);
                startActivity(intent);
            }
        });

        nextbtn= findViewById(R.id.proceed);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RecyclerView radioRecycler = findViewById(R.id.radioRecycler);
        radioRecycler.setLayoutManager(new LinearLayoutManager(this));


        addressList = (ArrayList<AddressModel>) getIntent().getSerializableExtra("AddressData");
        if (addressList != null) {
            AddressAdapter adapter = new AddressAdapter(addressList);
            radioRecycler.setAdapter(adapter);
            radioGroup.setVisibility(View.VISIBLE);
        }
    }
     public void onRadioClick(View v)
     {
         nextbtn.setVisibility(View.VISIBLE);
         RadioButton radioButton= findViewById(R.id.radioButton);
         SharedPreferences sharedPreferences= getSharedPreferences("Address",MODE_PRIVATE);
         SharedPreferences.Editor editor= sharedPreferences.edit();
         editor.putString("Current_Address",radioButton.getText().toString());
         editor.apply();
         Log.v("Address",sharedPreferences.getString("Current_Address",""));
     }
}
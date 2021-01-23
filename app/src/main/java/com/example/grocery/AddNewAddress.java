package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class AddNewAddress extends AppCompatActivity {

    ArrayList<AddressModel> arrayList = new ArrayList<AddressModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);

        Button save = findViewById(R.id.saveAddress);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.name);
                String user_name = name.getText().toString();
                EditText phn = findViewById(R.id.user_phnNo);
                String user_phn = phn.getText().toString();
                EditText pinCode = findViewById(R.id.pincode);
                String user_pin = pinCode.getText().toString();
                EditText add1 = findViewById(R.id.address1);
                String user_add1 = add1.getText().toString();
                EditText add2 = findViewById(R.id.address2);
                String user_add2 = add2.getText().toString();
                EditText city = findViewById(R.id.city);
                String user_city = city.getText().toString();
                EditText state = findViewById(R.id.state);
                String user_state = state.getText().toString();

                if(user_name.equals("")|| user_phn.equals("")||user_phn.equals("")||
                 user_add1.equals("")||user_add2.equals("")||user_state.equals("")||user_city.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fill out all the details",Toast.LENGTH_SHORT).show();
                }
                else {
                    arrayList.add(new AddressModel(user_name, user_phn, user_pin, user_add1, user_add2, user_city, user_state));
                    Intent intent = new Intent(AddNewAddress.this, AddressActivity.class);
                    intent.putExtra("AddressData", arrayList);
                    startActivity(intent);
                }

            }

        });
    }
}
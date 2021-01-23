package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // check Fields For Empty Values
            checkFieldsForEmptyValues();
        }
    };

    void checkFieldsForEmptyValues(){

        String s1 = edt.getText().toString();

        if(s1.equals("")){
            btn.setEnabled(false);
            btn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        } else {
            btn.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.phone_number_edt);
        btn= findViewById(R.id.next);
        edt.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();

        CountryCodePicker ccp= findViewById(R.id.ccp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, OtpVerification.class);
                String s1 = edt.getText().toString();
                String s2= ccp.getSelectedCountryCodeWithPlus();
                String s= "";
                s= s2+s1;
                intent.putExtra("PhnNo",s);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cartButton) {
            Intent intent= new Intent(MainActivity.this,CartActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
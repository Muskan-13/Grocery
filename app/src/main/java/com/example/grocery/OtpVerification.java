package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtpVerification extends AppCompatActivity {
    EditText otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four;
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

        String s1 = otp_textbox_one.getText().toString() ;
        String s2= otp_textbox_two.getText().toString();
        String s3= otp_textbox_three.getText().toString();
        String s4=otp_textbox_four.getText().toString();

        if(s1.equals("") || s2.equals("")|| s3.equals("")|| s4.equals("")){
            btn.setEnabled(false);
            btn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        } else {
            btn.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        otp_textbox_one = findViewById(R.id.otp_edit_box1);
        otp_textbox_two = findViewById(R.id.otp_edit_box2);
        otp_textbox_three = findViewById(R.id.otp_edit_box3);
        otp_textbox_four = findViewById(R.id.otp_edit_box4);
        btn= findViewById(R.id.done);


        TextView phn= findViewById(R.id.phn);
        Bundle bundle= getIntent().getExtras();
        if(bundle!= null)
        {
            String s= (String) bundle.get("PhnNo");
            phn.setText(s);
        }

        EditText[] edit = {otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four};

        otp_textbox_one.addTextChangedListener(new GenericTextWatcher(otp_textbox_one, edit));
        otp_textbox_two.addTextChangedListener(new GenericTextWatcher(otp_textbox_two, edit));
        otp_textbox_three.addTextChangedListener(new GenericTextWatcher(otp_textbox_three, edit));
        otp_textbox_four.addTextChangedListener(new GenericTextWatcher(otp_textbox_four, edit));

        otp_textbox_one.addTextChangedListener(mTextWatcher);
        otp_textbox_two.addTextChangedListener(mTextWatcher);
        otp_textbox_three.addTextChangedListener(mTextWatcher);
        otp_textbox_four.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();

    }
}
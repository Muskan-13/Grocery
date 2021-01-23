package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Model> arrayList=  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button checkout = findViewById(R.id.checkout);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model(R.drawable.img1,"23","50","Sample cart item 1","1 unit","1"));
        arrayList.add(new Model(R.drawable.img3,"123","150","Sample cart item 2","1 Kg","1"));
        arrayList.add(new Model(R.drawable.img2,"203","0","Sample cart item 3","2 units","2"));
        arrayList.add(new Model(R.drawable.img1,"100","0","Sample cart item 4","1 unit","1"));
        arrayList.add(new Model(R.drawable.img2,"120","150","Sample cart item 5","1 Kg","1"));
        arrayList.add(new Model(R.drawable.img3,"200","300","Sample cart item 6","2 units","2"));

        CartAdapter adapter= new CartAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        if(adapter.getItemCount()<=0)
        {
            checkout.setVisibility(View.GONE);
            CardView cardView= findViewById(R.id.cardView);
            TextView textView= findViewById(R.id.emptyCart);
            cardView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
        else {

            String price = "Rs." + String.valueOf(calc_price(arrayList));
            TextView tamount = findViewById(R.id.total_amount);
            TextView mrp = findViewById(R.id.amount);
            mrp.setText(price);

            TextView discount_txt = findViewById(R.id.discount);
            String ds = "- Rs.";
            ds += String.valueOf(calc_discount(arrayList));
            discount_txt.setText(ds);

            String total = "Rs." + String.valueOf(calc_price(arrayList) - calc_discount(arrayList));
            tamount.setText(total);

            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CartActivity.this, AddressActivity.class);
                    startActivity(intent);
                }
            });
        }


    }
    public int  calc_price(ArrayList<Model> list)
    {
        int sum=0;
        for(int i=0; i< arrayList.size();i++)
        {
            int price = Integer.parseInt(arrayList.get(i).getPrice())* Integer.parseInt(arrayList.get(i).getQuantity());
            Log.d("Answer", String.valueOf(price));
            sum+=price;
        }

        return sum;
    }

    public int  calc_discount(ArrayList<Model> list)
    {
        int sum=0;
        for(int i=0; i< arrayList.size();i++)
        {
            if(Integer.parseInt(arrayList.get(i).getDiscount())>0) {
                int disc = (Integer.parseInt(arrayList.get(i).getDiscount()) - Integer.parseInt(arrayList.get(i).getPrice()) )  * Integer.parseInt(arrayList.get(i).getQuantity());
                Log.d("Answer", String.valueOf(disc));
                sum += disc;
            }
        }

        return sum;
    }
}
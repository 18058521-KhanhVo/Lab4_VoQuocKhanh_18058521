package com.example.lab4_voquockhanh_18058521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SendingData{
    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t=findViewById(R.id.tvPrice);
        price= (String) t.getText();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,BelowFragment.newInstance(price)).commit();
    }

    @Override
    public void sendData(String data) {
        int sl=Integer.parseInt(data);
        Double gia=Double.parseDouble(price.substring(0,price.indexOf(" ")));
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,BelowFragment.newInstance((gia*sl)+"")).commit();

    }
}
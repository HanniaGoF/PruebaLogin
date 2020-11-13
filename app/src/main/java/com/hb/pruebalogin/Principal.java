package com.hb.pruebalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    TextView verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        verify=(TextView)findViewById(R.id.verificacion);
        String u;
        Intent i=getIntent();
        u=i.getStringExtra("userExtra");
        verify.setText("no existe");

    }
    /*public void mensaje(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }*/
}
package com.udakita.aplikasipertama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    //deklarasi variable scr global
    EditText edtusername,edtpassword;
    Button btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //inisialisasi atau  link ke layout yang diset
        edtusername = (EditText)findViewById(R.id.edtusername);
        edtpassword = (EditText)findViewById(R.id.edtpassword);
        btnkirim = (Button)findViewById(R.id.btnkirim);


        //setdata

        edtusername.setText(getIntent().getStringExtra("uS"));
        edtpassword.setText(getIntent().getStringExtra("pw"));


    }
}

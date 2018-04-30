package com.udakita.aplikasipertama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UtamaActivity extends AppCompatActivity {

    //deklarasi variable scr global
    EditText edtusername,edtpassword;
    Button btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        //inisialisasi atau  link ke layout yang diset
        edtusername = (EditText)findViewById(R.id.edtusername);
        edtpassword = (EditText)findViewById(R.id.edtpassword);
        btnkirim = (Button)findViewById(R.id.btnkirim);



        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parsing ke string
                final String username = edtusername.getText().toString();
                final String password =edtpassword.getText().toString();

                //untuk mengirim data pakai intent
                Intent kirimdata = new Intent(UtamaActivity.this,DetailActivity.class);
                kirimdata.putExtra("uS",username);
                kirimdata.putExtra("pw",password);
                startActivity(kirimdata);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


        Toast.makeText(this, "tampil onStart", Toast.LENGTH_SHORT).show();
        Log.d("life","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "tampil OnResume", Toast.LENGTH_SHORT).show();
        Log.d("life","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life","onRestart");


        Toast.makeText(this, "tampil onRestart", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();

        

        Toast.makeText(this, "tampil OnPause", Toast.LENGTH_SHORT).show();

        Log.d("life","onPause");
    }

    @Override
    protected void onDestroy() {

        Toast.makeText(this, "tampil OnDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();

        Log.d("life","onDestroy");
    }


    //method ketika tombol back di tekan


    @Override
    public void onBackPressed() {
        AlertDialog.Builder  keluar = new AlertDialog.Builder(UtamaActivity.this);
        keluar.setIcon(R.mipmap.ic_logo);
        keluar.setTitle("informasi");
        keluar.setMessage("apakah anda yakin keluar ? ");
        //tombol
        keluar.setPositiveButton("back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
        //keluar aplikasi
                startActivity(new Intent(UtamaActivity.this,MainActivity.class));

            }
        });

        keluar.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        keluar.show();


    }
}

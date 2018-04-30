package com.udakita.aplikasipertama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "tampil OnStop", Toast.LENGTH_SHORT).show();
        Log.d("life","onStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "tampil Oncreate", Toast.LENGTH_LONG).show();
        Log.d("life","onCreate");

        //untuk penundaan ke activity selanjutnya
        Handler tunda = new Handler();
        tunda.postDelayed(new Runnable() {
            @Override
            public void run() {

        startActivity(new Intent(MainActivity.this,UtamaActivity.class));
        //kill activity
                finish();
            }
        },5000);

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
        AlertDialog.Builder  keluar = new AlertDialog.Builder(MainActivity.this);
        keluar.setIcon(R.mipmap.ic_logo);
        keluar.setTitle("informasi");
        keluar.setMessage("apakah anda yakin keluar ? ");
        //tombol
        keluar.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
        //keluar aplikasi
              System.exit(0);
                moveTaskToBack(true);
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

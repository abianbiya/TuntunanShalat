package com.cokilabs.shalat.shalat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView showMenuPengertianSalat = (ImageView) findViewById(R.id.menu1);

        showMenuPengertianSalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuPengertianSalat.class);
                startActivity(intent);
            }
        });

        ImageView showMenuRukunSalat = (ImageView) findViewById(R.id.menu2);

        showMenuRukunSalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuRukunSalat.class);
                startActivity(intent);
            }
        });

        ImageView showMenuGerakanSalat = (ImageView) findViewById(R.id.menu3);

        showMenuGerakanSalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuGerakanSalat.class);
                startActivity(intent);
            }
        });

        ImageView showMenuArahKiblat = (ImageView) findViewById(R.id.menu4);

        showMenuArahKiblat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuArahKiblat.class);
                startActivity(intent);
            }
        });

        ImageView showMenuProfil = (ImageView) findViewById(R.id.menu5);

        showMenuProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuProfil.class);
                startActivity(intent);
            }
        });

        ImageView showMenu6 = (ImageView) findViewById(R.id.menu6);

        showMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainActivity.this.finish();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Apakah anda yakin akan keluar?");
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });


    }
}

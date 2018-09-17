package com.cokilabs.shalat.shalat;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MenuGerakanSalat extends AppCompatActivity {
    ImageView bacaan, gerakan;
    TextView txtJudul, tvLatin;
    FloatingActionButton pilihan, left, right;
    MediaPlayer mediaPlayer;

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    ArrayList<DataGerakanSholat> listGerakan;
    GridView gvList;
    int indexList;
    Boolean isplaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gerakan_salat);

        isplaying = false;

        bacaan = findViewById(R.id.bacaan);
        gerakan = findViewById(R.id.gerakan);
        pilihan = findViewById(R.id.floatingActionButton);
        left = findViewById(R.id.fabLeft);
        right = findViewById(R.id.fabRight);
        txtJudul = findViewById(R.id.tv_nama_gerakan);
        tvLatin = findViewById(R.id.tv_latin);

        mediaPlayer = MediaPlayer.create(MenuGerakanSalat.this, R.raw.suaratakbir);

        listGerakan = new ArrayList<DataGerakanSholat>();

        listGerakan.add(new DataGerakanSholat("Niat", "gerakanniat", "niat", "suaraniat", "Niat di dalam hati"));
        listGerakan.add(new DataGerakanSholat("Berdiri Tegak", "gerakanniat", "berdiri", "berdiri", "Berdiri tegak bagi yang mampu. Boleh sambil duduk atau berbaring bagi yang sedang sakit"));
        listGerakan.add(new DataGerakanSholat("Takbiratul Ihram", "gerakantakbir", "bacaantakbir", "suaratakbir", "Mengangkat kedua tangan sebanding dengan telinga"));
        listGerakan.add(new DataGerakanSholat("Membaca Do'a Iftitah", "gerakanbersedekap", "bacaandoaiftitah", "suaradoaiftitah", "Bersedekap dengan meletakkan tangan kanan di atas tangan kiri. Kemudian membaca Doa Iftitah"));
        listGerakan.add(new DataGerakanSholat("Membaca Surat Al-Fatihah", "gerakanbersedekap", "bacaansuratalfatihah", "suarasuratalfatihah", "Bersedekap dengan meletakkan tangan kanan di atas tangan kiri. Kemudian membaca Surat Al Fatihah"));
        listGerakan.add(new DataGerakanSholat("Rukuk", "gerakanrukuk", "bacaanrukuk", "suararukuk", "Meletakkan kedua tangan pada kedua lutut"));
        listGerakan.add(new DataGerakanSholat("Iktidal", "gerakaniktidal", "bacaaniktidal", "suaraiktidal", "Mengangkat kepala dan bangkit dari rukuk dan mengangkat kedua tangan sebanding dengan bahu"));
        listGerakan.add(new DataGerakanSholat("Sujud", "gerakansujud", "bacaansujud", "suarasujud", "Bersujud dengan tujuh anggota tubuh yaitu di atas kening seraya tanggan menunjuk ke arah hidung, kedua tangan, kedua lutut dan ujung kedua kaki"));
        listGerakan.add(new DataGerakanSholat("Duduk Diantara Dua Sujud", "gerakandudukdiantaraduasujud", "bacaandudukdiantaraduasujud", "suaradudukdiantaraduasujud", "Merebahkan telapak kaki kiri dan duduk diatasnya sedangkan telapak kaki kanan ditegakkan dan jari jemaarinya menghadap kiblat"));
        listGerakan.add(new DataGerakanSholat("Tasyahud Awal", "gerakantasyahudawal", "bacaantasyahudawal", "suaratasyahudawal", "Meletakkan telapak tangan kiri diatas lutut kiri dan menggenggam semua jari tangan kanan dan mengacukan tekunjuk ke kiblat  dan mengarahkan pandangan mata ke telunjuk"));
        listGerakan.add(new DataGerakanSholat("Tasyahud Akhir", "gerakantasyahudakhir", "bacaantasyahudakhir", "suaratasyahudakhir", "Meletakkan telapak tangan kiri diatas lutut kiri dan menggenggam semua jari tangan kanan dan mengacukan tekunjuk ke kiblat, mengarahkan pandangan mata ke telunjuk, dan memiringkan kepala ke kanan "));
        listGerakan.add(new DataGerakanSholat("Salam", "gerakansalam", "bacaansalam", "suarasalam", "Mengucapkan salam dengan menoleh ke kanan kemudian menoleh ke kiri "));

        indexList = 0;
        changeAttribut(getApplicationContext(), listGerakan.get(indexList));

        final ListAdapter listAdapter = new ListAdapter(this, listGerakan);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexList>0){
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                    indexList = indexList-1;
                    changeAttribut(getApplicationContext(), listGerakan.get(indexList));
                }else{
                    // Toast.makeText(MenuGerakanSalat.this, "Mentok!"+String.valueOf(indexList), Toast.LENGTH_SHORT).show();
                }
            }
        });


        bacaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intAudion = getResources().getIdentifier(listGerakan.get(indexList).getSrcAudio(), "raw", getPackageName());

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }else{
                    mediaPlayer = MediaPlayer.create(MenuGerakanSalat.this, intAudion);
                    mediaPlayer.start();
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexList < (listGerakan.size()-1)) {

                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                    changeAttribut(getApplicationContext(), listGerakan.get(indexList + 1));
                    indexList = indexList+1;
                }else{
                    // Toast.makeText(MenuGerakanSalat.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pilihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(MenuGerakanSalat.this);
                inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialoggerakan, null);
                dialog.setView(dialogView);
                dialog.setCancelable(true);
                final AlertDialog alertDialog = dialog.create();

                gvList = dialogView.findViewById(R.id.gv_list);

                Log.e("listGerakan", String.valueOf(listGerakan.size()));

                Log.e("listAdapter", String.valueOf(listAdapter.getCount()));

                gvList.setAdapter(listAdapter);

                gvList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DataGerakanSholat gerakan = listGerakan.get(position);

                        changeAttribut(getApplicationContext(), gerakan);

                        indexList = position;

                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    public void changeAttribut(final Context context, final DataGerakanSholat dataGerakan) {
        int intBacaan = context.getResources().getIdentifier("drawable/"+dataGerakan.getSrcArab(), null, context.getPackageName());
        int intGerakan = context.getResources().getIdentifier("drawable/"+dataGerakan.getSrcGerakan(), null, context.getPackageName());
//        int intAudion = context.getResources().getIdentifier("raw/"+dataGerakan.getSrcAudio(), null, context.getPackageName());
        int intAudion = context.getResources().getIdentifier(dataGerakan.getSrcAudio()+".wav", "raw", context.getPackageName());


        File file = new File("raw/"+dataGerakan.getSrcAudio());
        Uri myUri = Uri.fromFile(file); // initialize Uri here
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        mediaPlayer.prepare();
//        mediaPlayer.start();

        this.txtJudul.setText(dataGerakan.getTxtNamaGerakan());
        this.tvLatin.setText(dataGerakan.getTxtLatin());
        this.bacaan.setImageResource(intBacaan);
        this.gerakan.setImageResource(intGerakan);


    }


}

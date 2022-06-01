package com.ogretir.cemal.kelimeoyunu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainPage extends AppCompatActivity {

    ////////////////////////////////////--TANIMLAMA--//////////////////////////////////////////

    TextView tv_bilgi, tv_kelime;
    EditText et_kelime;
    Button yeni, kontrol;
    String varSayilanKelime;
    Random r;
    String[] sozluk = {"Böte","Android","Bilgisayar","Java","php","Program","Erik","Çugulata"};


    ////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        /////////////////////--XML DOSYASINDAKI ARAÇLARA BAĞLANTI--//////////////////////////////

        tv_bilgi = (TextView)findViewById(R.id.tv_bilgi);
        tv_kelime = (TextView)findViewById(R.id.tv_kelime);
        et_kelime = (EditText)findViewById(R.id.et_kelime);
        yeni = (Button)findViewById(R.id.yeni);
        kontrol = (Button)findViewById(R.id.kontrol);

        //////////////////////--RASGELE FONKSIYON TANIMI--///////////////////////////////////////

        r = new Random();


        YeniOyun ();
        yeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YeniOyun();
            }
        });

        yeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_kelime.getText().toString().equalsIgnoreCase(varSayilanKelime)){
                    //karşılaştırma doğru
                    tv_bilgi.setTextColor(Color.parseColor("#008577"));
                    tv_bilgi.setText("Tebrikler!!!");
                    kontrol.setEnabled(false);
                    yeni.setEnabled(true);
                }else{
                    //karşılaştırma yanlış
                    tv_bilgi.setTextColor(Color.parseColor("#D81B60"));
                    tv_bilgi.setText("Tekrar Deneyiniz!!!");
                }
            }
        });

    }

    private void YeniOyun() {
        varSayilanKelime = sozluk[r.nextInt(sozluk.length)];
        tv_kelime.setText(RasgeleHarf(varSayilanKelime));
        yeni.setEnabled(false);
        kontrol.setEnabled(true);
    }

    private String RasgeleHarf(String varSayilanKelime) {
        List<String> Harfler = Arrays.asList(varSayilanKelime.split(""));

        /////////////////////////--Harfler ={"B","ö","t","e"};--//////////////////////////////

        Collections.shuffle(Harfler);

        /////////////////////////--Harfler = {"ö","e","B","t"};--////////////////////////////

        String karisikKelime = "";
        for (String harf:Harfler){
            karisikKelime +=harf;
        }

        return karisikKelime;
    }

}

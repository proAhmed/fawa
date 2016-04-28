package droidahmed.com.fawaz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import droidahmed.com.fawaz.controller.SaveData;

public class ChooseLang extends AppCompatActivity {
ImageView imgArabic,imgEnglish;
    ImageView mapQatar,mapUAE,mapKuwait,mapSaudi,mapOman, mapBahrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_choose_lang_mod);
        imgArabic = (ImageView) findViewById(R.id.imgArabic);
        imgEnglish = (ImageView) findViewById(R.id.imgEnglish);
        mapQatar = (ImageView) findViewById(R.id.mapQatar);
        mapUAE = (ImageView) findViewById(R.id.mapUAE);
        mapKuwait = (ImageView) findViewById(R.id.mapKuwit);
        mapSaudi = (ImageView) findViewById(R.id.mapSuadi);
        mapOman = (ImageView) findViewById(R.id.mapOman);
        mapBahrain = (ImageView) findViewById(R.id.mapBahren);

        imgArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,MainActivity.class);
               new SaveData(ChooseLang.this).saveLang("ar");
                startActivity(intent);
            }
        });

        imgEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,MainActivity.class);
                new SaveData(ChooseLang.this).saveLang("en");

                startActivity(intent);
            }
        });
        mapQatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat", 25.30430376440362);
                intent.putExtra("lang", 51.21002197265625);
                intent.putExtra("phone","+974 44360558");
                intent.putExtra("fax","+974 44360557");
                intent.putExtra("email","qa.info@Fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",6);

                startActivity(intent);

            }
        });
        mapUAE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat", 23.5600);
                intent.putExtra("lang", 54.0000);
                intent.putExtra("phone","+971 65331344");
                intent.putExtra("fax","+971 65330342");
                intent.putExtra("email","ae.info@fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",5);

                startActivity(intent);

            }
        });
        mapKuwait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat", 29.369177);
                intent.putExtra("lang", 47.971421);
                intent.putExtra("phone","+965 1888010");
                intent.putExtra("fax"," +965 24346988");
                intent.putExtra("email","kw.info@fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",1);

                startActivity(intent);

            }
        });
        mapSaudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat", 24.0000);
                intent.putExtra("lang", 45.0000);
                intent.putExtra("phone","+966 138952323");
                intent.putExtra("fax","+966 138949076");
                intent.putExtra("email","sa.info@fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",2);

                startActivity(intent);

            }
        });
        mapOman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat", 21.186972714123776);
                intent.putExtra("lang", 56.458740234375);
                intent.putExtra("phone","++968 24488642");
                intent.putExtra("fax"," +968 24488731");
                intent.putExtra("email"," om.info@fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",3);

                startActivity(intent);

            }
        }); mapBahrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLang.this,CountryData.class);
                intent.putExtra("lat",26.160368536718508);
                intent.putExtra("lang",50.527496337890625);
                intent.putExtra("phone","+973 17291365");
                intent.putExtra("fax","+973 17291392");
                intent.putExtra("email"," bh.info@fawaz.com");
                intent.putExtra("address","");
                intent.putExtra("flag",4);

                startActivity(intent);
            }
        });
    }

}

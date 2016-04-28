package droidahmed.com.fawaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CountryData extends AppCompatActivity {
    private SupportMapFragment fragment;
    private GoogleMap map;
      LatLng mapLat;
TextView phone,email,fax,address;
    String strPhone,strEmail,strFax,strAddress;
    ImageView imgFlag;
    int flag;
    final int sdk = android.os.Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_contact_mod);
//         fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
//        map = fragment.getMap();
//
//        fragment = SupportMapFragment.newInstance();

        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        double lat =getIntent().getDoubleExtra("lat",0);
        double lang =getIntent().getDoubleExtra("lang",0);
        strPhone = getIntent().getStringExtra("phone");
        strFax = getIntent().getStringExtra("fax");
        strEmail = getIntent().getStringExtra("email");
        strAddress = getIntent().getStringExtra("address");
        phone = (TextView) findViewById(R.id.conPhone);
        email = (TextView) findViewById(R.id.conEmail);
        fax = (TextView) findViewById(R.id.conFax);
        address = (TextView) findViewById(R.id.conAddress);
        imgFlag = (ImageView) findViewById(R.id.imgFlag);
        flag = getIntent().getIntExtra("flag",1);
        mapLat = new LatLng(lat, lang);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 4));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(4), 1000, null);
        if(flag==1){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 7));

             map.animateCamera(CameraUpdateFactory.zoomTo(7), 1000, null);
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.kw) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.kw));
            }
         }else if (flag == 2){

             if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.soudi) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.soudi));
            }
        }else if (flag == 3){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 5));

            map.animateCamera(CameraUpdateFactory.zoomTo(5), 1000, null);
             if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.oman) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.oman));
            }
        }else if (flag == 4){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 8));

            map.animateCamera(CameraUpdateFactory.zoomTo(8), 500, null);
             if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.bahrain) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.bahrain));
            }
        }else if (flag == 5){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 6));

            map.animateCamera(CameraUpdateFactory.zoomTo(6), 500, null);
             if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.uae) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.uae));
            }
        }else if (flag == 6){
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 7));

            map.animateCamera(CameraUpdateFactory.zoomTo(7), 1000, null);
             if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imgFlag.setBackgroundDrawable( getResources().getDrawable(R.drawable.qatar) );
            } else {
                imgFlag.setBackground( getResources().getDrawable(R.drawable.qatar));
            }
        }
        phone.setText(strPhone);
        email.setText(strEmail);
        fax.setText(strFax);
        address.setText(strAddress);

        mapLat = new LatLng(lat, lang);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {

            map = fragment.getMap();
            Marker hamburg = map.addMarker(new MarkerOptions().position(mapLat)
                            .title("fawaz").title("fawaz company")
            );

            // Move the camera instantly to hamburg with a zoom of 15.
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLat, 11));

            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        }
    }
}

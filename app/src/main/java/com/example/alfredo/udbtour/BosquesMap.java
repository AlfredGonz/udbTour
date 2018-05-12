package com.example.alfredo.udbtour;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BosquesMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosques_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        //
        // Parque Nacional Montecristo
        LatLng montecristo = new LatLng(14.386390, -89.384345);
        mMap.addMarker(new MarkerOptions().position(montecristo).title("Parque Nacional Montecristo").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

//Reserva Biologica El Pital
        LatLng pital = new LatLng(14.382935, -89.117361);
        mMap.addMarker(new MarkerOptions().position(pital).title("Reserva Biológica El Pital").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

//Parque Nacional El Imposible
        LatLng imposible = new LatLng(13.833152, -89.934308);
        mMap.addMarker(new MarkerOptions().position(imposible).title("Parque Nacional El Imposible").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

//Parque Nacional Walter Thilo Deininger
        LatLng parque = new LatLng(13.499370, -89.268123);
        mMap.addMarker(new MarkerOptions().position(parque).title("Parque Nacional Walter Thilo Deininger").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        //Bosque Conchagua
        LatLng conchagua = new LatLng(13.263668, -87.840255);
        mMap.addMarker(new MarkerOptions().position(conchagua).title("Bosque Conchagua").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        //Bosque La Joya
        LatLng lajoya = new LatLng(13.552005, -88.720558);
        mMap.addMarker(new MarkerOptions().position(lajoya).title("Bosque La Joya").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        //Bosque El Tecomatal
        LatLng tecomatal = new LatLng(13.669336, -88.491244);
        mMap.addMarker(new MarkerOptions().position(tecomatal).title("Bosque El Tecomatal").icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        float zoomlevel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(montecristo, zoomlevel));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }


    public void tipoNormal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void tipoSatelite(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void tipoHibrido(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
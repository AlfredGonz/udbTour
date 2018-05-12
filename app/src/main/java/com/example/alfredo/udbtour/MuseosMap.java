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

public class MuseosMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museos_map);
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

        // Playa El Tunco
        LatLng eltunco = new LatLng(13.493027, -89.385048);
        mMap.addMarker(new MarkerOptions().position(eltunco).title("Playa El Tunco").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//Playa El Majagual
        LatLng elmajagual = new LatLng(13.489923, -89.365954);
        mMap.addMarker(new MarkerOptions().position(elmajagual).title("Playa El Majagual").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//Playa El Cocal
        LatLng elcocal = new LatLng(13.486493, -89.348049);
        mMap.addMarker(new MarkerOptions().position(elcocal).title("Playa El Cocal").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//Puerto de La Libertad
        LatLng puertoll = new LatLng(13.486221, -89.319273);
        mMap.addMarker(new MarkerOptions().position(puertoll).title("Puerto de La Libertad").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//PLaya San Diego
        LatLng sandiego = new LatLng(13.477917, -89.280196);
        mMap.addMarker(new MarkerOptions().position(sandiego).title("Playa San Diego").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//Playa Los Cobanos
        LatLng cobanos = new LatLng(13.525478, -89.804414);
        mMap.addMarker(new MarkerOptions().position(cobanos).title("Playa Los Cobanos").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//PLaya La Costa del Sol
        LatLng costa = new LatLng(13.330511, -88.975641);
        mMap.addMarker(new MarkerOptions().position(costa).title("Playa Costa del Sol").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

//PLaya La Zunganera
        LatLng zunganera = new LatLng(13.404572, -89.129187);
        mMap.addMarker(new MarkerOptions().position(zunganera).title("Playa La Zunganera").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));



        float zoomlevel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(puertoll, zoomlevel));

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

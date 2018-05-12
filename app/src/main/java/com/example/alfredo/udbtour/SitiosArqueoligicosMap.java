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

public class SitiosArqueoligicosMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_arqueoligicos_map);
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
        // Cihuatan
        LatLng cihuatan = new LatLng(13.980932, -89.164938);
        mMap.addMarker(new MarkerOptions().position(cihuatan).title("Cihuatan").icon(BitmapDescriptorFactory.fromResource(R.drawable.pyramid)));

//Sitio Arqueologico San Andres
        LatLng sanandres = new LatLng(13.800649, -89.389344);
        mMap.addMarker(new MarkerOptions().position(sanandres).title("Sitio Arqueológico San Andrés").icon(BitmapDescriptorFactory.fromResource(R.drawable.pyramid)));

//Sitio Arqueologico Joya de Cerén
        LatLng ceren = new LatLng(13.827935, -89.356243);
        mMap.addMarker(new MarkerOptions().position(ceren).title("Sitio Arqueologico Joya de Cerén").icon(BitmapDescriptorFactory.fromResource(R.drawable.pyramid)));

//Sitio Arqueologico Casa Blanca
        LatLng casablanca = new LatLng(13.987967, -89.671245);
        mMap.addMarker(new MarkerOptions().position(casablanca).title("Sitio Arqueológico Casa Blanca").icon(BitmapDescriptorFactory.fromResource(R.drawable.pyramid)));

        //Sitio Arqueológico El Tazumal
        LatLng tazumal = new LatLng(13.979621, -89.674170);
        mMap.addMarker(new MarkerOptions().position(tazumal).title("Sitio Arqueológico El Tazumal").icon(BitmapDescriptorFactory.fromResource(R.drawable.pyramid)));


        float zoomlevel = 9;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sanandres, zoomlevel));

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
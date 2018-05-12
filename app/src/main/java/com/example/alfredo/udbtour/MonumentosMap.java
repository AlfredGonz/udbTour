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

public class MonumentosMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monumentos_map);
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

        // Monumento al Divino Salvador del Mundo
        LatLng divino = new LatLng(13.701336, -89.224435);
        mMap.addMarker(new MarkerOptions().position(divino).title("Monumento al Divino Salvador del Mundo").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        // Monumento a la Revolucion
        LatLng revolucion = new LatLng(13.692527, -89.242015);
        mMap.addMarker(new MarkerOptions().position(revolucion).title("Monumento a la Revolución").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Monumento a la Constitución
        LatLng constitucion = new LatLng(13.718004, -89.222461);
        mMap.addMarker(new MarkerOptions().position(constitucion).title("Monumento a la Constitución").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Monumento Hermano Lejano
        LatLng lejano = new LatLng(13.684691, -89.218067);
        mMap.addMarker(new MarkerOptions().position(lejano).title("Monumento Hermano Lejano").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Monumento Francisco Morazán
        LatLng morazan = new LatLng(13.699146, -89.190395);
        mMap.addMarker(new MarkerOptions().position(morazan).title("Momumento Francisco Morazán").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Plaza Gerardo Barrios
        LatLng barrios = new LatLng(13.697641, -89.191199);
        mMap.addMarker(new MarkerOptions().position(barrios).title("Monumento a Gerardo Barrios").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Monumento a los Proceres
        LatLng proceres = new LatLng(13.682608, -89.193441);
        mMap.addMarker(new MarkerOptions().position(barrios).title("Monumento a Los Proceres").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));

        //Monumento a la Paz
        LatLng paz = new LatLng(13.668522, -89.190610);
        mMap.addMarker(new MarkerOptions().position(paz).title("Monumento a La Paz").icon(BitmapDescriptorFactory.fromResource(R.drawable.statue)));


        float zoomlevel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(divino, zoomlevel));

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

package com.example.alfredo.udbtour;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if (status== ConnectionResult.SUCCESS){

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        }else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
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

        // Palacio Nacional de Los Deportes INDES
        LatLng indes = new LatLng(13.703688, -89.195408);
        mMap.addMarker(new MarkerOptions().position(indes).title("Palacio Nacional de Los Deportes INDES").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        //Estadio Nacional Jorge "El Magico" Gonzalez
        LatLng estadio1 = new LatLng(13.698471, -89.215366);
        mMap.addMarker(new MarkerOptions().position(estadio1).title("Estadio Nacional Jorge \"El Magico\" Gonzalez").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        //Circulo deportivo Internacional
        LatLng circulo = new LatLng(13.695540, -89.227377);
        mMap.addMarker(new MarkerOptions().position(circulo).title("Circulo deportivo Internacional").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        //Estadio Cuscatlan
        LatLng estadio2 = new LatLng(13.681492, -89.223142);
        mMap.addMarker(new MarkerOptions().position(estadio2).title("Estadio Cuscatlán").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        //Estadio de Futbol Playa Costa del Sol
        LatLng playa = new LatLng(13.335652, -88.977421);
        mMap.addMarker(new MarkerOptions().position(playa).title("Estadio Futbol Playa Costa del Sol").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        //Estadio Futbol Playa Apulo
        LatLng apulo = new LatLng(13.702274, -89.077601);
        mMap.addMarker(new MarkerOptions().position(apulo).title("Estadio Futbol Playa Apulo").icon(BitmapDescriptorFactory.fromResource(R.drawable.sitiosdepo)));

        float zoomlevel=10;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(indes,zoomlevel));
    }
}

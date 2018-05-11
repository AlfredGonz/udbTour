package com.example.alfredo.udbtour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


     // OnClick

    public void sitiosdeportivos(View view) {

        Intent intent = new Intent(this, SitiosDeportivos.class);
        startActivity(intent);

    }

    public void playas(View view) {

        Intent intent = new Intent(this, Playas.class);
        startActivity(intent);
    }

    public void Bosques(View view) {

        Intent intent = new Intent(this, Bosques.class);
        startActivity(intent);
    }

    public void museos(View view) {

        Intent intent = new Intent(this, Museos.class);
        startActivity(intent);
    }

    public void arqueologicos(View view) {
        Intent intent = new Intent(this, SitiosArqueologicos.class);
        startActivity(intent);
    }

    public void monumentos(View view) {

        Intent intent = new Intent(this, Monumentos.class);
        startActivity(intent);
    }

    public void sugerencias(View view) {

        Intent intent = new Intent(this, Sugerencias.class);
        startActivity(intent);
    }
}


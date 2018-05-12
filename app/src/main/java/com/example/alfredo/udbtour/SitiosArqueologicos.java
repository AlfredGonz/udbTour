package com.example.alfredo.udbtour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SitiosArqueologicos extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios_arqueologicos);

        button=(Button)findViewById(R.id.mapa);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(SitiosArqueologicos.this,SitiosArqueoligicosMap.class);
                startActivity(intent);

            }
        });

    }
}

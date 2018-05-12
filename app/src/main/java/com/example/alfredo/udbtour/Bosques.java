package com.example.alfredo.udbtour;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Bosques extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosques);

        button=(Button)findViewById(R.id.mapa);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Bosques.this,BosquesMap.class);
                startActivity(intent);

            }
        });

    }

}

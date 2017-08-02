package com.oktopus.jeperaza.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.oktopus.jeperaza.mapas.Other.AsyncTaskProcess;

public class inicio extends AppCompatActivity {

    Button Acceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Acceso = (Button)findViewById(R.id.btnAcceso);

        Acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTaskProcess(getApplicationContext()).execute("http://192.168.1.134:3000/api/private");
            }
        });

    }
}

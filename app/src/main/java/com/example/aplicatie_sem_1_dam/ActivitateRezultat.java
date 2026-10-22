package com.example.aplicatie_sem_1_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {

    private int valoare1=0;
    private int valoare2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);

        Bundle datePrimite = getIntent().getExtras();

        if(datePrimite!=null){
            String mesaj = datePrimite.getString("CheieMesaj");
            valoare1 = datePrimite.getInt("Cheie_val1");
            valoare2 = datePrimite.getInt("Cheie_val2");

            String textToast = "Mesaj: "+ mesaj + " | Valori: " + valoare1 + ", " + valoare2;
            android.widget.Toast.makeText(this, textToast, android.widget.Toast.LENGTH_LONG).show();
        }

        Button butonInapoi=findViewById(R.id.BTN_inapoi);

        butonInapoi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int suma = valoare1 + valoare2;

                Intent intentRetur = new Intent();

                intentRetur.putExtra("Cheie_mesaj_return", "mesaj rezultat");
                intentRetur.putExtra("Cheie_suma", suma);

                setResult(RESULT_OK, intentRetur);

                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
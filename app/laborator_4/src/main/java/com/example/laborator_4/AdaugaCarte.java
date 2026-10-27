package com.example.laborator_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaCarte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_carte);

        EditText etTitlu = findViewById(R.id.etTitlu);
        Switch switchDisponibilitate = findViewById(R.id.switchDisponibilitate);
        Button btnSalveaza = findViewById(R.id.btnSalveazaCarte);

        btnSalveaza.setOnClickListener(v -> {
            String titluIntrodus = etTitlu.getText().toString();
            boolean esteDisponibila = switchDisponibilitate.isChecked();


            Carte carteNoua = new Carte(titluIntrodus, "Autor Necunoscut", 2024, esteDisponibila);

            Intent intentRetur = new Intent();
            intentRetur.putExtra("CHEIE_CARTE", carteNoua);

            setResult(RESULT_OK, intentRetur);
            finish();
        });
    }
}
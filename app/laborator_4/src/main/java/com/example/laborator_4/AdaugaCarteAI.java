package com.example.laborator_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class AdaugaCarteAI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_carte_ai);

        EditText etTitlu = findViewById(R.id.etTitluAI);
        Switch switchDisponibilitate = findViewById(R.id.switchDisponibilAI);
        Button btnSalveaza = findViewById(R.id.btnSalveazaAI);

        btnSalveaza.setOnClickListener(v -> {
            String titlu = etTitlu.getText().toString();
            boolean disponibil = switchDisponibilitate.isChecked();

            Carte carteNoua = new Carte(titlu, "Design AI", 2024, disponibil);

            Intent intentRetur = new Intent();
            intentRetur.putExtra("CHEIE_CARTE", carteNoua);

            setResult(RESULT_OK, intentRetur);
            finish();
        });
    }
}
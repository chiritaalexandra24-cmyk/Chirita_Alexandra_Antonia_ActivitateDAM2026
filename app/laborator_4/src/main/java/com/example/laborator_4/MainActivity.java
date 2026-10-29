package com.example.laborator_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Carte> listaCarti = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Carte cartePrimita = (Carte) result.getData().getSerializableExtra("CHEIE_CARTE");

                    if (cartePrimita != null) {
                        listaCarti.add(cartePrimita);
                        Toast.makeText(this, "Carte adăugată în listă!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnDeschide = findViewById(R.id.btnDeschideAdaugare);
        btnDeschide.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdaugaCarte.class);
            launcher.launch(intent);
        });

        Button btnDeschideAI = findViewById(R.id.btnDeschideAI);
        btnDeschideAI.setOnClickListener(v -> {
            Intent intentAI = new Intent(MainActivity.this, AdaugaCarteAI.class);
            launcher.launch(intentAI);
        });

        Button btnVeziLista = findViewById(R.id.btnVeziLista);
        btnVeziLista.setOnClickListener(v -> {
            Intent intentLista = new Intent(MainActivity.this, ListaCartiActivity.class);
            intentLista.putExtra("LISTA_CARTI", listaCarti);
            startActivity(intentLista);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
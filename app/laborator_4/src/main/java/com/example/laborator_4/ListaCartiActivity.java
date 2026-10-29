package com.example.laborator_4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaCartiActivity extends AppCompatActivity {

    private ArrayList<Carte> listaPrimita;
    private ArrayAdapter<Carte> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Am șters EdgeToEdge.enable(this) pentru a rezolva suprapunerea
        setContentView(R.layout.activity_lista_carti);

        ListView listViewCarti = findViewById(R.id.listViewCarti);

        if (getIntent().hasExtra("LISTA_CARTI")) {
            listaPrimita = (ArrayList<Carte>) getIntent().getSerializableExtra("LISTA_CARTI");
        } else {
            listaPrimita = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPrimita);
        listViewCarti.setAdapter(adapter);

        listViewCarti.setOnItemClickListener((parent, view, position, id) -> {
            Carte carteSelectata = listaPrimita.get(position);
            Toast.makeText(ListaCartiActivity.this, "Selectat: " + carteSelectata.getTitlu(), Toast.LENGTH_SHORT).show();
        });

        listViewCarti.setOnItemLongClickListener((parent, view, position, id) -> {
            listaPrimita.remove(position);
            adapter.notifyDataSetChanged();

            Toast.makeText(ListaCartiActivity.this, "Cartea a fost ștearsă!", Toast.LENGTH_SHORT).show();

            return true;
        });
    }
}
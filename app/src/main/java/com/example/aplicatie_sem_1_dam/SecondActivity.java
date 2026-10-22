package com.example.aplicatie_sem_1_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if(result.getResultCode() == RESULT_OK && result.getData()!=null){
                        Intent dateReturnate = result.getData();

                        String msjPrimit =dateReturnate.getStringExtra("Cheie_mesaj_return");
                        int suma = dateReturnate.getIntExtra("Cheie_suma", 0);

                        Toast.makeText(SecondActivity.this, "Retur: " + msjPrimit + " | suma: " + suma,Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        Button butonDeschide = findViewById(R.id.BTN_deschideActivRezultat);

        butonDeschide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this, ActivitateRezultat.class);
                Bundle pachetDate = new Bundle();

                pachetDate.putString("CheieMesaj", "mesaj");
                pachetDate.putInt("Cheie_val1", 2);
                pachetDate.putInt("Cheie_val2", 3);

                intent.putExtras(pachetDate);
                launcher.launch(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
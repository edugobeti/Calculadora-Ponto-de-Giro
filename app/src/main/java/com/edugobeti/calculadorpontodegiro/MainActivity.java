package com.edugobeti.calculadorpontodegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView editAlturaFolha;
    private TextView editBraco;
    private TextView editOrelha;
    private TextView editGiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editAlturaFolha = findViewById(R.id.editAlturaFolha);
        editBraco = findViewById(R.id.editBraco);
        editOrelha = findViewById(R.id.editOrelha);
        editGiro = findViewById(R.id.editGiro);

    }

    public void calcularGiro(View view){

        double medidaFolha = Double.parseDouble(editAlturaFolha.getText().toString());
        double braco = medidaFolha / 4;
        double orelha = braco - 4;
        double giro = medidaFolha / 2;

        editBraco.setText(String.format("%.1f cm", braco));
        editOrelha.setText(String.format("%.1f cm",orelha));
        if(view.getId() == R.id.btCx15){
            editGiro.setText(String.format("%.1f cm", giro+=4.5));
        }else if(view.getId() == R.id.btCx17){
            editGiro.setText(String.format("%.1f cm", giro+=5.5));
        }else if(view.getId() == R.id.btCx20){
            editGiro.setText(String.format("%.1f cm", giro+=7));
        }


    }
}
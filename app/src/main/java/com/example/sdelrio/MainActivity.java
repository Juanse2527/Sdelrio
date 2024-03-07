package com.example.sdelrio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText lado1EditText, lado2EditText, anguloEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elementos de la interfaz
        lado1EditText = findViewById(R.id.lado1EditText);
        lado2EditText = findViewById(R.id.lado2EditText);
        anguloEditText = findViewById(R.id.anguloEditText);

        Button calcularButton = findViewById(R.id.calcularButton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para pasar a la pantalla de resultados
                calcular();
            }
        });
    }

    private void calcular() {
        // Obtener valores de los EditText
        double lado1 = Double.parseDouble(lado1EditText.getText().toString());
        double lado2 = Double.parseDouble(lado2EditText.getText().toString());
        double angulo = Double.parseDouble(anguloEditText.getText().toString());

        // Calcular seno, coseno, área y perímetro
        double seno = Math.sin(Math.toRadians(angulo));
        double coseno = Math.cos(Math.toRadians(angulo));
        double area = lado1 * lado2;
        double perimetro = 2 * (lado1 + lado2);

        // Crear un Intent para iniciar ResultadoActivity
        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

        // Pasar los resultados como extras al Intent
        intent.putExtra("seno", seno);
        intent.putExtra("coseno", coseno);
        intent.putExtra("area", area);
        intent.putExtra("perimetro", perimetro);

        // Iniciar la nueva actividad
        startActivity(intent);
    }
}

package com.example.sdelrio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 5000; // Duración de la "splash screen" en milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView loadingImageView = findViewById(R.id.loadingImageView);
        TextView loadingTextView = findViewById(R.id.loadingTextView);

        // Cargar la animación de rotación
        Animation loadingAnimation = AnimationUtils.loadAnimation(this, R.anim.loading_animation);

        // Aplicar la animación al ImageView y al TextView
        loadingImageView.startAnimation(loadingAnimation);
        loadingTextView.startAnimation(loadingAnimation);

        // Esperar durante SPLASH_TIMEOUT antes de iniciar la actividad principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Iniciar la actividad principal después de SPLASH_TIMEOUT
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la "splash screen" para que no aparezca al volver atrás
            }
        }, SPLASH_TIMEOUT);
    }
}

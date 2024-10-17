package br.ulbra.applogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btEntrar, btRegistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEntrar = findViewById(R.id.btEntrar);
        btRegistar = findViewById(R.id.btRegistrar);

        btEntrar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btRegistar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
            startActivity(intent);
        });
    }
}


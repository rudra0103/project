package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class LoginActivity extends AppCompatActivity {

    TextView tvRegister;
    Button btnClose;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnClose=findViewById(R.id.btnClose);
        tvRegister=findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        });

        btnClose.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit")
                    .setMessage("Are you  Sure?")
                    .setPositiveButton("yes",(dialog, which) -> {
                        finish();
                    })
                    .setNegativeButton("no",(dialog, which) -> {

                    })
                    .show();

        });
    }
}
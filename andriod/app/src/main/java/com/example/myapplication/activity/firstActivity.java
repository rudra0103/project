package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.util.ConstantData;

public class firstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences(ConstantData.SP_NAME, MODE_APPEND);

                boolean isLogin = sp.getBoolean(ConstantData.KEY_SP_ISLOGIN,false);

                if (isLogin) {
                    Intent intent=new Intent(firstActivity.this,homeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(firstActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
        },7000);
    }

}
package com.example.myapplication.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.ServiceModel;
import com.example.myapplication.util.ConstantData;

public class BookingActivity extends AppCompatActivity {

    ImageView img;
    TextView txtName, txtDate, txtTime,txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        ServiceModel model= (ServiceModel) getIntent().getSerializableExtra("model");

        img = findViewById(R.id.img);
        txtName = findViewById(R.id.txtName);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txTime);
        txtPrice = findViewById(R.id.txtPrice);
        Glide.with(this).load(ConstantData.SERVER_ADDRESS_IMG+ model.getSer_pic1()).into(img);
        txtName.setText(model.getTitle());
        txtPrice.setText(model.getPrice());
        txtTime.setText(getIntent().getStringExtra("time"));
        txtDate.setText(getIntent().getStringExtra("date"));


    }
}
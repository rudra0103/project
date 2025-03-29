package com.example.myapplication.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ServiceAdapter;
import com.example.myapplication.model.ServiceModel;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {

    RecyclerView rcylservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<ServiceModel> serviceModels = (ArrayList<ServiceModel>) getIntent().getSerializableExtra("service");
        rcylservice=findViewById(R.id.rcylservice);
        rcylservice.setLayoutManager(new LinearLayoutManager(this));
        ServiceAdapter serviceAdapter=new ServiceAdapter(serviceModels);
        rcylservice.setAdapter(serviceAdapter);

    }
}
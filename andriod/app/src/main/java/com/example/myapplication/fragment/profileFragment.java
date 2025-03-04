package com.example.myapplication.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.activity.signup;

public class profileFragment extends Fragment {
    Button btnLogout;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnLogout=view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("LOGOUT !");
            builder.setMessage("Are you sure ?");
            builder.setPositiveButton("YES", ((dialogInterface, i) -> {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
        }));
            builder.setNegativeButton("NO", ((dialogInterface, i) -> {
                Toast.makeText(getActivity(), "Logged in currently", Toast.LENGTH_SHORT).show();
            }));
            builder.create()
                    .show();

        });
    }
}
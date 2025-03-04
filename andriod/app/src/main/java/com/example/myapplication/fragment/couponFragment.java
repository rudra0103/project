package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.CouponAdapter;
import com.example.myapplication.model.CouponModel;

import java.util.ArrayList;

public class couponFragment extends Fragment {

    RecyclerView rcylCoupon;

    ArrayList<CouponModel>couponModels;
    View view;

    public couponFragment(ArrayList<CouponModel> getCouponModels) {
        this.couponModels=getCouponModels;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_coupon, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcylCoupon = view.findViewById(R.id.rcylCoupon);

        rcylCoupon.setLayoutManager(new LinearLayoutManager(getContext()));
        rcylCoupon.setAdapter(new CouponAdapter(couponModels));

    }
}
package com.example.myapplication.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.ServiceAdapter;
import com.example.myapplication.model.BannerModel;
import com.example.myapplication.model.CategoryModel;
import com.example.myapplication.model.CouponModel;
import com.example.myapplication.model.ServiceModel;
import com.example.myapplication.util.ConstantData;

import java.util.ArrayList;
import java.util.Locale;


public class  homeFragment extends Fragment {
    View view;
    Button btn;

    TextView user;

    AutoCompleteTextView etsearch;
    ImageSlider imageSlider;

    RecyclerView rcylCat,rcylservice;



    public ArrayList<BannerModel> banner;

    public ArrayList<CategoryModel> category;
    public ArrayList<ServiceModel> service;

    public homeFragment(ArrayList<BannerModel> banner, ArrayList<CouponModel> coupon, ArrayList<CategoryModel> category, ArrayList<ServiceModel> service) {
        this.banner = banner;
        this.category = category;
        this.service = service;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSlider = view.findViewById(R.id.imageslider);
        rcylCat = view.findViewById(R.id.rcylCat);
        rcylservice = view.findViewById(R.id.rcylservice);
        etsearch = view.findViewById(R.id.etsearch);
        user = view.findViewById(R.id.user);
        rcylCat.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        SharedPreferences sp=getActivity().getSharedPreferences(ConstantData.SP_NAME, Context.MODE_PRIVATE);

        String name=sp.getString(ConstantData.KEY_USERNAME,"Guest");
        user.setText(name);
        setBanner();
        com.example.myapplication.adapter.SearchAdapter adapter = new com.example.myapplication.adapter.SearchAdapter(getContext(), service);
        etsearch.setAdapter(adapter);
        etsearch.setThreshold(1);
    }

    public void setBanner(){
        ArrayList<SlideModel> imageList = new ArrayList<>();

        for (int i = 0; i < banner.size(); i++){
            imageList.add(
                    new SlideModel(
                            ConstantData.SERVER_ADDRESS_IMG + banner.get(i).getBanner_pic(),
                            null,
                            ScaleTypes.FIT
                    )
            );

        }
        imageSlider.setImageList(imageList);
        CategoryAdapter adapter=new CategoryAdapter(category,service);
        rcylCat.setAdapter(adapter);
        rcylservice.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ServiceAdapter serviceAdapter=new ServiceAdapter(service);
        rcylservice.setAdapter(serviceAdapter);


    }
}
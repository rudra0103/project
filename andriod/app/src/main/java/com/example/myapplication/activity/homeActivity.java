package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.api.Data_Api;
import com.example.myapplication.fragment.BookingFragment;
import com.example.myapplication.fragment.homeFragment;
import com.example.myapplication.fragment.profileFragment;
import com.example.myapplication.fragment.couponFragment;
import com.example.myapplication.model.BannerModel;
import com.example.myapplication.model.CategoryModel;
import com.example.myapplication.model.CouponModel;
import com.example.myapplication.model.DataOutputModel;
import com.example.myapplication.model.ServiceModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {


    public ArrayList<BannerModel> banner;
    public ArrayList<CouponModel> coupon;
    public ArrayList<CategoryModel> category;
    public ArrayList<ServiceModel> service;



    BottomNavigationView bnvHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        bnvHome=findViewById(R.id.bnvHome);
        new Data_Api().getData(this);


        bnvHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if(item.getItemId()==R.id.menu_home){
                    openFragment(new homeFragment(banner,coupon,category,service));
                } else if (item.getItemId()==R.id.menu_search) {
                    openFragment(new couponFragment(coupon));
                } else if (item.getItemId()==R.id.menu_cart) {
                    openFragment(new BookingFragment());
                }else {
                    openFragment(new profileFragment());
                }
                return true;
            }
        });
    }

    public  void openFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment,null);
        ft.commit();
    }

    public  void replaceFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment,null);
        ft.commit();
    }
    public void getData(DataOutputModel data){
        banner=data.getBanner();
        category=data.getCategory();
        coupon=data.getCoupon();
        service=data.getService();
        openFragment(new homeFragment(banner,coupon,category,service));
    }
}
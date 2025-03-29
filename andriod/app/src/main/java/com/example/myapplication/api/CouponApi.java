package com.example.myapplication.api;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.activity.BookingActivity;
import com.example.myapplication.model.CouponOutputModel;
import com.example.myapplication.util.ConstantData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CouponApi {
    public void apply_coupon(Context context,String code){

        String url= ConstantData.APPLY_COUPON_METHOD;
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                CouponOutputModel p= new Gson().fromJson(response, CouponOutputModel.class);
                if(p.status){
                    Toast.makeText(context, p.getMessage(), Toast.LENGTH_SHORT).show();

                    ((BookingActivity)context).setcoupon(p);

                }else{
                    Toast.makeText(context, p.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(context, "error:"+volleyError.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("code",code);
                return map;
            }
        };
        requestQueue.add(stringRequest);

    }
}
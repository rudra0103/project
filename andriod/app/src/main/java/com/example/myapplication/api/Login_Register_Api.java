package com.example.myapplication.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.activity.homeActivity;
import com.example.myapplication.model.PersonOutputModel;
import com.example.myapplication.util.ConstantData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Login_Register_Api {
    public  void register(Context context,String username,String password, String email,String mobileno){

        String URL= ConstantData.REGISTER_METHOD;

        ProgressDialog mProgressDialog =new ProgressDialog(context);
        mProgressDialog.setTitle("This is TITLE");
        mProgressDialog.setMessage("This is MESSAGE");
        mProgressDialog.show();

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
                try {
                    Gson gson=new Gson();
                    PersonOutputModel p =gson.fromJson(response, PersonOutputModel.class);
                    if (p.getStatus()){
                        Toast.makeText(context, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }else{
                        Toast.makeText(context, p.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){
                    Toast.makeText(context, "ERROR"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressDialog.dismiss();

                Toast.makeText(context, "SERVER ERROR"+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("username",username);
                map.put("password",password);
                map.put("email",email);
                map.put("mobileno",mobileno);

                return map;
            }
        };

//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                6000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
//        );

        requestQueue.add(stringRequest);

    }

    public  void login(Context context,String password, String email){

        String URL= ConstantData.LOGIN_METHOD;

        ProgressDialog mProgressDialog =new ProgressDialog(context);
        mProgressDialog.setTitle("This is TITLE");
        mProgressDialog.setMessage("This is MESSAGE");
        mProgressDialog.show();

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
                try {
                    Gson gson=new Gson();
                    PersonOutputModel p =gson.fromJson(response, PersonOutputModel.class);
                    if (p.getStatus()){
                        Toast.makeText(context, "User Login Successfully", Toast.LENGTH_SHORT).show();

                        SharedPreferences sp = context.getSharedPreferences(ConstantData.SP_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed = sp.edit();

                        ed.putString(ConstantData.KEY_USERNAME,p.getPerson().getUsername());
                        ed.putString(ConstantData.KEY_CONTACT,p.getPerson().getMobileno());
                        ed.putString(ConstantData.KEY_EMAIL,p.getPerson().getEmail());
                        ed.putString(ConstantData.KEY_USER_ID,p.getPerson().get_id());
                        ed.putBoolean(ConstantData.KEY_SP_ISLOGIN,true);
                        ed.apply();

                        Intent intent=new Intent(context, homeActivity.class);
                        context.startActivity(intent);
                    }else{
                        Toast.makeText(context, p.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){
                    Toast.makeText(context, "ERROR"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressDialog.dismiss();

                Toast.makeText(context, "SERVER ERROR"+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<>();
                map.put("password",password);
                map.put("email",email);

                return map;
            }
        };

//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                6000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
//        );

        requestQueue.add(stringRequest);

    }
}

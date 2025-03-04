package com.example.myapplication.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.activity.homeActivity;
import com.example.myapplication.model.DataOutputModel;
import com.example.myapplication.util.ConstantData;
import com.google.gson.Gson;

import okhttp3.Response;

public class Data_Api {
    public void getData(Context context){
//        ProgressDialog dialog =new ProgressDialog (context);
//        dialog.setMessage("Please wait...");
//        dialog.setCancelable(false);
//        dialog.show();

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request= new StringRequest(
                Request.Method.GET,
                ConstantData.DATA_METHOD,
                response -> {
                    //dialog.dismiss();
                   DataOutputModel data=new Gson().fromJson(response,DataOutputModel.class);
                   if (data.isStatus()){
                       ((homeActivity)context).getData(data);
                       Toast.makeText(context, "Data Get Successfully", Toast.LENGTH_SHORT).show();
                   }


                },
                error -> {
                    //dialog.dismiss();
                    Toast.makeText(context, "SERVER ERROR"+error.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("SERVER ERROR ",error.toString());
                }

        );
        queue.add(request);


    }
}

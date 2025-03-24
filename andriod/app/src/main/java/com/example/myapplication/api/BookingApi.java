package com.example.myapplication.api;

import android.app.ProgressDialog;
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
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.activity.ThankyouActivity;
import com.example.myapplication.model.BookingOutputModel;
import com.example.myapplication.model.PersonOutputModel;
import com.example.myapplication.util.ConstantData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class BookingApi {
    public  void confirm(Context context,String uid,String pid,String address,String service_date,String service_time,String status,String c_o,String c_discount,String c_code){

        String URL= ConstantData.BOOKING;

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
                    BookingOutputModel p =gson.fromJson(response, BookingOutputModel.class);
                    if (p.isStatus()){
                        Toast.makeText(context, "Booking Confirmed", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, ThankyouActivity.class);
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
                map.put("uid",uid);
                map.put("pid",pid);
                map.put("address",address);
                map.put("service_date",service_date);
                map.put("service_time",service_time);
                map.put("status",status);
                map.put("c_o",c_o);
                map.put("c_discount",c_discount);
                map.put("c_code",c_code);

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

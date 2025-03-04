package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.api.Login_Register_Api;
import com.example.myapplication.util.ConstantData;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class otpActivity extends AppCompatActivity {
    EditText otp1,otp2,otp3,otp4;
    Button btnotp,btnwotp;


    String username, password, email, mobileno,verificationId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ui_ids();
        etswicher();
        btnotp =findViewById(R.id.btnotp);
        //btnwotp =findViewById(R.id.btnwotp);


        btnotp.setOnClickListener(v -> {
            if (isOtpValid()){
                String code=getOtp();
                verifyOTP(code);
            }else {
                Toast.makeText(this, "Please Enter Valid OTP ", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public  void ui_ids() {
        otp1=findViewById(R.id.etOtp1);
        otp2=findViewById(R.id.etOtp2);
        otp3=findViewById(R.id.etOtp3);
        otp4=findViewById(R.id.etOtp4);
        btnotp =findViewById(R.id.btnotp);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        email = getIntent().getStringExtra("email");
        mobileno = getIntent().getStringExtra("mobileno");
        verificationId= getIntent().getStringExtra("verificationId");
        // Ensure this is received


    }
    
    public void etswicher(){
        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null){
                    if (s.length()== 1){
                        otp2.requestFocus();

                    }
                }

            }
        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null){
                    if (s.length()== 1){
                        otp3.requestFocus();

                    }
                }

            }
        });
        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null){
                    if (s.length()== 1){
                        otp4.requestFocus();

                    }
                }

            }
        });
        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }
    private boolean isOtpValid() {
        return !(otp1.getText().toString().trim().isEmpty() ||
                otp2.getText().toString().trim().isEmpty() ||
                otp3.getText().toString().trim().isEmpty() ||
                otp4.getText().toString().trim().isEmpty());
    }

    private String getOtp() {
        return otp1.getText().toString() +
                otp2.getText().toString() +
                otp3.getText().toString() +
                otp4.getText().toString();
    }
    public void verifyOTP(String code) {
        if (verificationId == null || verificationId.isEmpty()) {
            Toast.makeText(this, "Verification ID missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");

            Request request = new Request.Builder()
                    .url("https://cpaas.messagecentral.com/verification/v3/validateOtp?countryCode=91&mobileNumber=" +
                            mobileno + "&verificationId=" + verificationId + "&customerId="+ ConstantData.CUSTOMER_ID +"&code=" + code)
                    .method("GET", null)  // GET requests shouldn't have a body
                    .addHeader("authToken", ConstantData.AUTH_TOKEN )
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    runOnUiThread(() -> {
                        Toast.makeText(otpActivity.this, "Verification successful", Toast.LENGTH_SHORT).show();
                        //pending register api

                       // Intent intent = new Intent(otpActivity.this, LoginActivity.class);
                        //startActivity(intent);
                        // finish();
                        new Login_Register_Api().register(otpActivity.this,username,password,email,mobileno);
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(otpActivity.this, "Invalid OTP. Try again!", Toast.LENGTH_SHORT).show());
                }
            } catch (IOException e) {
                Log.e("ERROR", e.getLocalizedMessage());
                runOnUiThread(() -> Toast.makeText(otpActivity.this, "Network error! Try again.", Toast.LENGTH_SHORT).show());
            }
        });
    }
}
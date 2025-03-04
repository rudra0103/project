package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.api.Login_Register_Api;
import com.example.myapplication.util.ConstantData;
import com.example.myapplication.util.Validations;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class signup extends AppCompatActivity {

    EditText editPwd,editMobile,editEmail,editUname;
    Button btnsingup,btnwotp;

    String  password,mobileno,email ,username;





    TextView tvLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvLogin=findViewById(R.id.tvLogin);
        btnsingup=findViewById(R.id.btnsingup);

        editMobile=findViewById(R.id.editMobile);

        editEmail=findViewById(R.id.editEmail);
        editPwd=findViewById(R.id.editPwd);
        editUname=findViewById(R.id.editUname);
        btnwotp =findViewById(R.id.btnwotp);
        btnwotp.setOnClickListener(v -> {
                  Intent intent = new Intent(this, homeActivity.class);
                startActivity(intent);
               });


            tvLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


        });
        btnsingup.setOnClickListener(v -> {

             mobileno=editMobile.getText().toString();
             email=editEmail.getText().toString();
             password=editPwd.getText().toString();
             String conpass=editUname.getText().toString();
             username=editUname.getText().toString();
             if (TextUtils.isEmpty(username)){
                 editUname.setError("Username is Requried");
             } else if (TextUtils.isEmpty(mobileno)){
                editMobile.setError("Mobile number Requried");
            } else if (mobileno.length()!=10) {
                editMobile.setError("Mobile Number is 10 Dgit only");
                
            } else if (TextUtils.isEmpty(email)) {
                editEmail.setError("Email is Reuired");
            } else if (!Validations.isValidEmail(email)) {
                 editEmail.setError("Email is Invalid");
             } else if (TextUtils.isEmpty(password)) {
                editPwd.setError("Passworld Is Requried");

            } else if (TextUtils.isEmpty(conpass)) {
                editUname.setError("Username is Requried");
            } else {
                generateOTP(mobileno);
                 new Login_Register_Api().register(this,username,password,email,mobileno);
            }
        });


    }
    public void generateOTP(String mobileno) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // Run in background thread
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");

            Request request = new Request.Builder()
                    .url("https://cpaas.messagecentral.com/verification/v3/send?countryCode=91&customerId="+ ConstantData.CUSTOMER_ID+"&flowType=SMS&mobileNumber=" + mobileno)
                    .method("POST", body)
                    .addHeader("authToken", ConstantData.AUTH_TOKEN)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    String responseBody = response.body().string();

                    JSONObject jsonResponse = new JSONObject(responseBody);

                    // Extract verificationId from the response
                    JSONObject data = jsonResponse.getJSONObject("data");
                    String verificationId = data.getString("verificationId");

                    // Send data to OTPActivity
                    runOnUiThread(() -> {
                        Intent intent = new Intent(signup.this, otpActivity.class);
                        intent.putExtra("mobileno", mobileno);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        intent.putExtra("email", email);
                        intent.putExtra("verificationId", verificationId); // Pass verificationId
                        startActivity(intent);
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(signup.this, "OTP request failed", Toast.LENGTH_SHORT).show());
                }
            } catch (IOException | JSONException e) {
                Log.e("ERROR", e.getLocalizedMessage());
                runOnUiThread(() -> Toast.makeText(signup.this, "Network error! Try again.", Toast.LENGTH_SHORT).show());
            }
        });
    }

}
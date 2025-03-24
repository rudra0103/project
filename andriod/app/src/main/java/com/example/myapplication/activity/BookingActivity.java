package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.api.BookingApi;
import com.example.myapplication.model.ServiceModel;
import com.example.myapplication.util.ConstantData;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class BookingActivity extends AppCompatActivity implements PaymentResultListener {

    TextInputEditText t1,t2,t3,t4,t5,t6;
    RadioButton rbtnCOD,rbtnOnline;
    RadioGroup rdbPayment;
    String c_o="cash";
    String uid="0";


    String address="";
    TextView tvChangeAddress,tvaddress,tvitem_total,tvtotal;

    Button btnSaveAddress,btnCheckout;
    ImageView img;
    TextView txtName, txtDate, txtTime,txtPrice;
    ServiceModel model;
TextInputEditText etCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        model = (ServiceModel) getIntent().getSerializableExtra("model");

        img = findViewById(R.id.img);
        txtName = findViewById(R.id.txtName);
        etCode = findViewById(R.id.etCode);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txTime);
        txtPrice = findViewById(R.id.txtPrice);
        Glide.with(this).load(ConstantData.SERVER_ADDRESS_IMG + model.getSer_pic1()).into(img);
        txtName.setText(model.getTitle());
        txtPrice.setText(model.getPrice());
        txtTime.setText(getIntent().getStringExtra("time"));
        txtDate.setText(getIntent().getStringExtra("date"));

        tvtotal = findViewById(R.id.tvtotal);
        btnCheckout = findViewById(R.id.btnCheckout);
        rbtnCOD = findViewById(R.id.rbtnCOD);
        rbtnOnline = findViewById(R.id.rbtnOnline);
        tvChangeAddress = findViewById(R.id.tvChangeAddress);
        tvaddress = findViewById(R.id.address);
        tvitem_total = findViewById(R.id.tvitem_total);
        rdbPayment = findViewById(R.id.rdbPayment);

        final BottomSheetDialog bottomSheetTeachersDialog = new BottomSheetDialog(BookingActivity.this);

        View layout = LayoutInflater.from(BookingActivity.this).inflate(R.layout.address, null);

        // passing our layout file to our bottom sheet dialog.
        bottomSheetTeachersDialog.setContentView(layout);
        t1 = layout.findViewById(R.id.t1);
        t2 = layout.findViewById(R.id.t2);
        t3 = layout.findViewById(R.id.t3);
        t4 = layout.findViewById(R.id.t4);
        t5 = layout.findViewById(R.id.t5);
        t6 = layout.findViewById(R.id.t6);
        btnSaveAddress = layout.findViewById(R.id.btnSaveAddress);

        bottomSheetTeachersDialog.setCancelable(false);

        bottomSheetTeachersDialog.setCanceledOnTouchOutside(true);
        btnSaveAddress.setOnClickListener(v -> {
            address = t1.getText().toString() + "," + t2.getText().toString() + "," + t3.getText().toString()
                    + "," + t4.getText().toString() + "," + t5.getText().toString() + "," + t6.getText().toString();
            tvaddress.setText(address);
            bottomSheetTeachersDialog.dismiss();

        });

        tvChangeAddress.setOnClickListener(v -> {

            bottomSheetTeachersDialog.show();

        });

        rdbPayment = findViewById(R.id.rdbPayment);


        SharedPreferences sp = getSharedPreferences(ConstantData.SP_NAME, MODE_PRIVATE);
        uid = sp.getString(ConstantData.KEY_USER_ID, "0");
        if (uid.equals("0")) {
            Intent intent = new Intent(BookingActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
        }


        btnCheckout.setOnClickListener(v -> {
            if (rdbPayment.getCheckedRadioButtonId() == R.id.rbtnCOD) {
                c_o = "cash";
            } else {
                c_o = "online";
            }
            if (address.trim().length() == 0) {
                Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show();
            } else {

                if (c_o.equals("cash")) {
                    new BookingApi().confirm(BookingActivity.this,uid,model.getId(),address,getIntent().getStringExtra("date"),getIntent().getStringExtra("time"),"0",c_o,"0","0");
                } else {
                    openRazorPay();
                }
            }

        });
    }

    public void openRazorPay(){
        int tot=Integer.parseInt(model.getPrice());
        Checkout checkout = new Checkout();

        // set your id as below
        checkout.setKeyID("rzp_test_Qi8mCCOIlysMtE");

        // set image
        checkout.setImage(R.mipmap.ic_launcher);

        // initialize json object
        JSONObject object = new JSONObject();
        try {
            // to put name
            object.put("name", "Quidoo");

            // put description
            object.put("description", "Test payment");

            // to set theme color
            object.put("theme.color", "#7954CA");

            // put the currency
            object.put("currency", "INR");

            // put amount
            object.put("amount", tot*100);

            // put mobile number
            object.put("prefill.contact", "9998520104");

            // put email
            object.put("prefill.email", "kushkhakhiwala123@gmail.com");

            // open razorpay to checkout activity
            checkout.open(
                    BookingActivity.this, object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onPaymentSuccess(String s) {
        new BookingApi().confirm(BookingActivity.this,uid,model.getId(),address,getIntent().getStringExtra("date"),getIntent().getStringExtra("time"),"0","online","0","0");

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment error", Toast.LENGTH_SHORT).show();
    }
}
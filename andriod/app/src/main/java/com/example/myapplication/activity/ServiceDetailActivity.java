package com.example.myapplication.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;
import com.example.myapplication.model.ServiceModel;
import com.example.myapplication.util.ConstantData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ServiceDetailActivity extends AppCompatActivity {

    TextView title,Ser_duration,price,ser_cat,id_gender,description,disc,tvDate,tvTime;
    Button btnBook;
    ImageSlider shoesimages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        title=findViewById(R.id.title);
        shoesimages=findViewById(R.id.shoesimages);
        tvDate=findViewById(R.id.tvDate);
        tvTime=findViewById(R.id.tvTime);
        Ser_duration=findViewById(R.id.Ser_duration);
        price=findViewById(R.id.price);
        ser_cat=findViewById(R.id.ser_cat);
        id_gender=findViewById(R.id.id_gender);
        description=findViewById(R.id.description);
        disc=findViewById(R.id.disc);
        btnBook=findViewById(R.id.btnBook);

        ServiceModel model= (ServiceModel) getIntent().getSerializableExtra("model");

        title.setText(model.getTitle());
        price.setText(model.getPrice());
        Ser_duration.setText(model.getDuration());
        ser_cat.setText(model.getSer_cat());
//        id_gender.setText(model.ge());
        description.setText(model.getDescription());
//        disc.setText(model.get());

        btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookingActivity.class);
            intent.putExtra("model", model);
            intent.putExtra("date", tvDate.getText().toString());
            intent.putExtra("time", tvTime.getText().toString());
            startActivity(intent);

        });

        tvDate.setOnClickListener(v -> {
            openDatePicker();
        });

        tvTime.setOnClickListener(v -> {
            openTimePicker();
        });


        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(ConstantData.SERVER_ADDRESS_IMG+model.getSer_pic1(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(ConstantData.SERVER_ADDRESS_IMG+model.getSer_pic2(), ScaleTypes.FIT));
        slideModels.add(new SlideModel(ConstantData.SERVER_ADDRESS_IMG+model.getSer_pic3(), ScaleTypes.FIT));



        shoesimages.setImageList(slideModels);

    }

    private void openDatePicker() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and show the DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ServiceDetailActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Format the selected date and update the TextView
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(selectedDate.getTime());
                        tvDate.setText(formattedDate);
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }

    private void openTimePicker() {
        // Get the current time
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create and show the TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                ServiceDetailActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Format the selected time and update the TextView
                        Calendar selectedTime = Calendar.getInstance();
                        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        selectedTime.set(Calendar.MINUTE, minute);
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        String formattedTime = timeFormat.format(selectedTime.getTime());
                        tvTime.setText(formattedTime);
                    }
                },
                hour, minute, true); // true for 24-hour format

        timePickerDialog.show();
    }

}
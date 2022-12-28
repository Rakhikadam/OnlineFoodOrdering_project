package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Page9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9);
        ImageView image1 = findViewById(R.id.imagebirth);
        Button next = findViewById(R.id.submit);

        TextView birhdate = findViewById(R.id.spinnerpage9);
        birhdate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
              DatePickerDialog datePickerDialog = new DatePickerDialog(Page9.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                      birhdate.setText(i2+"-"+(i1+1)+"-"+i);
                  }
              },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));


              datePickerDialog.show();
            }
        });






        TextView annversary = findViewById(R.id.spinner2page9);
        annversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(Page9.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        annversary.setText(i2+"-"+(i1+1)+"-"+i);

                    }
                },2022,11,27);
                datePicker.show();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page9.this,Page10.class);
                startActivity(intent);
            }
        });
    }
}
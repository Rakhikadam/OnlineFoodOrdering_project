package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Page5 extends AppCompatActivity {
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        TextView text = findViewById(R.id.text7);
        Button button =findViewById(R.id.button);
        button.setText("GET OTP");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = text.getText().toString();
                if (Pattern.matches("[[7-9]+[0-9]],{8}",number)){
                editor.putString("mobile number",number);
                editor.commit();
                }
                else {
                    Toast.makeText(Page5.this, "Enter the valid number", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(Page5.this,Page7.class);
                startActivity(intent);


                return;

            }

        });



    }
}
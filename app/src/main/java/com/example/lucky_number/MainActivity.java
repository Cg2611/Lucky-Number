package com.example.lucky_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;
    EditText edt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        edt=findViewById(R.id.editTextTextPersonName);
        txt= findViewById(R.id.textView);
        img=findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= edt.getText().toString();

                //Explicit Intent
                Intent i= new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("name", username);
                startActivity(i);

            }
        });
    }


}
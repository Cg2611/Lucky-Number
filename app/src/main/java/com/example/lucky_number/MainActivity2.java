package com.example.lucky_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView txt2, txt3;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt2=findViewById(R.id.textView2);
        txt3=findViewById(R.id.textView3);
        btn3=findViewById(R.id.button2);

        Intent i= getIntent();
        String username= i.getStringExtra("name");

        int disp= randomnumgen();
        txt3.setText(""+disp);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(username,disp);
            }
        });

    }

    public int randomnumgen(){
        Random random= new Random();
        int upperlimit=1000;
        int num= random.nextInt(upperlimit);
        return num;
    }

    public void sharedata(String userName, int disp){
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName + "got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is "+disp );
        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}
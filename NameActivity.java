package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {
    TextView greeting;
    Button thanks;
    Button dontCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        greeting = (TextView) findViewById(R.id.firstText);
        thanks = (Button) findViewById(R.id.thankButton);
        dontCall = (Button) findViewById(R.id.button);

        String name = getIntent().getStringExtra("name");
        greeting.setText("Welcome " + name + "!");
        dontCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                returnActivityResult(RESULT_CANCELED);
            }
        });

        thanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                returnActivityResult(RESULT_OK);
            }
        });

    }
    public void returnActivityResult(int resultCode) {
        Intent myIntent = new Intent();
        if (resultCode == RESULT_OK) {
            setResult(RESULT_OK, myIntent);
        } else {
            setResult(RESULT_CANCELED, myIntent);
        }
        finish();
    }

}
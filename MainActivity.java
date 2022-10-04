package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView firstText = findViewById(R.id.firstText);
        editText =  findViewById(R.id.firstText);
        button =findViewById(R.id.button);
        button.setOnClickListener(click -> {
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("name", firstText.getText().toString());
            startActivityForResult(intent, 2);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                finish();
            }
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences share = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String string = share.getString("name", "");
        editText.setText(string);
    }



}
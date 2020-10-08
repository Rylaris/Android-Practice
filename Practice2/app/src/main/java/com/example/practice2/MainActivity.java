package com.example.practice2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        final EditText number = findViewById(R.id.number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer data = Integer.parseInt(number.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Integer number = null;
                if (data != null) {
                    number = data.getIntExtra("returnData", 0);
                    button.setText("上一个Activity返回" + number);
                }

            }
        }
    }
}

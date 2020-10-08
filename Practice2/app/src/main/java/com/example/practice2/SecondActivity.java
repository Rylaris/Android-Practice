package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.button2);
        Intent intent = getIntent();
        final Integer data = intent.getIntExtra("data", 0);
        button.setText("上一个Activity传来" + data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("returnData", data * 2);
                setResult(RESULT_OK, intent);
                finish();
//                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}

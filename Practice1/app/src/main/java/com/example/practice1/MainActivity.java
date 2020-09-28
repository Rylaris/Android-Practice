package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SignInDialogFragment.NoticeDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.sign_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SignInDialogFragment();
                newFragment.show(getSupportFragmentManager(), "missiles");
            }
        });
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        SignInDialogFragment fragment = (SignInDialogFragment) dialog;
        View view = fragment.myView;
        EditText username = view.findViewById(R.id.username);
        EditText password = view.findViewById(R.id.password);
        String u = username.getText().toString();
        String p = password.getText().toString();
        if (u.equals("abc") && p.equals("123")) {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG)
                    .show();
        } else {
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG)
                    .show();
        }

    }
}

package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.activity.ResultActivity;
import com.example.myapplication.service.UserService;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUserName;
    private EditText mEtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.imageButton1);
        final UserService userService = new UserService();
        mEtUserName = findViewById(R.id.editText1);
        mEtPassword = findViewById(R.id.editText2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUserName.getText().toString();
                String password = mEtPassword.getText().toString();
                boolean login = userService.login(userName, password);
                ResultActivity.start(MainActivity.this);
            }
        });
    }
}

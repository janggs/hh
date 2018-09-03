package com.example.hong.boaaproject.firstActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hong.boaaproject.R;
import com.example.hong.boaaproject.mainActivity.MainActivity;

public class Login extends AppCompatActivity {

    TextView tvLostPW;
    Button btnLogin;
    EditText inputID, inputPW;
    String id, pw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login);
        Intent intent = getIntent();

        inputID = findViewById(R.id.etID);
        inputPW = findViewById(R.id.etPW);
        tvLostPW = (findViewById(R.id.tvLostPW));

        tvLostPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Hint.class);
                startActivity(intent);
            }
        });

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = inputID.getText().toString();
                pw = inputPW.getText().toString();

                //입력이 전부 되지 않았으면 다이얼로그를 띄운다. 참고 홈페이지 : http://uroa.tistory.com/2
                if (TextUtils.isEmpty(id)||TextUtils.isEmpty(pw)){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Login.this);
                    dlg.setMessage("모든 정보를 입력해주세요.");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                } else {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
                }
            }
        });


    }
}

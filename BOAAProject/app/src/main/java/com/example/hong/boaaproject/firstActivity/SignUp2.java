package com.example.hong.boaaproject.firstActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.hong.boaaproject.R;
import com.example.hong.boaaproject.mainActivity.MainActivity;

public class SignUp2 extends AppCompatActivity {

    ImageButton imgPrev, imgMale, imgFemale;
    EditText etHeight, etWeight;
    String height, weight;
    String gender = "null";
    Button btnDone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_signup2);

        Intent intent = this.getIntent();
        //TODO:intent로 id,name,pw,pwHint 받아오기

        imgMale = (findViewById(R.id.imgMale));
        imgFemale = (findViewById(R.id.imgFemale));

        etHeight = (findViewById(R.id.etHeight));
        etWeight = (findViewById(R.id.etWeight));
        height = etHeight.getText().toString();
        weight = etWeight.getText().toString();

        imgPrev = (findViewById(R.id.imgPrev));

        //이전화면으로 돌아가기
        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //성별 선택
        imgMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "male";
            }
        });

        imgFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "female";
            }
        });


        btnDone = (findViewById(R.id.btnDone));
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 AlertDialog.Builder dlg = new AlertDialog.Builder(SignUp2.this);
                //몸무게나 키나 성별이 입력되지 않았으면 다음화면으로 넘어갈 수 없다. 참고 홈페이지 : http://uroa.tistory.com/2
                /* 추후수정
                if (TextUtils.isEmpty(height)||TextUtils.isEmpty(weight)||gender.equals("null")){
                    dlg.setMessage("모든 정보를 입력해주세요.");
                    dlg.setPositiveButton("확인", null);
                    dlg.show();
                } else { */
                    dlg.setMessage("회원가입 하시겠습니까?");
                    dlg.setPositiveButton("네!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            AlertDialog.Builder dlgOK = new AlertDialog.Builder(SignUp2.this);
                            dlgOK.setMessage("회원가입 되었습니다.");
                            dlgOK.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(SignUp2.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                            dlgOK.show();
                        }
                    });
                    dlg.setNegativeButton("아직이요!", null);
                    dlg.show();
                }
            //}
        });
    }
}

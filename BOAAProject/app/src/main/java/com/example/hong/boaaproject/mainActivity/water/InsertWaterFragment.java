package com.example.hong.boaaproject.mainActivity.water;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong.boaaproject.R;
import com.john.waveview.WaveView;

public class InsertWaterFragment extends Fragment {


    int twt = 0;
    int pg = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_insert_water_fragment, container, false);


        final WaveView waveView = (WaveView) view.findViewById(R.id.wave_view);
        final TextView totwt = (TextView) view.findViewById(R.id.totalwt);
        final ImageView sbb = (ImageView) view.findViewById(R.id.sbb);
        ImageButton btnps1 = (ImageButton) view.findViewById(R.id.btnplus1);
        ImageButton btnps2 = (ImageButton) view.findViewById(R.id.btnplus2);
        ImageButton btnms1 = (ImageButton) view.findViewById(R.id.btnmin1);
        ImageButton btnms2 = (ImageButton) view.findViewById(R.id.btnmin2);


        btnps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                // 더하기(+) 버튼 누를 경우
                twt = twt + 100;
                pg = pg + 5;
                waveView.setProgress(pg);                                   // wave(수면높이)증가
                if (twt >= 2000) {
                    sbb.setImageResource(R.drawable.sbf);                   // 권장물섭취량(2000ml)가 넘을경우 이미지 변경
                } else if (twt < 0){
                    twt = 0;
                    pg = 0;
                }
                else{
                    sbb.setImageResource(R.drawable.sb1);                   // 권장 물 섭취량이 아닐경우 원래이미지로 돌아옴
                }
                totwt.setText("오늘은 총 " + twt + "ml의 물을 섭취했습니다."); // 총 섭취량 텍스트 변경
            }
        });
        btnms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twt = twt - 100;
                pg = pg - 5;
                waveView.setProgress(pg);                                   // 빼기(-) 버튼 누를 경우
                if (twt >= 2000) {
                    sbb.setImageResource(R.drawable.sbf);
                } else if (twt < 0){                                        //물 섭취량이 0이하로 떨어질 경우에 0 유지
                    twt = 0;
                    pg = 0;
                }
                else{
                    sbb.setImageResource(R.drawable.sb1);
                }
                totwt.setText("오늘은 총 " + twt + "ml의 물을 섭취했습니다.");
            }
        });
        btnps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twt = twt + 500;
                pg = pg + 25;
                waveView.setProgress(pg);
                if (twt >= 2000) {
                    sbb.setImageResource(R.drawable.sbf);
                } else if (twt < 0){
                    twt = 0;
                    pg = 0;
                }
                else{
                    sbb.setImageResource(R.drawable.sb1);
                }
                totwt.setText("오늘은 총 " + twt + "ml의 물을 섭취했습니다.");
            }
        });
        btnms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twt = twt - 500;
                pg = pg - 25;
                waveView.setProgress(pg);
                if (twt >= 2000) {
                    sbb.setImageResource(R.drawable.sbf);
                } else if (twt < 0) {
                    twt = 0;
                    pg = 0;
                }
                else{
                    sbb.setImageResource(R.drawable.sb1);
                }

                totwt.setText("오늘은 총 " + twt + "ml의 물을 섭취했습니다.");

            }


        });

        return view;
        }
    }
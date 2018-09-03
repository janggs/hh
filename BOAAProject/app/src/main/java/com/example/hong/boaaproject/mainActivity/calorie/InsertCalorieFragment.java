package com.example.hong.boaaproject.mainActivity.calorie;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hong.boaaproject.R;

public class InsertCalorieFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_insert_calorie_fragment, container, false);

        ImageView insertBFBtn = (ImageView) view.findViewById(R.id.breakfastBtn);
        ImageView insertLCBtn = (ImageView) view.findViewById(R.id.lunchBtn);
        ImageView insertDNBtn = (ImageView)view.findViewById(R.id.dinnerBtn);
        ImageView insertSNBtn = (ImageView)view.findViewById(R.id.snackBtn);



        insertBFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertBFBtnIntent = new Intent(InsertCalorieFragment.this.getActivity(), SearchCalorie.class);
                InsertCalorieFragment.this.startActivity(insertBFBtnIntent);
            }
        });
        insertLCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertBFBtnIntent = new Intent(InsertCalorieFragment.this.getActivity(), SearchCalorie.class);
                InsertCalorieFragment.this.startActivity(insertBFBtnIntent);
            }
        });
        insertDNBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertBFBtnIntent = new Intent(InsertCalorieFragment.this.getActivity(), SearchCalorie.class);
                InsertCalorieFragment.this.startActivity(insertBFBtnIntent);
            }
        });
        insertSNBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertBFBtnIntent = new Intent(InsertCalorieFragment.this.getActivity(), SearchCalorie.class);
                InsertCalorieFragment.this.startActivity(insertBFBtnIntent);
            }
        });


        Button targetKcalBtn = view.findViewById(R.id.targetKcal);
        final EditText setKcal = new EditText(getActivity());


        targetKcalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder targetKcalDlg = new AlertDialog.Builder(getActivity());
                targetKcalDlg.setMessage("목표 칼로리 설정");
                targetKcalDlg.setView(setKcal);
                targetKcalDlg.setNegativeButton("설정", null);
                targetKcalDlg.show();

                // CUSTOM DIALOG vs ALERTDIALOG vs ACTIVITY 고민해봐야함.
                // 위에 코드 중복 부모VIEW 오류나서 해결해야함. >> ALERTDIALOG 말고 다른 방법으로
            }
        });


        return view;
    }

}

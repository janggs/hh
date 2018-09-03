package com.example.hong.boaaproject.mainActivity.calorie;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.hong.boaaproject.R;

public class SearchCalorie extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_calorie);

        Toolbar toolBar = findViewById(R.id.toolBar);
        toolBar.setTitle("");
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 툴바 왼쪽 상단에 뒤로가기 버튼 생성


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 뒤로가기 버튼 적용시 홈으로.
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}



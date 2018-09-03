package com.example.hong.boaaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hong.boaaproject.firstActivity.Index;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, Index.class);
        intent.putExtra("state", "launch");
        startActivity(intent);
        finish();

    }
}

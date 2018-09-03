package com.example.hong.boaaproject.firstActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hong.boaaproject.R;
import com.viewpagerindicator.CirclePageIndicator;

public class Index extends AppCompatActivity {

    int MAX_PAGE=4; //뷰페이저의 페이지수
    ViewPager vp;
    Button btn;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_index);

        vp = findViewById(R.id.vpIndex);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager())); //Adapter 설정
        vp.setCurrentItem(0); //앱 실행시 첫번째 페이지로 초기화

        CirclePageIndicator pageIndicator = findViewById(R.id.pageIndicator);
        pageIndicator.setViewPager(vp);

        //뷰페이저인디케이터 크기 및 색 설정
        final float density = getResources().getDisplayMetrics().density; //density(밀도)를 이용해 단말별로 DPI에 맞춰 가변적으로 크기를 바꿀 수 있다.
        pageIndicator.setRadius(7 * density);
        pageIndicator.setFillColor(Color.WHITE);
        pageIndicator.setPageColor(Color.rgb(220,220,220));
        pageIndicator.setStrokeWidth(0); // 코드 출처 :

        //시작하기 버튼 눌렀을 때 다음화면으로 넘어가는 부분
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Index.this, SignUp1.class);
                startActivity(intent);
                finish();
            }
        });

        tv2 = findViewById(R.id.tv2);
        SpannableString content = new SpannableString("로그인");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv2.setText(content);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Index.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //페이지 넘어가는 pagerAdapter 클래스. viewpagerIndicator 라이브러리를 참조했다. 오픈소스 코드 참고 및 라이브러리 출처 : https://github.com/JakeWharton/ViewPagerIndicator
    private class pagerAdapter extends FragmentStatePagerAdapter {
        private pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //원래는 네번째 화면까지 넘겨야 버튼이 활성화 되게끔 만들 계획이었는데, 세번째화면에서 활성화되는 문제를 추후 수정해야 한다.
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            //페이지의 position을 받아와 해당하는 화면을 넘길때마다 프래그먼트를 return한다.
            switch (position)
            {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2 :
                    return new Fragment3();
                case 3 :
                    btn.setEnabled(true);
                    return new Fragment4();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }

}

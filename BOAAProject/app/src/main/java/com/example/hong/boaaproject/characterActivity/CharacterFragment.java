package com.example.hong.boaaproject.characterActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hong.boaaproject.R;

import java.util.Random;

/**
 * Created by gksak on 2018-06-05.
 */

public class CharacterFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_character_fragment, container, false);


        final TextView talk = (TextView) view.findViewById(R.id.talk);
        final ImageButton inventory = (ImageButton) view.findViewById(R.id.inventory);
        final ImageView wear = (ImageView) view.findViewById(R.id.wear);
        ImageButton character = (ImageButton) view.findViewById(R.id.character);
        ImageButton hat1 = (ImageButton) view.findViewById(R.id.hat1);
        ImageButton hat2 = (ImageButton) view.findViewById(R.id.hat2);
        ImageButton hat3 = (ImageButton) view.findViewById(R.id.hat3);
        ImageButton hat4 = (ImageButton) view.findViewById(R.id.hat4);


        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();                                                //캐릭터를 터치하면 랜덤으로 메세지 변경
                int nb = random.nextInt(6);

                switch (nb) {
                    case 1:
                        talk.setText("소풍나갈까?");
                        break;
                    case 2:
                        talk.setText("사과는 먹었나 친구!");
                        break;
                    case 3:
                        talk.setText("오늘도 화이팅이야~!");
                        break;
                    case 4:
                        talk.setText("나는 항상 네편이야");
                        break;
                    case 5:
                        talk.setText("우산 챙겨야하나?");
                        break;
                }
            }
        });

        hat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wear.setImageResource(R.drawable.hat1);                                      //해당 이미지 터치하면 캐릭터에게 적용
            }
        });

        hat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wear.setImageResource(R.drawable.hat2);
            }
        });

        hat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wear.setImageResource(R.drawable.hat3);
            }
        });

        hat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wear.setImageResource(R.drawable.hat4);
            }
        });

        //인벤토리 클릭할 경우 뜨는 창
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder inv = new AlertDialog.Builder(getContext());                    //다이얼로그 설정
                View inventoryList = View.inflate(getContext(), R.layout.inventory_list, null);     //그리드뷰 xml를가져옴
                inv.setView(inventoryList);                                                         //그리드뷰를 다이얼로그안에 적용
                inv.setTitle("아이템을 골라주세요");

                inv.setNegativeButton("초기화",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                wear.setImageResource(R.drawable.wear);
                                Toast.makeText(getContext(),"초기화 되었습니다.",Toast.LENGTH_LONG).show();     //버튼 누를경우 캐릭터 이미지 초기화
                            }
                        });
                inv.setPositiveButton("선택",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                wear.setImageResource(R.drawable.hat5);
                                Toast.makeText(getContext(), "적용 되었습니다.", Toast.LENGTH_LONG).show();    //캐릭터 헤드셋이미지 착용
                            }
                        });

                inv.show();

            }
        });




        return view;
    }

}

package com.example.hong.boaaproject.mainActivity.water;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.hong.boaaproject.R;

public class WaterGraphFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_graph_water_fragment, container, false);

        final ImageView imageView = (ImageView) view.findViewById(R.id.barchart);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        String[] datas = getResources().getStringArray(R.array.spinner_array);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, datas);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.barchart);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.barchart2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

}

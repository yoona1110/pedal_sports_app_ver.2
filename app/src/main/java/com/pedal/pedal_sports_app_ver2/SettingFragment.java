package com.pedal.pedal_sports_app_ver2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SettingFragment extends Fragment {
    private ImageView setting_menuAdd_Disease;
    private ImageView setting_menuAdd_Disorder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        // 질병, 장애 추가버튼
        setting_menuAdd_Disease = view.findViewById(R.id.setting_menuAdd_Disease);
        setting_menuAdd_Disorder = view.findViewById(R.id.setting_menuAdd_Disorder);

        // 질병 추가버튼 클릭 시
        setting_menuAdd_Disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddInfoActivity.class);
                intent.putExtra("result", "어떤 질병이 있으신가요?");             // 데이터 전달
                startActivity(intent);
            }
        });

        // 장애 추가버튼 클릭 시
        setting_menuAdd_Disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddInfoActivity.class);
                intent.putExtra("result", "어떤 장애가 있으신가요?");             // 데이터 전달
                startActivity(intent);
            }
        });
        return view;
    }
}
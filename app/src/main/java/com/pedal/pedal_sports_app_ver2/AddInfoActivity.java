package com.pedal.pedal_sports_app_ver2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pedal.pedal_sports_app_ver2.databinding.ActivityAddInfoBinding;

import org.w3c.dom.Text;

public class AddInfoActivity extends AppCompatActivity {
    private TextView title;
    private EditText edit_search;
    private ImageView btn_search_cancel;
    private ImageView btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewBinding binding = ActivityAddInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // SettingFragment에서 넘겨준 intent 받기
        Intent intent = getIntent();
        String title_receive = intent.getStringExtra("result");

        title = findViewById(R.id.search_title);                                        // 타이틀 출력창
        edit_search = findViewById(R.id.edit_search);                                   // 검색어 입력창
        btn_search_cancel = findViewById(R.id.btn_search_cancel);                       // 입력 취소 버튼
        btn_search = findViewById(R.id.btn_search);                                     // 검색 버튼

        // SettingFragment에서 넘겨받은 value 값 출력
        title.setText(title_receive);

        btn_search_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력창에 적어둔 문자가 있다면
                if (edit_search.length() != 0) {
                    edit_search.setText("");
                    edit_search.requestFocus();
                }
            }
        });
    }
}
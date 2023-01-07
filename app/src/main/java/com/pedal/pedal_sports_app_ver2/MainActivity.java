package com.pedal.pedal_sports_app_ver2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pedal.pedal_sports_app_ver2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding; // view binding

    private BottomNavigationView bottomNavigationView;
    private Menu menu;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private FolderFragment folderFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        // 하단 메뉴바 세팅
        // 메뉴별 탭 페이지
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        folderFragment = new FolderFragment();
        settingFragment = new SettingFragment();

        // 하단 메뉴바 화면 전환 + 선택 시 아이콘 변경
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        menu = bottomNavigationView.getMenu();
        bottomNavigationView.setSelectedItemId(R.id.menu_home);  //선택된 아이템 지정
        menu.findItem(R.id.menu_home).setIcon(R.drawable.ic_menu_home_selected);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu_home:
                        item.setIcon(R.drawable.ic_menu_home_selected);  // 선택한 이미지 변경
                        menu.findItem(R.id.menu_search).setIcon(R.drawable.ic_menu_search_unselected);
                        menu.findItem(R.id.menu_folder).setIcon(R.drawable.ic_menu_folder_unselected);
                        menu.findItem(R.id.menu_setting).setIcon(R.drawable.ic_menu_setting_unselected);

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit(); // 페이지 전환
                        return true;

                    case R.id.menu_search:
                        item.setIcon(R.drawable.ic_menu_search_selected);  // 선택한 이미지 변경
                        menu.findItem(R.id.menu_home).setIcon(R.drawable.ic_menu_home_unselected);
                        menu.findItem(R.id.menu_folder).setIcon(R.drawable.ic_menu_folder_unselected);
                        menu.findItem(R.id.menu_setting).setIcon(R.drawable.ic_menu_setting_unselected);

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit(); // 페이지 전환
                        return true;

                    case R.id.menu_folder:
                        item.setIcon(R.drawable.ic_menu_folder_selected);  // 선택한 이미지 변경
                        menu.findItem(R.id.menu_home).setIcon(R.drawable.ic_menu_home_unselected);
                        menu.findItem(R.id.menu_search).setIcon(R.drawable.ic_menu_search_unselected);
                        menu.findItem(R.id.menu_setting).setIcon(R.drawable.ic_menu_setting_unselected);

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, folderFragment).commit(); // 페이지 전환
                        return true;

                    case R.id.menu_setting:
                        item.setIcon(R.drawable.ic_menu_setting_selected);  // 선택한 이미지 변경
                        menu.findItem(R.id.menu_home).setIcon(R.drawable.ic_menu_home_unselected);
                        menu.findItem(R.id.menu_search).setIcon(R.drawable.ic_menu_search_unselected);
                        menu.findItem(R.id.menu_folder).setIcon(R.drawable.ic_menu_folder_unselected);

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).commit(); // 페이지 전환
                        return true;
                }
                return false;
            }
        });
    }

}
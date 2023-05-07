package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bugawayme.loginFragment.PasswordFragment;
import com.example.bugawayme.loginFragment.VerificationFragment;
import com.example.bugawayme.mainFragment.HomeFragment;
import com.example.bugawayme.mainFragment.MessageFragment;
import com.example.bugawayme.mainFragment.MineFragment;
import com.example.bugawayme.mainFragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ViewPager2 viewPager2;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();
        initPager();




    }

    private void initPager() {
        {
            List<Fragment> list = new ArrayList<>();
            list.add(HomeFragment.newInstance("", ""));
            list.add(ShopFragment.newInstance("", ""));
            list.add(MessageFragment.newInstance("", ""));
            list.add(MineFragment.newInstance("", ""));

            MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), list);

            viewPager2.setAdapter(myFragmentPagerAdapter);
            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }

                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                    changePage(position);

                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    super.onPageScrollStateChanged(state);
                }
            });

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.main_menu_home:
                            viewPager2.setCurrentItem(0);
                            break;
                        case R.id.main_menu_shopping:
                            viewPager2.setCurrentItem(1);
                            break;
                        case R.id.main_menu_message:
                            viewPager2.setCurrentItem(2);
                            break;
                        case R.id.main_menu_mine:
                            viewPager2.setCurrentItem(3);
                            break;

                    }
                    return true;
                }
            });

            bottomNavigationView.getOrCreateBadge(R.id.main_menu_message);
        }
    }


    private void changePage(int position) {
            switch (position) {
                case 0:
                    bottomNavigationView.setSelectedItemId(R.id.main_menu_home);
                    break;
                case 1:
                    bottomNavigationView.setSelectedItemId(R.id.main_menu_shopping);
                    break;
                case 2:
                    bottomNavigationView.setSelectedItemId(R.id.main_menu_message);
                    break;
                case 3:
                    bottomNavigationView.setSelectedItemId(R.id.main_menu_mine);
                    break;
            }

    }

    private void intiView() {
        viewPager2 = findViewById(R.id.vp_main);
        bottomNavigationView = findViewById(R.id.main_bt_navigation);

    }
}
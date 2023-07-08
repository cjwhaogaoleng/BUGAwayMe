package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bugawayme.mainFragment.HomeFragment;
import com.example.bugawayme.mainFragment.MessageFragment;
import com.example.bugawayme.mainFragment.MineFragment;
import com.example.bugawayme.mainFragment.ShopFragment;
import com.example.bugawayme.myViewPager.BannerViewPager;
import com.example.bugawayme.myViewPager.CompatibleViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    List<LinearLayout> tab_list;
    LinearLayout tab_one, tab_two, tab_three, tab_four, tab_five, tab_current, tab_last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intiView();
        initPager();
        initEvent();

    }

    private void initEvent() {
        tab_one.setOnClickListener(this);
        tab_two.setOnClickListener(this);
        tab_three.setOnClickListener(this);
        tab_four.setOnClickListener(this);
        tab_five.setOnClickListener(this);
    }


    private void initPager() {
        {
            List<Fragment> list = new ArrayList<>();
            list.add(HomeFragment.newInstance("", ""));
            list.add(ShopFragment.newInstance("", ""));
            list.add(MessageFragment.newInstance("", ""));
            list.add(MineFragment.newInstance("", ""));

//            MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), list);
            MyFragmentPagerTabAdapter myFragmentPagerTabAdapter = new MyFragmentPagerTabAdapter(getSupportFragmentManager(), list, null);

//            viewPager.setAdapter(myFragmentPagerAdapter);
            viewPager.setAdapter(myFragmentPagerTabAdapter);
//            viewPager.set
//            viewPager2用的是registerOnPageChangeCallBack
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    changePage(position);

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            /*viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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

             */
//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.main_menu_home:
//                            viewPager.setCurrentItem(0);
//                            break;
//                        case R.id.main_menu_shopping:
//                            viewPager.setCurrentItem(1);
//                            break;
//                        case R.id.main_menu_message:
//                            viewPager.setCurrentItem(2);
//                            break;
//                        case R.id.main_menu_mine:
//                            viewPager.setCurrentItem(3);
//                            break;
//
//                    }
//                    return true;
//                }
//            });

//            bottomNavigationView.getOrCreateBadge(R.id.main_menu_message);
        }
    }


    private void changePage(int position) {
        tab_last.setSelected(false);

        tab_current = tab_list.get(position);
//            switch (position) {
//                case 0:
//                    tab_one.setSelected(true);
//                    bottomNavigationView.setSelectedItemId(R.id.main_menu_home);
//                    break;
//                case 1:
//                    tab_one.setSelected(true);
//                    bottomNavigationView.setSelectedItemId(R.id.main_menu_shopping);
//                    break;
//                case 2:
//                    tab_one.setSelected(true);
//
//                    bottomNavigationView.setSelectedItemId(R.id.main_menu_message);
//                    break;
//                case 3:
//                    bottomNavigationView.setSelectedItemId(R.id.main_menu_mine);
//                    break;
//            }
        tab_current.setSelected(true);
        tab_last = tab_current;

    }

    private void intiView() {

        viewPager = findViewById(R.id.vp_main);
//        bottomNavigationView = findViewById(R.id.main_bt_navigation);

        initTabView();


    }

    private void initTabView() {
        tab_list = new ArrayList<>();

        tab_one = findViewById(R.id.ll_tab_one);
        tab_two = findViewById(R.id.ll_tab_two);
        tab_three = findViewById(R.id.ll_tab_three);
        tab_four = findViewById(R.id.ll_tab_four);
        tab_five = findViewById(R.id.ll_tab_five);

        //界面选定初始化
        tab_last = tab_one;
        tab_current = tab_one;
        tab_one.setSelected(true);

        tab_list.add(tab_one);
        tab_list.add(tab_two);
        tab_list.add(tab_four);
        tab_list.add(tab_five);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab_one:
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_tab_two:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_tab_three:

                break;
            case R.id.ll_tab_four:
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_tab_five:
                viewPager.setCurrentItem(3);

                break;
        }
    }
}
package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bugawayme.mainFragment.HomeFragment;
import com.example.bugawayme.mainFragment.MessageFragment;
import com.example.bugawayme.mainFragment.MineFragment;
import com.example.bugawayme.mainFragment.ShopFragment;
import com.example.bugawayme.myViewPager.BannerViewPager;
import com.example.bugawayme.myViewPager.CompatibleViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ViewPager viewPager;
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
            MyFragmentPagerTabAdapter myFragmentPagerTabAdapter = new MyFragmentPagerTabAdapter(getSupportFragmentManager(), list, null);

//            viewPager.setAdapter(myFragmentPagerAdapter);
            viewPager.setAdapter(myFragmentPagerTabAdapter);
//            viewPager.set
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
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.main_menu_home:
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.main_menu_shopping:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.main_menu_message:
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.main_menu_mine:
                            viewPager.setCurrentItem(3);
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
        viewPager = findViewById(R.id.vp_main);
        bottomNavigationView = findViewById(R.id.main_bt_navigation);

    }
}
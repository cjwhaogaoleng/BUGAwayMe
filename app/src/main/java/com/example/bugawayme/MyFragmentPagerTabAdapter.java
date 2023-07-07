package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyFragmentPagerTabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    private List<String> titles;

    public MyFragmentPagerTabAdapter(@NonNull FragmentManager fm,
                                     List<Fragment> fragmentList,
                                     List<String> titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles.get(position);
    }
}

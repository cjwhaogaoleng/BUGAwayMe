package com.example.bugawayme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentStateAdapter {

    List<Fragment> list;

    public MyFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle ,List<Fragment> list) {
        super(fragmentManager, lifecycle);
        this.list = list;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}

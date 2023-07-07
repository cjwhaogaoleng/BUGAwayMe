package com.example.bugawayme.mineInterface.settingAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bugawayme.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        FragmentManager FragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = FragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).add(R.id.fcv_setting, SettingFragment.class, null).commit();
    }
}
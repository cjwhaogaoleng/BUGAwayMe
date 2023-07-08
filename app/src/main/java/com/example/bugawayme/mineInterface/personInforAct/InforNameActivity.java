package com.example.bugawayme.mineInterface.personInforAct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.bugawayme.R;

public class InforNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_name);
    }

    public void back(View view) {
        finish();
    }
}
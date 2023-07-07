package com.example.bugawayme.mineInterface.personInforAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bugawayme.R;
import com.example.bugawayme.databinding.ActivityPersonInformationBinding;

public class PersonInformationActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityPersonInformationBinding apBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);

        apBind = DataBindingUtil.setContentView(this, R.layout.activity_person_information);
        apBind.setPersonInformationClick(this);


        initView();




    }

    private void initView() {

        //        apBind.etPerInforHeader.setEnabled(false);

        apBind.etPerInforHeader.setFocusable(false);
        apBind.etPerInforHeader.setCursorVisible(false);

        apBind.etPerInforName.setFocusable(false);
        apBind.etPerInforName.setCursorVisible(false);

        Drawable ic_return = getResources().getDrawable(R.drawable.returen);
//        Drawable ic_return2 = getResources().getDrawable(R.drawable.selector_bt);

        //第一个0是距左边距离，第二个0是距上边距离，40分别是长宽
        ic_return.setBounds(0, 0, 60, 60);
//        ic_return2.setBounds(0, 0, 60, 60);
        //只放左边
        apBind.etPerInforHeader.setCompoundDrawables(null, null, ic_return, null);
        apBind.etPerInforName.setCompoundDrawables(null, null, ic_return, null);


    }


    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_perInfor_header:
                Toast.makeText(this, "haahah", Toast.LENGTH_SHORT).show();
                break;

            case R.id.et_perInfor_name:
                startActivity(new Intent(this, InforNameActivity.class));

        }
    }
}
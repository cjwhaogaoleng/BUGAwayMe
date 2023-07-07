package com.example.bugawayme.mainFragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.bugawayme.MyRecycleViewMessageAdapter2;
import com.example.bugawayme.R;
import com.example.bugawayme.RecycleViewMessageData;
import com.example.bugawayme.databinding.FragmentMessageBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment implements  MyRecycleViewMessageAdapter2.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private FragmentMessageBinding messageBinding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    private List<RecycleViewMessageData> DataList;


    public MessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (messageBinding==null) {
//            rootView = inflater.inflate(R.layout.fragment_message, container, false);
            messageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        }
        initData();
//            rootView = inflater.inflate(R.layout.fragment_message, container, false);

        return messageBinding.getRoot();
//        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initData() {


    }

    private void initView(View view) {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_magnifier);
        drawable.setBounds(-40, 0, 10, 50);
        messageBinding.etMessageSearch.setCompoundDrawables(drawable, null, null, null);


        DataList = new ArrayList<>();
        DataList.add(new RecycleViewMessageData(R.color.color_grey_et_background, "蔡书翰",
                "你好啊", "2023-07-01", "1"));
        DataList.add(new RecycleViewMessageData(R.drawable.icon_ring,"系统消息",
                "畅易游版本更新","2023-05-19","1"));

        //时间排序
        Collections.sort(DataList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 1);
//        MyRecycleViewMessageAdapter viewMessageAdapter = new MyRecycleViewMessageAdapter(DataList, view.getContext());
        MyRecycleViewMessageAdapter2 viewMessageAdapter = new MyRecycleViewMessageAdapter2(DataList, view.getContext());
        messageBinding.rvMessage.setAdapter(viewMessageAdapter);
        messageBinding.rvMessage.setLayoutManager(gridLayoutManager);


        viewMessageAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "thanks", Toast.LENGTH_SHORT).show();
    }
}
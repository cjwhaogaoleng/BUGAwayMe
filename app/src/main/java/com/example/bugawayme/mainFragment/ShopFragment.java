package com.example.bugawayme.mainFragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bugawayme.MyRecycleViewShopAdapter;
import com.example.bugawayme.R;
import com.example.bugawayme.RecycleViewShopData;
import com.example.bugawayme.databinding.FragmentHomeBinding;
import com.example.bugawayme.databinding.FragmentShopBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {

    View rootView;
    FragmentShopBinding shopBinding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private List<RecycleViewShopData> dataList;
    private MyRecycleViewShopAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
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
        if (shopBinding == null) {
            shopBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);
        }
        return shopBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();

        Drawable drawable = getResources().getDrawable(R.drawable.ic_magnifier);
        drawable.setBounds(-40, 0, 10, 50);
        shopBinding.etShopSearch.setCompoundDrawables(drawable, null, null, null);


        adapter = new MyRecycleViewShopAdapter(dataList, view.getContext());

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        recyclerView.setAdapter(adapter);
    }


    private void initData() {
        dataList = new ArrayList<>();
        dataList.add(new RecycleViewShopData(R.drawable.background_et_grey, "冒险等级59，有刻晴等多位角色",
                "¥  666.0", "昵称1"));
        dataList.add(new RecycleViewShopData(R.drawable.background_et_grey, "冒险等级59，有刻晴等多位角色",
                "¥  666.0", "昵称1"));
        dataList.add(new RecycleViewShopData(R.drawable.background_et_grey, "冒险等级59，有刻晴等多位角色",
                "¥  666.0", "昵称1"));
        dataList.add(new RecycleViewShopData(R.drawable.background_et_grey, "冒险等级59，有刻晴等多位角色",
                "¥  666.0", "昵称1"));
    }

    private void initView(View v) {

        recyclerView = v.findViewById(R.id.rv_shop);
    }
}
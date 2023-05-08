package com.example.bugawayme.mainFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bugawayme.MyRecycleViewAdapter;
import com.example.bugawayme.R;
import com.example.bugawayme.data.RecycleViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment {

    private RecyclerView recyclerView1 ,recyclerView2, recyclerView3;
    View rootView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
        if (rootView==null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        recyclerView1 = view.findViewById(R.id.rv_mine1);
        recyclerView2 = view.findViewById(R.id.rv_mine2);
        recyclerView3 = view.findViewById(R.id.rv_mine3);

        initRecycleView();

    }

    private void initRecycleView() {
        List<RecycleViewData> viewDataList = new ArrayList<>();
        viewDataList.add(new RecycleViewData(R.drawable.good_1, "出售商品"));
        viewDataList.add(new RecycleViewData(R.drawable.orderlist, "已完成订单"));
        viewDataList.add(new RecycleViewData(R.drawable.label, "买家的出价"));

        List<RecycleViewData> viewDataList2 = new ArrayList<>();
        viewDataList2.add(new RecycleViewData(R.drawable.goods, "已购买订单"));
        viewDataList2.add(new RecycleViewData(R.drawable.collect, "收藏订单"));
        viewDataList2.add(new RecycleViewData(R.drawable.order, "出价订单"));

        List<RecycleViewData> viewDataList3 = new ArrayList<>();
        viewDataList3.add(new RecycleViewData(R.drawable.wallet, "钱包"));
        viewDataList3.add(new RecycleViewData(0, "客服"));
        viewDataList3.add(new RecycleViewData(0, "举报"));
        viewDataList3.add(new RecycleViewData(0, "管理员"));
        viewDataList3.add(new RecycleViewData(0, "设置"));



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getContext(), 4);



        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(viewDataList, getContext());
        MyRecycleViewAdapter myRecycleViewAdapter2 = new MyRecycleViewAdapter(viewDataList2, getContext());
        MyRecycleViewAdapter myRecycleViewAdapter3 = new MyRecycleViewAdapter(viewDataList3, getContext());


        recyclerView1.setAdapter(myRecycleViewAdapter);
        recyclerView1.setLayoutManager(gridLayoutManager);

        recyclerView2.setAdapter(myRecycleViewAdapter2);
        recyclerView2.setLayoutManager(gridLayoutManager2);

        recyclerView3.setAdapter(myRecycleViewAdapter3);
        recyclerView3.setLayoutManager(gridLayoutManager3);
    }
}
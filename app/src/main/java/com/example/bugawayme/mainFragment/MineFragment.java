package com.example.bugawayme.mainFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bugawayme.MyRecycleViewAdapter;
import com.example.bugawayme.R;
import com.example.bugawayme.RecycleViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment {

    private RecyclerView recyclerView0, recyclerView1 ,recyclerView2, recyclerView3;
    private ImageView iv_write;
    private View rootView;

    private MyRecycleViewAdapter myRecycleViewAdapter0,myRecycleViewAdapter1,myRecycleViewAdapter2
            , myRecycleViewAdapter3;


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
        initEvent();

    }


    private void initEvent() {
        myRecycleViewAdapter0.setOnItemClickListener(new MyRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "haole ", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        break;
                }
            }
        });

        myRecycleViewAdapter1.setOnItemClickListener(new MyRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), ""+position, Toast.LENGTH_SHORT).show();
            }
        });

        myRecycleViewAdapter2.setOnItemClickListener(new MyRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), ""+position, Toast.LENGTH_SHORT).show();

            }
        });

        myRecycleViewAdapter3.setOnItemClickListener(new MyRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        recyclerView0 = view.findViewById(R.id.rv_mine0);
        recyclerView1 = view.findViewById(R.id.rv_mine1);
        recyclerView2 = view.findViewById(R.id.rv_mine2);
        recyclerView3 = view.findViewById(R.id.rv_mine3);

        iv_write = view.findViewById(R.id.iv_mine_write);

        initRecycleView();

    }

    private void initRecycleView() {

        List<RecycleViewData> viewDataList0 = new ArrayList<>();
        viewDataList0.add(new RecycleViewData(R.drawable.collect, "收藏"));
        viewDataList0.add(new RecycleViewData(R.drawable.wallet, "钱包"));
        viewDataList0.add(new RecycleViewData(R.drawable.foot, "足迹"));
        viewDataList0.add(new RecycleViewData(R.drawable.after_service, "售后"));

        List<RecycleViewData> viewDataList1 = new ArrayList<>();
        viewDataList1.add(new RecycleViewData(R.drawable.good_1, "商品交易"));
        viewDataList1.add(new RecycleViewData(R.drawable.orderlist, "订单"));

        List<RecycleViewData> viewDataList2 = new ArrayList<>();
        viewDataList2.add(new RecycleViewData(R.drawable.goods, "商品交易"));
        viewDataList2.add(new RecycleViewData(R.drawable.order, "订单"));

        List<RecycleViewData> viewDataList3 = new ArrayList<>();
        viewDataList3.add(new RecycleViewData(R.drawable.setting, "设置"));
        viewDataList3.add(new RecycleViewData(R.drawable.earphone, "客服"));
        viewDataList3.add(new RecycleViewData(R.drawable.report, "举报"));
        viewDataList3.add(new RecycleViewData(R.drawable.administrator, "管理员"));



        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(getContext(), 4);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 4);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 4);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getContext(), 4);


        myRecycleViewAdapter0 = new MyRecycleViewAdapter(viewDataList0, getContext());
        myRecycleViewAdapter1 = new MyRecycleViewAdapter(viewDataList1, getContext());
        myRecycleViewAdapter2 = new MyRecycleViewAdapter(viewDataList2, getContext());
        myRecycleViewAdapter3 = new MyRecycleViewAdapter(viewDataList3, getContext());


        recyclerView0.setAdapter(myRecycleViewAdapter0);
        recyclerView0.setLayoutManager(gridLayoutManager0);

        recyclerView1.setAdapter(myRecycleViewAdapter1);
        recyclerView1.setLayoutManager(gridLayoutManager1);

        recyclerView2.setAdapter(myRecycleViewAdapter2);
        recyclerView2.setLayoutManager(gridLayoutManager2);

        recyclerView3.setAdapter(myRecycleViewAdapter3);
        recyclerView3.setLayoutManager(gridLayoutManager3);
    }



}
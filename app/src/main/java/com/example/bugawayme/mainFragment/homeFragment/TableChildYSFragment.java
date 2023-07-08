package com.example.bugawayme.mainFragment.homeFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bugawayme.MyRecycleViewCarouselAdapter;
import com.example.bugawayme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableChildYSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableChildYSFragment extends Fragment implements MyRecycleViewCarouselAdapter.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View root;

    private TextView tv;
    //recycleVIew的相关变量
    private RecyclerView recyclerView;
    private List<Integer> dataList;

    private MyRecycleViewCarouselAdapter carouselAdapter;


    private String mParam1;
    private String mParam2;

    public TableChildYSFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableChildYSFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableChildYSFragment newInstance(String param1, String param2) {
        TableChildYSFragment fragment = new TableChildYSFragment();
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
        // Inflate the layout for this fragment
        if (root==null) {
            root = inflater.inflate(R.layout.fragment_table_child_y_s, container, false);
        }
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView(view);
        initData();
        initEvent();

        carouselAdapter = new MyRecycleViewCarouselAdapter(dataList, null, view.getContext());
        recyclerView.setAdapter(carouselAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));
        carouselAdapter.setOnItemClickListener(this);

    }

    private void initEvent() {
    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.add(R.drawable.pic_yuanshen);
        dataList.add(R.drawable.pic_yuanshen);
        dataList.add(R.drawable.pic_yuanshen);
        dataList.add(R.drawable.pic_yuanshen);
    }

    private void initView(View view) {
        tv = view.findViewById(R.id.tv_home_tabLayout_f1);
        tv.setText(mParam1);
        recyclerView = view.findViewById(R.id.rv_home_child_y);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "tah"+""+position, Toast.LENGTH_SHORT).show();
    }
}
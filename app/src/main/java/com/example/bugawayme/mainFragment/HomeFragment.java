package com.example.bugawayme.mainFragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bugawayme.MyRecycleViewCarouselAdapter;
import com.example.bugawayme.MyRecycleViewMineBottomAdapter;
import com.example.bugawayme.MyRecycleViewMineHotGameAdapter;
import com.example.bugawayme.myViewPager.BannerViewPager;
import com.example.bugawayme.myViewPager.CompatibleViewPager;
import com.example.bugawayme.MyFragmentPagerTabAdapter;
import com.example.bugawayme.R;
import com.example.bugawayme.mainFragment.homeFragment.TableChildYSFragment;
import com.google.android.material.tabs.TabLayout;
import com.mig35.carousellayoutmanager.CarouselLayoutManager;
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.mig35.carousellayoutmanager.CenterScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View rootView;
    private ViewPager vp;
    private RecyclerView recyclerView , recyclerViewHotGame;
    private TabLayout tabLayout;

    private List<Fragment> fragmentList;
    private List<Integer> carouselList;
    private List<Integer> hotGameList;

    private List<Uri> carouselUriList;

    private MyFragmentPagerTabAdapter fragmentPagerTableAdapter;
    private MyRecycleViewCarouselAdapter carouselAdapter;
    private MyRecycleViewMineHotGameAdapter hotGameAdapter;


    private List<String> titles;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        initView(view);
        initData();

//        tab的初始化
        fragmentPagerTableAdapter = new MyFragmentPagerTabAdapter(getChildFragmentManager(), fragmentList, titles);
        vp.setAdapter(fragmentPagerTableAdapter);
        tabLayout.setupWithViewPager(vp);


//        自动滚轮的初始化
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
        carouselAdapter = new MyRecycleViewCarouselAdapter(carouselList, carouselUriList, view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        //固定大小
        recyclerView.setHasFixedSize(true);
        //缩放
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView.setAdapter(carouselAdapter);
        //中心滚动
        recyclerView.addOnScrollListener(new CenterScrollListener());


//hotGame的初始化
        hotGameAdapter = new MyRecycleViewMineHotGameAdapter(hotGameList, null, view.getContext());
        recyclerViewHotGame.setAdapter(hotGameAdapter);
        recyclerViewHotGame.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));


        carouselAdapter.setOnItemClickListener(new MyRecycleViewCarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(),
                        "i love", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData() {
        fragmentList = new ArrayList<>();
        TableChildYSFragment fragment1 = TableChildYSFragment.newInstance("原神", "");
        TableChildYSFragment fragment2 = TableChildYSFragment.newInstance("王者荣耀", "");
        TableChildYSFragment fragment3 = TableChildYSFragment.newInstance("绝地求生", "");
        TableChildYSFragment fragment4 = TableChildYSFragment.newInstance("穿越火线", "");
        TableChildYSFragment fragment5 = TableChildYSFragment.newInstance("地铁跑酷", "");

        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        fragmentList.add(fragment5);

        titles = new ArrayList<>();
        titles.add("原神");
        titles.add("王者荣耀");
        titles.add("绝地求生");
        titles.add("穿越火线");
        titles.add("地铁跑酷");


        carouselUriList = new ArrayList<>();

        String uri[] = {"https://www.figma.com/file/h3NsCnS96Ge64qHAGOQeX2/UI%E8%AE%BE%E8%AE%A1?type=design&node-id=222-305&mode=dev",
                "https://www.figma.com/file/h3NsCnS96Ge64qHAGOQeX2/UI%E8%AE%BE%E8%AE%A1?type=design&node-id=222-307&mode=dev",
                "https://www.figma.com/file/h3NsCnS96Ge64qHAGOQeX2/UI%E8%AE%BE%E8%AE%A1?type=design&node-id=222-306&mode=dev"};
        carouselUriList.add(Uri.parse(uri[0]));
        carouselUriList.add(Uri.parse(uri[1]));
        carouselUriList.add(Uri.parse(uri[2]));

        carouselList = new ArrayList<>();
        carouselList.add(R.drawable.pic_carousel1);
        carouselList.add(R.drawable.pic_carousel2);
        carouselList.add(R.drawable.pic_carousel3);


        hotGameList = new ArrayList<>();
        hotGameList.add(R.drawable.background_et_grey);
        hotGameList.add(R.drawable.background_et_grey);
        hotGameList.add(R.drawable.background_et_grey);
        hotGameList.add(R.drawable.background_et_grey);
        hotGameList.add(R.drawable.background_et_grey);
        hotGameList.add(R.drawable.background_et_grey);
    }

    private void initView(View v) {
        vp = v.findViewById(R.id.vp_home_tabLay);
        recyclerView = v.findViewById(R.id.rv_home_carousel);
        tabLayout = v.findViewById(R.id.tl_home);
        recyclerViewHotGame = v.findViewById(R.id.rv_home_hot_game);
    }
}
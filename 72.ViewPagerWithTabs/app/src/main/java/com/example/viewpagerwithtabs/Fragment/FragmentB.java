package com.example.viewpagerwithtabs.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpagerwithtabs.Adapter.ViewPagerAdapter;
import com.example.viewpagerwithtabs.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment {

    private RecyclerView mRecyclerView;
    private ViewPagerAdapter mAdapter;
    private List<String> placeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setAdapter();
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewFragB);
    }

    private void buildList() {
        placeList = new ArrayList<>();
        placeList.add("Delhi");
        placeList.add("Kerala");
        placeList.add("Karnataka");
        placeList.add("Banglore");
        placeList.add("Mumbai");
        placeList.add("Aurangabad");
        placeList.add("Goa");
        placeList.add("Nasirabad");
        placeList.add("Nashik");
        placeList.add("Nandeed");
        placeList.add("Hydrabad");
        placeList.add("Manali");
        placeList.add("Pune");
        placeList.add("Mysor");
        placeList.add("Jarkhand");
    }

    private void setAdapter() {
        mAdapter = new ViewPagerAdapter(placeList);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
/*
        placeList = new ArrayList<>();
        placeList.add("Delhi");
        placeList.add("Kerala");
        placeList.add("Karnataka");
        placeList.add("Banglore");
        placeList.add("Mumbai");
        placeList.add("Aurangabad");
        placeList.add("Goa");
        placeList.add("Nasirabad");
        placeList.add("Nashik");
        placeList.add("Nandeed");
        placeList.add("Hydrabad");
        placeList.add("Manali");
        placeList.add("Pune");
        placeList.add("Mysor");
        placeList.add("Jarkhand");
 */
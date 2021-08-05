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

public class FragmentC extends Fragment {
    private RecyclerView mRecyclerView;
    private ViewPagerAdapter mAdapter;
    private List<String> touristPlaceList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    public static FragmentC newInstance() {
        return new FragmentC();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setAdapter();
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewFragC);
    }

    private void buildList() {
        touristPlaceList = new ArrayList<>();
        touristPlaceList.add("Munnar");
        touristPlaceList.add("coalkers walk");
        touristPlaceList.add("love lake");
        touristPlaceList.add("abhey falls");
        touristPlaceList.add("Taj mahal");
        touristPlaceList.add("Ladakh");
        touristPlaceList.add("Mysore Palace");
        touristPlaceList.add("Amber Palace");
        touristPlaceList.add("Sri Hamandir");
        touristPlaceList.add("Red fort");
        touristPlaceList.add("Periyar National Part");
        touristPlaceList.add("Thekkady");
        touristPlaceList.add("Pune");
        touristPlaceList.add("Mysor");
        touristPlaceList.add("Qutab minar");
    }

    private void setAdapter() {
        mAdapter = new ViewPagerAdapter(touristPlaceList);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
/*
        touristPlaceList = new ArrayList<>();
        touristPlaceList.add("Delhi");
        touristPlaceList.add("Kerala");
        touristPlaceList.add("Karnataka");
        touristPlaceList.add("Banglore");
        touristPlaceList.add("Mumbai");
        touristPlaceList.add("Aurangabad");
        touristPlaceList.add("Goa");
        touristPlaceList.add("Nasirabad");
        touristPlaceList.add("Nashik");
        touristPlaceList.add("Nandeed");
        touristPlaceList.add("Hydrabad");
        touristPlaceList.add("Manali");
        touristPlaceList.add("Pune");
        touristPlaceList.add("Mysor");
        touristPlaceList.add("Jarkhand");
 */
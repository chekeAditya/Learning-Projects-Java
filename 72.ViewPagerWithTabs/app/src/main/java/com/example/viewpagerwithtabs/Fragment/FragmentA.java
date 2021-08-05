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

public class FragmentA extends Fragment {

    private RecyclerView mRecyclerView;
    private ViewPagerAdapter pagerAdapter;
    private List<String> nameModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setAdapter();
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewFragA);
    }

    private void buildList() {
        nameModelList = new ArrayList<>();
        nameModelList.add(("Ram"));
        nameModelList.add("Sita");
        nameModelList.add("Laxman");
        nameModelList.add("Karan");
        nameModelList.add("Shubhum");
        nameModelList.add("Ravi");
        nameModelList.add("Pawan");
        nameModelList.add("Aditya");
        nameModelList.add("Sudarshan");
        nameModelList.add("Rahul");
        nameModelList.add("Ishwar");
        nameModelList.add("Prachi");
        nameModelList.add("Arya");
        nameModelList.add("Elan");
        nameModelList.add("Edward");
        nameModelList.add("Jack");
    }

    private void setAdapter() {
        pagerAdapter = new ViewPagerAdapter(nameModelList);
        mRecyclerView.setAdapter(pagerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
/*
 nameModelList = new ArrayList<>();
        nameModelList.add(("Ram"));
        nameModelList.add("Sita");
        nameModelList.add("Laxman");
        nameModelList.add("Karan");
        nameModelList.add("Shubhum");
        nameModelList.add("Ravi");
        nameModelList.add("Pawan");
        nameModelList.add("Aditya");
        nameModelList.add("Sudarshan");
        nameModelList.add("Rahul");
        nameModelList.add("Ishwar");
        nameModelList.add("Prachi");
        nameModelList.add("Arya");
        nameModelList.add("Elan");
        nameModelList.add("Edward");
        nameModelList.add("Jack");
 */
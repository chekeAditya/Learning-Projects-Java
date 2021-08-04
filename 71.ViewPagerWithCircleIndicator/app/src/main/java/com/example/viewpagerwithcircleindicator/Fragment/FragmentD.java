package com.example.viewpagerwithcircleindicator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagerwithcircleindicator.R;


public class FragmentD extends Fragment {


    private static final String HeadingD = "Heading";
    private static final String TextD = "Text";
    private String mHeadingD;
    private String mTextD;
    private TextView mTvHeadingFragD;
    private TextView mTvTextFragD;

    public FragmentD() {
        //required Empty constructor
    }

    public static FragmentD newInstance(String heading,String text) {
        FragmentD fragment = new FragmentD();
        Bundle args = new Bundle();
        args.putString(HeadingD, heading);
        args.putString(TextD, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeadingD = getArguments().getString(HeadingD);
            mTextD = getArguments().getString(TextD);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViwes(view);
        setData();
    }

    private void setData() {
        mTvHeadingFragD.setText(mHeadingD);
        mTvTextFragD.setText(mTextD);
    }

    private void initViwes(View view) {
        mTvHeadingFragD = view.findViewById(R.id.tvHeadingFragD);
        mTvTextFragD = view.findViewById(R.id.tvTextFragD);
    }
}
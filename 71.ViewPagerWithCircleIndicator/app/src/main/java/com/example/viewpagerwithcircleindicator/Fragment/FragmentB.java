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

public class FragmentB extends Fragment {

    private static final String HeadingB = "Heading";
    private static final String TextB = "Text";
    private String mHeadingB;
    private String mTextB;
    private TextView mTvHeadingFragB;
    private TextView mTvTextFragB;

    public FragmentB() {
        //required Empty constructor
    }

    public static FragmentB newInstance(String heading,String text) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString(HeadingB, heading);
        args.putString(TextB, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeadingB = getArguments().getString(HeadingB);
            mTextB = getArguments().getString(TextB);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViwes(view);
        setData();
    }

    private void setData() {
        mTvHeadingFragB.setText(mHeadingB);
        mTvTextFragB.setText(mTextB);
    }

    private void initViwes(View view) {
        mTvHeadingFragB = view.findViewById(R.id.tvHeadingFragB);
        mTvTextFragB = view.findViewById(R.id.tvTextFragB);
    }
}
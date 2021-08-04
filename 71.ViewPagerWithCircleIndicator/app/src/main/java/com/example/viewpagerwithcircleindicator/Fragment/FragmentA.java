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


public class FragmentA extends Fragment {

    private static final String Heading = "Heading";
    private static final String Text = "Text";
    private String mHeading;
    private String mText;
    private TextView mTvHeadingFragA;
    private TextView mTvTextFragA;

    public FragmentA() {
        //required Empty constructor
    }

    public static FragmentA newInstance(String heading,String text) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(Heading, heading);
        args.putString(Text, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeading = getArguments().getString(Heading);
            mText = getArguments().getString(Text);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViwes(view);
        setData();
    }

    private void setData() {
        mTvHeadingFragA.setText(mHeading);
        mTvTextFragA.setText(mText);
    }

    private void initViwes(View view) {
        mTvHeadingFragA = view.findViewById(R.id.tvHeadingFragA);
        mTvTextFragA = view.findViewById(R.id.tvTextFragA);
    }
}
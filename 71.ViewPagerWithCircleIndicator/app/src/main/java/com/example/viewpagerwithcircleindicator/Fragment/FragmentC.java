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

public class FragmentC extends Fragment {

    private static final String HeadingC = "Heading";
    private static final String TextC = "Text";
    private String mHeadingC;
    private String mTextC;
    private TextView mTvHeadingFragC;
    private TextView mTvTextFragC;

    public FragmentC() {
        //required Empty constructor
    }

    public static FragmentC newInstance(String heading,String text) {
        FragmentC fragment = new FragmentC();
        Bundle args = new Bundle();
        args.putString(HeadingC, heading);
        args.putString(TextC, text);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeadingC = getArguments().getString(HeadingC);
            mTextC = getArguments().getString(TextC);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViwes(view);
        setData();
    }

    private void setData() {
        mTvHeadingFragC.setText(mHeadingC);
        mTvTextFragC.setText(mTextC);
    }

    private void initViwes(View view) {
        mTvHeadingFragC = view.findViewById(R.id.tvHeadingFragC);
        mTvTextFragC = view.findViewById(R.id.tvTextFragC);
    }
}
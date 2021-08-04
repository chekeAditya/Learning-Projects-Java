package com.example.viewpager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    private EditText mEtName;
    private Button mBtnSend;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    //you can typecast only when two things are compatible
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    private void initView(View view) {
        mEtName = view.findViewById(R.id.etName);
        mBtnSend = view.findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(v -> {
            String name = mEtName.getText().toString();
            if (mainActivity != null) {
                mainActivity.setName(name);
            }
        });
    }
}
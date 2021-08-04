package com.example.totalapplecount;

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
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {

    private EditText mEtAppleAvailable;
    private TextView mTvAppleAvailablePreview;
    private Button mBtnBuyApple;
    private CommunicationListener communicationListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtAppleAvailable = view.findViewById(R.id.etAppleAvailable);
        mTvAppleAvailablePreview = view.findViewById(R.id.tvAppleAvailablePreview);
        mBtnBuyApple = view.findViewById(R.id.btnButApple);
        mBtnBuyApple.setOnClickListener(v -> {
            int appleQuantity = Integer.parseInt(mEtAppleAvailable.getText().toString());
            Bundle bundle = new Bundle();
            bundle.putInt("appleQuantity", appleQuantity);
            if (communicationListener != null) {
                communicationListener.launchBuyAppleFragment(bundle);
            }
        });
    }
}
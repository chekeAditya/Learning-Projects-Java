package com.example.totalapplecount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class BuyAppleFragment extends Fragment {

    private EditText mEtEnterQuantityAppleBuy;
    private CommunicationListener communicationListener;
    private int appleQuantityWritten;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            appleQuantityWritten = getArguments().getInt("appleCount");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apple, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEtEnterQuantityAppleBuy = view.findViewById(R.id.etEnterQuantityAppleBuy);
    }

    @Override
    public void onPause() {
        super.onPause();
        int buy = Integer.parseInt(mEtEnterQuantityAppleBuy.getText().toString());
        if (buy <= appleQuantityWritten) {
            int remains = appleQuantityWritten - buy;
            Bundle bundle = new Bundle();
            bundle.putInt("remains", remains);
            communicationListener.launchTotalAppleFragment(bundle);
        }else {
            int remains = appleQuantityWritten;
            Bundle bundle = new Bundle();
            bundle.putInt("remains", remains);
            communicationListener.launchTotalAppleFragment(bundle);
            Toast.makeText(getContext(),"Apple not Available",Toast.LENGTH_SHORT).show();
        }
    }
}
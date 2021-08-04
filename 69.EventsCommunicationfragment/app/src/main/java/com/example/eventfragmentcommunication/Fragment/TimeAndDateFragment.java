package com.example.eventfragmentcommunication.Fragment;

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

import com.example.eventfragmentcommunication.CommunicationListener;
import com.example.eventfragmentcommunication.R;

public class TimeAndDateFragment extends Fragment {

    private EditText mEtEventStartDate, mEtEventEndDate, mEtEventStartTime, mEtEventEndTime;
    private Button mBtnNextTimeDateFragment;
    private String eventTitle;
    private String eventDesc;
    private CommunicationListener communicationListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventTitle = getArguments().getString("eventTitle");
            eventDesc = getArguments().getString("eventDesc");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
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
        mEtEventStartDate = view.findViewById(R.id.etEventStartDate);
        mEtEventEndDate = view.findViewById(R.id.etEventEndDate);
        mEtEventStartTime = view.findViewById(R.id.etEventStartTime);
        mEtEventEndTime = view.findViewById(R.id.etEventEndTime);
        mBtnNextTimeDateFragment = view.findViewById(R.id.btnNextTimeDateFragment);
        mBtnNextTimeDateFragment.setOnClickListener(v -> {
            String eventStartDate = mEtEventStartDate.getText().toString();
            String eventEndDate = mEtEventEndDate.getText().toString();
            String eventStartTime = mEtEventStartTime.getText().toString();
            String eventEndTime = mEtEventEndTime.getText().toString();
            eventTitle = getArguments().getString("eventTitle");
            eventDesc = getArguments().getString("eventDesc");
            Bundle bundle = new Bundle();
            bundle.putString("eventTitle",eventTitle);
            bundle.putString("eventDesc",eventDesc);
            bundle.putString("eventStartTime", eventStartTime);
            bundle.putString("eventEndTime", eventEndTime);
            bundle.putString("eventEndDate", eventEndDate);
            bundle.putString("eventStartDate", eventStartDate);
            communicationListener.launchPriceDetailsFragment(bundle);
        });
    }
}
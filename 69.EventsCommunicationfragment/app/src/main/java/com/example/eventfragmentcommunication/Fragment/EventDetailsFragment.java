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

public class EventDetailsFragment extends Fragment {

    private EditText mEtEventTitle, mEtEventDescription;
    private Button mBtnNext;
    private CommunicationListener communicationListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
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
        mEtEventDescription = view.findViewById(R.id.etEventDescription);
        mEtEventTitle = view.findViewById(R.id.etEventTitle);
        mBtnNext = view.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(v -> {
            String eventTitle = mEtEventTitle.getText().toString();
            String eventDesc = mEtEventDescription.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("eventTitle", eventTitle);
            bundle.putString("eventDesc", eventDesc);
            if (communicationListener != null) {
                communicationListener.launchTimeAndDateFragment(bundle);
            }
        });
    }
}
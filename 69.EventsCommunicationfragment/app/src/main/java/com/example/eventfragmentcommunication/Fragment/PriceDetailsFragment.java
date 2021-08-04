package com.example.eventfragmentcommunication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.eventfragmentcommunication.Activity.PreviewActivity;
import com.example.eventfragmentcommunication.Model.EventModel;
import com.example.eventfragmentcommunication.R;

public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency, mEtPrice;
    private Button mBtnPreview;
    private String eventTitle;
    private String eventDesc;
    private String eventStartTime;
    private String eventEndTime;
    private String eventEndDate;
    private String eventStartDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventTitle = getArguments().getString("eventTitle");
            eventDesc = getArguments().getString("eventDesc");
            eventStartTime = getArguments().getString("eventStartTime");
            eventEndTime = getArguments().getString("eventEndTime");
            eventEndDate = getArguments().getString("eventEndDate");
            eventStartDate = getArguments().getString("eventStartDate");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtPrice = view.findViewById(R.id.etPrice);
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mBtnPreview = view.findViewById(R.id.btnPreview);
        mBtnPreview.setOnClickListener(v -> {
            String price = mEtPrice.getText().toString();
            EventModel eventModel = new EventModel(eventTitle, eventDesc, eventStartDate, eventEndDate, eventStartTime, eventEndTime, price);
//            Bundle bundle = new Bundle();
//            bundle.putString("eventTitle",eventTitle);
//            bundle.putString("eventDesc",eventDesc);
//            bundle.putString("eventStartTime",eventStartTime);
//            bundle.putString("eventEndTime",eventEndTime);
//            bundle.putString("eventEndDate",eventEndDate);
//            bundle.putString("eventStartDate",eventStartDate);
//            bundle.putString("price",price);
            Intent intent = new Intent(getActivity(), PreviewActivity.class);
            intent.putExtra("eventModel", eventModel);
            startActivity(intent);
        });
    }
}
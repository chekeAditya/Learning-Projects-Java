package com.example.eventfragmentcommunication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.eventfragmentcommunication.Model.EventModel;
import com.example.eventfragmentcommunication.R;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvEventTitle, mTvEventDesc, mTvEventStartDate, mTvEventEndDate, mTvEventStartTime, mTvEventEndTime, mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        EventModel eventModel = (EventModel) getIntent().getSerializableExtra("eventModel");
        mTvEventTitle.setText(eventModel.getEventTitle());
        mTvEventDesc.setText(eventModel.getEvenDesc());
        mTvEventStartDate.setText(eventModel.getEventStartDate());
        mTvEventEndDate.setText(eventModel.getEventEndDate());
        mTvEventStartTime.setText(eventModel.getEventStartTime());
        mTvEventEndTime.setText(eventModel.getEventEndTime());
        mTvPrice.setText(eventModel.getPrice());

//        Bundle bundle = getIntent().getBundleExtra("eventModel");
//        mTvEventTitle.setText(bundle.getString("eventTitle"));
//        mTvEventDesc.setText(bundle.getString("eventDesc"));
//        mTvEventStartDate.setText(bundle.getString("eventStartDate"));
//        mEtEventEndDate.setText(bundle.getString("eventEndDate"));
//        mEtEventStartTime.setText(bundle.getString("eventStartTime"));
//        mEtEventEndTime.setText(bundle.getString("eventEndTime"));
//        mEtPrice.setText(bundle.getString("price"));
    }

    private void initViews() {
        mTvEventTitle = findViewById(R.id.tvEventTitle);
        mTvEventDesc = findViewById(R.id.tvEventDesc);
        mTvEventStartDate = findViewById(R.id.tvEventStartDate);
        mTvEventEndDate = findViewById(R.id.tvEventEndDate);
        mTvEventStartTime = findViewById(R.id.tvStartTime);
        mTvEventEndTime = findViewById(R.id.tvEndTime);
        mTvPrice = findViewById(R.id.tvPrice);
    }
}
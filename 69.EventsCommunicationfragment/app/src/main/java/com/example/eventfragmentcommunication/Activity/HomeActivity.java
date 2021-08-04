package com.example.eventfragmentcommunication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.eventfragmentcommunication.CommunicationListener;
import com.example.eventfragmentcommunication.Fragment.EventDetailsFragment;
import com.example.eventfragmentcommunication.Fragment.PriceDetailsFragment;
import com.example.eventfragmentcommunication.Fragment.TimeAndDateFragment;
import com.example.eventfragmentcommunication.R;

public class HomeActivity extends AppCompatActivity implements CommunicationListener {

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchEventDetailsFragment();
    }

    private void launchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.flContainer, fragment, "evenDetailsFragment").commit();
    }


    @Override
    public void launchTimeAndDateFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.flContainer, timeAndDateFragment, "timeAndDateFragment").addToBackStack("").commit();
    }

    @Override
    public void launchPriceDetailsFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.flContainer,priceDetailsFragment,"priceDetailsFragment").addToBackStack("").commit();
    }
}
package com.example.totalapplecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchTotalAppleFragment();
    }

    private void launchTotalAppleFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.flContainer, totalApplesFragment, "totalApplesFragment").addToBackStack("totalApplesFragment").commit();
    }

    @Override
    public void launchTotalAppleFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        totalApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flContainer, totalApplesFragment, "totalApplesFragment").addToBackStack("totalApplesFragment").commit();
    }

    @Override
    public void launchBuyAppleFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BuyAppleFragment buyAppleFragment = new BuyAppleFragment();
        buyAppleFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flContainer, buyAppleFragment, "buyAppleFragment").addToBackStack("buyAppleFragment").commit();
    }
}
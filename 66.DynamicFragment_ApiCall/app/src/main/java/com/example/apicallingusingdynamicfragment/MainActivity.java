package com.example.apicallingusingdynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout flContainer;
    FragmentManager fragmentManager;
    RelativeLayout mllLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void replace() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flcontainer, fragmentA, "FragmentA").commit();
    }

    private void initViews() {
        flContainer = findViewById(R.id.flcontainer);
        mllLayout = findViewById(R.id.llLayout);
        mllLayout.setOnClickListener(v -> replace());
        fragmentManager = getSupportFragmentManager();
    }
}
package com.example.viewpagerwithtabs.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.viewpagerwithtabs.Adapter.FragmentAdapter;
import com.example.viewpagerwithtabs.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setViewPagerAdapter();
    }

    private void initViews() {
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
    }

    private void setViewPagerAdapter() {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(fragmentAdapter);
        new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Names");
                    break;
                case 1:
                    tab.setText("Places");
                    break;
                case 2:
                    tab.setText("Tourist places");
            }
        }).attach();
    }
}
package com.example.viewpagerwithtabs.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagerwithtabs.Fragment.FragmentA;
import com.example.viewpagerwithtabs.Fragment.FragmentB;
import com.example.viewpagerwithtabs.Fragment.FragmentC;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragmentA.newInstance();
            case 1:
                return FragmentB.newInstance();
            case 2:
                return FragmentC.newInstance();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

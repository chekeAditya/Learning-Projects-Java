package com.example.viewpagerwithcircleindicator.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpagerwithcircleindicator.Fragment.FragmentA;
import com.example.viewpagerwithcircleindicator.Fragment.FragmentB;
import com.example.viewpagerwithcircleindicator.Fragment.FragmentC;
import com.example.viewpagerwithcircleindicator.Fragment.FragmentD;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            return FragmentA.newInstance("Write on the go","Get stuff done with or without an internet connection.");
            case 1:
                return FragmentB.newInstance("Share and edit together","Write on you own or invite more people to contribute.");
            case 2:
                return FragmentC.newInstance("Automatically save to the web","Never lose your progress, so you can keep working from any computer or device.");
            case 3:
                return FragmentD.newInstance("Edit World Documents","Open, edit and save Word files -all within Docs.");
        }
        return FragmentA.newInstance("","");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

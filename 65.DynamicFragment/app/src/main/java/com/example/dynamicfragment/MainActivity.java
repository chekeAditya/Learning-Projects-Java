package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAddA;
    private Button mBtnAddB;
    private Button mBtnRemoveA;
    private Button mBtnRemoveB;
    private Button mBtnReplaceAWithBWithBackStack;
    private Button mBtnReplaceAWithBWithoutBackStack;
    private Button mbtnReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAWithBWithBackStack = findViewById(R.id.btnReplaceAWithBWithBackStack);
        mBtnReplaceAWithBWithoutBackStack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mbtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        fragmentManager = getSupportFragmentManager();
        mBtnAddA.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceAWithBWithBackStack.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackStack.setOnClickListener(this);
        mbtnReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceAWithBWithBackStack:
                replaceAWithBackStack();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAwithBWithoutBackstack();
                break;
            case R.id.btnReplaceBWithA:
                ReplaceBWithA();
                break;
        }
    }

    private void replaceAWithBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer, fragmentA, "FragmentA").addToBackStack("fragB").commit();
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FragmentB");
        if (fragmentB != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }
    }

    private void replaceAwithBWithoutBackstack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "FragmentB").commit();
    }

    private void ReplaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer, fragmentB, "FragmentB").commit();
    }
}
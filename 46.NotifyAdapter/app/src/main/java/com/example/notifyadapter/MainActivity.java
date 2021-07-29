package com.example.notifyadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Employee> employeesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEtCardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        builList();
        setRecyclerViews();
    }

    private void setRecyclerViews() {
        employeeAdapter = new EmployeeAdapter(employeesList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    private void builList() {
        Employee employee = new Employee("Aditya Cheke", 100000, 20);
        employeesList.add(employee);
        Employee employee1 = new Employee("Karan Deshmush", 15000, 31);
        employeesList.add(employee1);
        Employee employee2 = new Employee("Llyod Dcosta", 250000, 28);
        employeesList.add(employee2);
        Employee employee3 = new Employee("Sai Korukanti", 85000, 23);
        employeesList.add(employee3);
        Employee employee4 = new Employee("Sid kaushik", 80000, 21);
        employeesList.add(employee4);


    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mEtCardView = findViewById(R.id.editCardView);
        mEtName = findViewById(R.id.etName);
        mEtAddress = findViewById(R.id.etAddress);
        mEtAge = findViewById(R.id.etAge);
        mBtnDone = findViewById(R.id.btnDone);
    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mEtCardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getSalary() + "");
        mEtAddress.setText(employee.getAge() + "");


        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtCardView.setVisibility(View.GONE);

                Employee new_employee = new Employee(mEtName.getText().toString(), Integer.parseInt(mEtAge.getText().toString())
                        , Integer.parseInt(mEtAge.getText().toString()));//edited details
                employeesList.set(position, new_employee);

//                employeesList.remove(employee); //this is for deleting
                employeeAdapter.notifyItemChanged(position);
//                employeeAdapter.notifyDataSetChanged(position);
            }
        });
    }
}
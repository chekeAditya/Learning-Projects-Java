package com.example.cardview;

import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;
    ArrayList<Billionaire> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        BillionaireAdapter adapter = new BillionaireAdapter(arrayList, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildList() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                arrayList.add(new Billionaire(R.drawable.billgate, "Microsoft", "Age : 64", "Profession"));
            } else if (i % 4 == 0) {
                arrayList.add(new Billionaire(R.drawable.jeffbezos, "Amazon", "Age : 58", "Profession"));
            } else
                arrayList.add(new Billionaire(R.drawable.prateek, "Masai School", "Age : 32", "Profession"));
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(Billionaire billionaire) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("")
                .setMessage(
                        billionaire.getHeading() + "\n" +
                                billionaire.getAge()
                ).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
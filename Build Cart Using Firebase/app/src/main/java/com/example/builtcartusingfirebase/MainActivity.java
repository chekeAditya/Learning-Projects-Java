package com.example.builtcartusingfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.builtcartusingfirebase.adapter.MyDrinkAdapter;
import com.example.builtcartusingfirebase.listener.ICartLoadListener;
import com.example.builtcartusingfirebase.listener.IDrinkLoadListener;
import com.example.builtcartusingfirebase.model.CartModel;
import com.example.builtcartusingfirebase.model.DrinkModel;
import com.example.builtcartusingfirebase.utils.SpaceItemDecoration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IDrinkLoadListener, ICartLoadListener {

    RecyclerView recycler_drink;

    RelativeLayout mainLayout;

    NotificationBadge badge;

    List<DrinkModel> drinkModelsList;
    FrameLayout btnCart;

    IDrinkLoadListener drinkLoadListener;
    ICartLoadListener cartLoadListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadDrinkFromFirebase();
    }

    private void loadDrinkFromFirebase() {
        drinkModelsList = new ArrayList<>();
        FirebaseDatabase.getInstance()
                .getReference("Drink")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot drinkSnapShot : snapshot.getChildren()) {
                                DrinkModel drinkModel = drinkSnapShot.getValue(DrinkModel.class);
                                drinkModel.setKey(drinkSnapShot.getKey());
                                drinkModelsList.add(drinkModel);
                            }
                            drinkLoadListener.onDrinkLoadSuccess(drinkModelsList);
                        } else
                            drinkLoadListener.onDrinkLoadFailed("Can't find Drink");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        drinkLoadListener.onDrinkLoadFailed(error.getMessage());
                    }
                });
    }

    private void initViews() {
        recycler_drink = findViewById(R.id.recycler_drink);
        ButterKnife.bind(this);
        drinkLoadListener = this;
        cartLoadListener = this;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycler_drink.setLayoutManager(gridLayoutManager);
        recycler_drink.addItemDecoration(new SpaceItemDecoration());

    }

    @Override
    public void onDrinkLoadSuccess(List<DrinkModel> drinkModelList) {
        MyDrinkAdapter adapter = new MyDrinkAdapter(this, drinkModelList, this);
        recycler_drink.setAdapter(adapter);
    }

//    @Override
//    public void onDrinkClicked(int position) {
//        Map<String, Object> hashMap = new HashMap<>();
//        hashMap.put("cart",true);
//        FirebaseDatabase.getInstance().getReference("Drink")
//                .child(drinkModelsList.get(position).getKey()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this,"Added",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

    @Override
    public void onDrinkLoadFailed(String message) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {

    }

    @Override
    public void onCartLoadFailed(String message) {

    }
}
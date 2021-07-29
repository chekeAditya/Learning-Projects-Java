package com.example.builtcartusingfirebase.listener;

import com.example.builtcartusingfirebase.model.DrinkModel;

import java.util.List;

public interface IDrinkLoadListener {
    void onDrinkLoadSuccess(List<DrinkModel> drinkModelList);
    void onDrinkClicked(int position);
    void onDrinkLoadFailed(String message);
}

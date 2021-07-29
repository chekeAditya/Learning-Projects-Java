package com.example.builtcartusingfirebase.listener;

import com.example.builtcartusingfirebase.model.CartModel;

import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);
}

package com.example.builtcartusingfirebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.builtcartusingfirebase.R;
import com.example.builtcartusingfirebase.listener.IDrinkLoadListener;
import com.example.builtcartusingfirebase.model.DrinkModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyDrinkAdapter extends RecyclerView.Adapter<MyDrinkAdapter.MyDrinkViewHolder> {

    private Context context;
    private List<DrinkModel> drinkModelsList;
    private IDrinkLoadListener iDrinkLoadListener;

    public MyDrinkAdapter(Context context, List<DrinkModel> drinkModelsList, IDrinkLoadListener iDrinkLoadListener) {
        this.context = context;
        this.drinkModelsList = drinkModelsList;
        this.iDrinkLoadListener = iDrinkLoadListener;
    }

    @NonNull
    @Override
    public MyDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyDrinkViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.layout_drink_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyDrinkViewHolder holder, int position) {
        Glide.with(context)
                .load(drinkModelsList.get(position).getImage())
                .into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder("$").append(drinkModelsList.get(position).getPrice()));
        holder.txtName.setText(new StringBuilder().append(drinkModelsList.get(position).getName()));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iDrinkLoadListener.onDrinkClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkModelsList.size();
    }

    public class MyDrinkViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;

        private Unbinder unbinder;
        public MyDrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
        }
    }
}

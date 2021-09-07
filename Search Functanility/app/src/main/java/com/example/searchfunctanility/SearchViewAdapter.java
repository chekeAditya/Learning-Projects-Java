package com.example.searchfunctanility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchViewAdapter extends RecyclerView.Adapter<SearchViewAdapter.RecyclerviewHolder> {

    Context context;
    List<DataModel> userDataList;
    List<DataModel> filteredUserDataList;

    public SearchViewAdapter(Context context, List<DataModel> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
        this.filteredUserDataList = userDataList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new RecyclerviewHolder(view);
    }


    //ViewHolder
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, final int position) {
        holder.mTvName.setText(filteredUserDataList.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return filteredUserDataList.size();
    }
    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView mTvName;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
        }
    }

    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredUserDataList = userDataList;
                }
                else{

                    List<DataModel> lstFiltered = new ArrayList<>();
                    for(DataModel row: userDataList){
                        if(row.getName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }
                    }

                    filteredUserDataList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUserDataList = (List<DataModel>)filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
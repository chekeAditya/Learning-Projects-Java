package com.example.articlescrollingrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private ArrayList<Article> articleList;
    private ItemClickListener itemClickListener;

    public ArticleAdapter(ArrayList<Article> articleArrayList, ItemClickListener itemClickListener) {
        articleList = articleArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new ArticleViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.setData(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}

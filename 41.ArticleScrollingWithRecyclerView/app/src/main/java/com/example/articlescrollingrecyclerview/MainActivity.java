package com.example.articlescrollingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView mRecyclerView;
    private ArrayList<Article> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildArticleList();
        serRecyclerView();

    }

    private void serRecyclerView() {
        ArticleAdapter articleAdapter = new ArticleAdapter(arrayList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(articleAdapter);
    }

    private void buildArticleList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Article(R.drawable.ocean,"Blue Ocean","Waves Crash","See the Beautiful oceans of the Pacific coast where the water is so clean you can see the sand.","Aditya"));
        arrayList.add(new Article(R.drawable.oceantwo,"White Ocean","Wave Crash","The ocean is this beautiful, unexplored place. Why on Earth everyone isn't down there, I don't know.","Prachi"));
        arrayList.add(new Article(R.drawable.oceanthree,"Black Ocean","Wave Crash","The beauty and mystery of the ocean, fills our lives with wonders, vast beyond our imagination.","Sudarshan"));
        arrayList.add(new Article(R.drawable.oceanfour,"Pacific Ocean","Wave Crash","The human desire to obtain more is a sieve that can never be filled with all the water from the world’s oceans.","Shubhum"));
        arrayList.add(new Article(R.drawable.oceanfive,"Green Ocean","Wave Crash","If everybody had an ocean … everybody’d be surfing … Johnny Manetta and 4 more, Looking For Something to Find","Arya"));
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(int position, Article article) {
        Toast.makeText(MainActivity.this,"Author name is " + article.getmTvAuthorName(),Toast.LENGTH_SHORT).show();
    }
}
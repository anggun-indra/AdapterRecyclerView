package com.ahmadrosid.adapterrecyclerview;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ahmadrosid.adapterrecyclerview.adapter.RvAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> data;
    private RvAdapter<String, ItemViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("Lorem ipsum dolor amet!");
        }

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RvAdapter<String, ItemViewHolder>(R.layout.item_view_holder, ItemViewHolder.class, String.class, data) {
            @Override
            protected void bindView(ItemViewHolder holder, String model, final int position) {
                holder.bind(model);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "You clicked on position" + String.valueOf(position), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);

    }

}

package com.example.fetchlistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchlistapp.adapter.ItemAdapter;
import com.example.fetchlistapp.model.Item;
import com.example.fetchlistapp.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ItemViewModel viewModel;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        viewModel.getGroupedItems().observe(this, groupedMap -> {
            List<Item> allItems = new ArrayList<>();
            if (groupedMap != null) {
                for (Map.Entry<Integer, List<Item>> entry : groupedMap.entrySet()) {
                    allItems.addAll(entry.getValue());
                }
            }
            adapter.setData(allItems);
        });

        viewModel.loadItems();
    }
}

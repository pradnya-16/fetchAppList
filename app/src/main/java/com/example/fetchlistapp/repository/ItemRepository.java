package com.example.fetchlistapp.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.fetchlistapp.api.ApiService;
import com.example.fetchlistapp.api.RetrofitClient;
import com.example.fetchlistapp.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemRepository {

    public void fetchItems(MutableLiveData<Map<Integer, List<Item>>> liveData) {
        ApiService service = RetrofitClient.getClient().create(ApiService.class);

        service.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Item> filtered = new ArrayList<>();
                    for (Item item : response.body()) {
                        if (item.name != null && !item.name.trim().isEmpty()) {
                            filtered.add(item);
                        }
                    }

                    Collections.sort(filtered, Comparator
                            .comparingInt((Item i) -> i.listId)
                            .thenComparing(i -> i.name));

                    Map<Integer, List<Item>> grouped = new LinkedHashMap<>();
                    for (Item item : filtered) {
                        grouped.computeIfAbsent(item.listId, k -> new ArrayList<>()).add(item);
                    }

                    liveData.postValue(grouped);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                liveData.postValue(null);
            }
        });
    }
}

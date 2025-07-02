package com.example.fetchlistapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fetchlistapp.model.Item;
import com.example.fetchlistapp.repository.ItemRepository;

import java.util.List;
import java.util.Map;

public class ItemViewModel extends ViewModel {

    private final MutableLiveData<Map<Integer, List<Item>>> groupedItems = new MutableLiveData<>();
    private final ItemRepository repository = new ItemRepository();

    public LiveData<Map<Integer, List<Item>>> getGroupedItems() {
        return groupedItems;
    }

    public void loadItems() {
        repository.fetchItems(groupedItems);
    }
}

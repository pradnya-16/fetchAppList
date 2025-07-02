package com.example.fetchlistapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchlistapp.R;
import com.example.fetchlistapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private final List<Object> displayList = new ArrayList<>();

    public void setData(List<Item> itemsGrouped) {
        displayList.clear();
        int currentListId = -1;

        for (Item item : itemsGrouped) {
            if (item.listId != currentListId) {
                currentListId = item.listId;
                displayList.add("List ID: " + currentListId);
            }
            displayList.add(item);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return displayList.get(position) instanceof String ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerText.setText((String) displayList.get(position));
        } else {
            Item item = (Item) displayList.get(position);
            ((ItemViewHolder) holder).itemText.setText(item.name);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerText;
        HeaderViewHolder(View view) {
            super(view);
            headerText = view.findViewById(R.id.headerText);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemText;
        ImageView icon;
        ItemViewHolder(View view) {
            super(view);
            itemText = view.findViewById(R.id.itemText);
            icon = view.findViewById(R.id.iconView);
        }
    }
}


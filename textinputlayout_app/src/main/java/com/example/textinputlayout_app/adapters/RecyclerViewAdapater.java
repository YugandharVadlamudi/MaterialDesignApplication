package com.example.textinputlayout_app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.textinputlayout_app.R;

import java.util.List;

/**
 * Created by Kiran on 10-06-2016.
 */
public class RecyclerViewAdapater extends RecyclerView.Adapter {

    private final List<String> namesArray;
    private LayoutInflater layoutInflater;
    public RecyclerViewAdapater(Context context, List<String> namesArray) {
        this.namesArray = namesArray;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_rowitem, parent, false);
        return new RowItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RowItem rowItem = (RowItem) holder;
        rowItem.textView.setText(namesArray.get(position));
    }

    @Override
    public int getItemCount() {
        return namesArray.size();
    }

    class RowItem extends RecyclerView.ViewHolder {
        public TextView textView;
        public RowItem(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_layoutrowitem);
        }
    }
}

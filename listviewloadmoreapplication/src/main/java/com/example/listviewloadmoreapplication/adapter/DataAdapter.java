package com.example.listviewloadmoreapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.listviewloadmoreapplication.utils.UserData;

import java.util.List;

/**
 * Created by Kiran on 07-06-2016.
 */
public class DataAdapter extends RecyclerView.Adapter {
    private String TAG=DataAdapter.class.getSimpleName();
    private List<UserData>list;
    public DataAdapter(List<UserData> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: viewgrop->"+parent+"\n viewType->"+viewType );
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: ReccylerView->"+holder+"\n position->"+position );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserDataViewHolder extends RecyclerView.ViewHolder {

        public UserDataViewHolder(View itemView) {
            super(itemView);

        }

    }
}

package com.example.kiran.materialdesignapplication.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kiran.materialdesignapplication.R;

/**
 * Created by Kiran on 03-06-2016.
 */
public class RecycleViewAdater extends RecyclerView.Adapter <RecycleViewAdater.ViewHolderR> {
    private String[] nValues;
    public RecycleViewAdater(String[] nValues) {
        this.nValues = nValues;
    }

    @Override
    public ViewHolderR onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView v = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.row_textview, parent,false);
        TextView view = (TextView)v.findViewById(R.id.tv_row_item);
        ViewHolderR viewHolder = new ViewHolderR(v);
//        v.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderR holder, int position) {
        holder.textView.setText(nValues[position]);

    }

    @Override
    public int getItemCount() {
        return nValues.length;
    }

    class ViewHolderR extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolderR(CardView cardView) {
            super(cardView);
            this.textView = (TextView) cardView.findViewById(R.id.tv_row_item);
        }
    }
}

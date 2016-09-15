package com.example.recyclerviewfinalapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerviewfinalapp.R;
import com.example.recyclerviewfinalapp.interfaces.OnItemClickListener;
import com.example.recyclerviewfinalapp.utils.UserData;

import java.util.ArrayList;

/**
 * Created by Kiran on 07-06-2016.
 */
public class UserDataAdapter extends RecyclerView.Adapter {
    private final RecyclerView recyclerView;
    private ArrayList<UserData> arraylistUserData;
    private CardView cardView;
    private Context context;
    private String TAG = UserDataAdapter.class.getSimpleName();
    private View progressLayout;
    private OnItemClickListener onItemClickListener;

    public UserDataAdapter(ArrayList<UserData> arraylistUserData, RecyclerView recyclerView
                            , Context context) {
        this.arraylistUserData = arraylistUserData;
        this.context = context;
        this.recyclerView = recyclerView;

    }

    @Override
    public int getItemViewType(int position) {
//        Toast.makeText(context, "getItemTypePosition->"+position, Toast.LENGTH_SHORT).show();
        if(arraylistUserData.get(position) instanceof UserData)
        {
            return 1;
        }
        else {
            return 0;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: viewType->"+viewType );
        if(viewType==1)
        {

            cardView = (CardView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout__rowitem,parent , false);

            return new UserDataViewHolder(cardView);
        }
        else if(viewType==0)
        {
            progressLayout = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout__progressbar, parent, false);
            return new ProgressbarViewHolder(progressLayout);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserDataViewHolder) {
            ((UserDataViewHolder) holder).userEmail.setText(arraylistUserData.get(position).getEmali());
            ((UserDataViewHolder) holder).userName.setText(arraylistUserData.get(position).getName());
            
        } else if (holder instanceof ProgressbarViewHolder) {
            ((ProgressbarViewHolder) holder).progressBar.setIndeterminate(true);
//            ColorStateList colorStateList=new ColorStateList()
//            ((ProgressbarViewHolder) holder).progressBar.setProgressTintList();

        }

    }

    @Override
    public int getItemCount() {
        return arraylistUserData.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class UserDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView userName;
        public TextView userEmail;

        public UserDataViewHolder(CardView itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.userName = (TextView) itemView.findViewById(R.id.tv_layoutrowitem_name);
            this.userEmail = (TextView) itemView.findViewById(R.id.tv_layoutrowitem_email);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "click "+((TextView)v.findViewById(R.id.tv_layoutrowitem_email)).getText(), Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onClick: cardview position" + getAdapterPosition());
            onItemClickListener.onItemClickListener(v);
        }
    }

    class ProgressbarViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;
        public ProgressbarViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.pb_layoutprogress);
        }
    }
}

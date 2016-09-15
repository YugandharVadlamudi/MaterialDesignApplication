package com.example.recycleviewprogressbarapplication.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.recycleviewprogressbarapplication.R;
import com.example.recycleviewprogressbarapplication.Utils.UserDetails;
import com.example.recycleviewprogressbarapplication.interfaes.OnLoadMoreListener;

import java.util.List;

/**
 * Created by Kiran on 06-06-2016.
 */
public class NameEamilAdapter extends RecyclerView.Adapter {
    private static final String TAG = NameEamilAdapter.class.getSimpleName();
    private final int VIEW_USERDATA = 0;
    private final int VIEW_PROGRESSBAR = 0;
    private final int VISIBLE_THRESHOLD = 5;
    private final Context context;
    private final int VIEW_TYPE_ITEM = 1;
    private final int VIEW_TYPE_LOADING = 0;
    private int totalItemCount;
    private int lastVisibleItem;
    private boolean isLoading;
    private List<UserDetails> listUerDetails;
    private RecyclerView recyclerView;
    private OnLoadMoreListener onLoadMoreListener;

    public NameEamilAdapter(RecyclerView recyclerView, final Context context
            , List<UserDetails> listUserDetails) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.listUerDetails = listUserDetails;
        final LinearLayoutManager linearLayoutManager =
                (LinearLayoutManager) this.recyclerView.getLayoutManager();
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                Log.d(TAG, "onScrolled: recycleView->" + recyclerView + "\n dx->" + dx + "\n dy->" + dy
                        + "\n totalItemCount->" + totalItemCount
                        + "\n layoutManagerLastVisibelItem" + lastVisibleItem);
                if (!isLoading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLodeMore();
                    }
                    isLoading = true;
                }

            }
        });
        /*this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Toast.makeText(context, "Scrolled", Toast.LENGTH_SHORT).show();
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLodeMore();
                    }
                    isLoading = true;
                }
            }
        })*/
        ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: viewType->" + viewType);
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
            return new UserDetailsViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(context).inflate(R.layout.row_progressbar, parent, false);
            return new ProgressbarViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProgressbarViewHolder) {
            ProgressbarViewHolder progressbarViewHolder = (ProgressbarViewHolder) holder;
            progressbarViewHolder.progressBar.setIndeterminate(true);
        } else if (holder instanceof UserDetailsViewHolder) {
            UserDetailsViewHolder userDetailsViewHolde = (UserDetailsViewHolder) holder;
            userDetailsViewHolde.userName.setText(listUerDetails.get(position).getUserName());
            userDetailsViewHolde.userEmail.setText(listUerDetails.get(position).getUserEmail());
        }

    }

    @Override
    public int getItemCount() {
        return listUerDetails == null ? 0 : listUerDetails.size();
//        return listUerDetails.size();
    }

    @Override
    public int getItemViewType(int position) {

        return listUerDetails.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }
    public void setLoaded() {
        isLoading = false;
    }
    /*
    * class ProgressbarViewHolder
    *
    * */
    class ProgressbarViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressbarViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.pb_rowprogressbar);
        }
    }

    /*
    * class UserDetailsViewHolder
    *
    * */
    class UserDetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userEmail;

        public UserDetailsViewHolder(View itemView) {
            super(itemView);
            setUserDetailsViews(itemView);
        }

        private void setUserDetailsViews(View itemView) {
            userName = (TextView) itemView.findViewById(R.id.tv_rowitem_name);
            userEmail = (TextView) itemView.findViewById(R.id.tv_rowitem_email);
        }
    }

}

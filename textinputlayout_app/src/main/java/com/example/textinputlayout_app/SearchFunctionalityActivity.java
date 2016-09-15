package com.example.textinputlayout_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.textinputlayout_app.adapters.RecyclerViewAdapater;

import java.util.ArrayList;
import java.util.List;

public class SearchFunctionalityActivity extends AppCompatActivity {

    private RecyclerView rvSearchFunctionality;
    private SearchView svSerachFunctionality;
    private List<String> namesArray=new ArrayList<>();
    private RecyclerViewAdapater recyclerViewAdapater;
    private Context context;
    private final String TAG = SearchFunctionalityActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_functionality);
        setUpViews();
    }

    private void setUpViews() {
        context = getApplicationContext();
        rvSearchFunctionality = (RecyclerView) findViewById(R.id.rv_searchfunctionality);
        svSerachFunctionality = (SearchView) findViewById(R.id.sv_searchfunctionality);
        adapter();
        setSearchQueryListenrer();
    }

    private void setSearchQueryListenrer() {
        svSerachFunctionality.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e(TAG, "onQueryTextChange: newText->" + newText);
                String query = newText.toLowerCase();
                final List<String> filteredList = new ArrayList<String>();
                for (int noIterate = 0; noIterate < namesArray.size(); noIterate++) {
                    String searchText = namesArray.get(noIterate).toLowerCase();
                    if (searchText.contains(query)) {
                        filteredList.add(searchText);
                    }
                }
                rvSearchFunctionality.setLayoutManager(new LinearLayoutManager(context));
                rvSearchFunctionality.setAdapter(new RecyclerViewAdapater(context,filteredList));
                return true;
            }
        });
    }

    private void adapter() {
        String[] namesarray=getResources().getStringArray(R.array.recyclerviewlist);
        for (int i=0;i<namesarray.length;i++) {
            namesArray.add(namesarray[i]) ;
        }
        Log.d(TAG, "adapter: nameArrayLength->" + namesArray.size());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerViewAdapater = new RecyclerViewAdapater(context, namesArray);
        rvSearchFunctionality.setLayoutManager(linearLayoutManager);
        rvSearchFunctionality.setAdapter(recyclerViewAdapater);
    }

}

package com.example.textinputlayout_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText tietMain;
    private AutoCompleteTextView tietMainAutoComplete;
    private Button btMain;
    private final String TAG = MainActivity.class.getSimpleName();
    private TextInputLayout tilMain;
    private EditText editText;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        context = getApplicationContext();
        tietMain = (TextInputEditText) findViewById(R.id.tiet);
        editText = (EditText) findViewById(R.id.et);
        tietMainAutoComplete = (AutoCompleteTextView) findViewById(R.id.tiet_main_autotext);
        tilMain = (TextInputLayout) findViewById(R.id.til_main);
        btMain = (Button) findViewById(R.id.bt_main);
        autocompleteSetAdapter();
        setListenerViews();
    }

    private void autocompleteSetAdapter() {
        TextInputLayout parent = (TextInputLayout) tietMain.getParent();
        parent.setHint(Html.fromHtml("Hello Hint"+"<font color=\"#01A2DD\">*</font>"));
//        String hintText = parent.getHint().toString();
//        hintText.concat("*") ;
//        hintText.concat("<font color=#7AA595>"+"*"+"</font>");
//        parent.setHint(hintText);
        Log.d(TAG, "setUpViews: edittext hint ->"+parent.getHint());
        String[] listNames = getResources().getStringArray(R.array.autocomplete);
        ArrayAdapter<String> stringList=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,listNames);
        tietMainAutoComplete.setAdapter(stringList);

    }

    private void setListenerViews() {
        btMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_main:

                if (tietMain.getText().length() == 0) {
                    tilMain.setError("enter data");
                } else {
                    Log.e(TAG, "onClick: the of TextInputEditText->" + tietMain.getText());
                }
                break;
        }
    }

    Intent intent = new Intent();

}

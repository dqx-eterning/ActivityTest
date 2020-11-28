package com.example.activitytest.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.activitytest.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
       listView =  findViewById(R.id.lv_1);
       listView.setAdapter(new MyListAdapter(ListViewActivity.this));
    }
}

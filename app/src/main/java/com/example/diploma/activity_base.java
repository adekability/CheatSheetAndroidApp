package com.example.diploma;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import com.example.ineedmoney.R;
import java.util.ArrayList;
import java.util.HashMap;

public class activity_base extends AppCompatActivity {
    private SearchView searchView;
    private Button searchButton;
    private Button clearButton;
    public ArrayList<HashMap<String, String>> list;
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        searchView = (SearchView) findViewById(R.id.search_button);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String search = searchView.getQuery().toString();
                searchMethod(search);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchButton = (Button) findViewById(R.id.button7);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchView.getQuery().toString();
                searchMethod(search);
            }
        });
        clearButton = (Button) findViewById(R.id.button8);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setQuery("",true);
                populateList();
                System.out.println("me");
            }
        });
        populateList();
    }

    public void populateList(){
        listView = (ListView) findViewById(R.id.listView1);
        DataHandler dataHandler = new DataHandler(this, null, null, 1);
        list = dataHandler.loadHandler();
        ListViewAdapter adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivity1();
            }
        });
    }

    public void searchMethod(String search1){
        DataHandler dataHandler = new DataHandler(this, null, null, 1);
        listView.setAdapter(null);
        list = dataHandler.findHandler(search1);
        ListViewAdapter adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);
    }
    public void openActivity1(){
        Intent intent = new Intent(this, image_view.class);
        startActivity(intent);
    }
}


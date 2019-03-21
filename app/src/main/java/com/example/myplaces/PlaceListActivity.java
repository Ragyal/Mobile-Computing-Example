package com.example.myplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity {

    List<String> mPlaces;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final Button addButton = findViewById(R.id.add_button);
        final EditText inputField = findViewById(R.id.place_editText);
        final ListView placesList = findViewById(R.id.places_listView);

        mPlaces = new ArrayList<>();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mPlaces);
        placesList.setAdapter(mAdapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlaces.add(inputField.getText().toString());
                mAdapter.notifyDataSetChanged();
            }
        });

        placesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedPlace = mPlaces.get(position);

                        Intent intent = new Intent(PlaceListActivity.this, DetailActivity.class);
                        intent.putExtra(DetailActivity.EXTRA_PLACE_NAME, selectedPlace);

                        startActivity(intent);
                    }
                }
        );
    }
}

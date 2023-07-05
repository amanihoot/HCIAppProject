package com.example.calenderapp;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainCalenderView extends AppCompatActivity {



    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private addlist listview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_main_view);

        addList = findViewById(R.id.addList);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addList(view);
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>( context: this, android.R.layout.simple_list_item_1, items)
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();
        }

        private voide addList(View view) {
        listView.SetOnItemClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long 1) {
                Context context = getApplicationContext();
                Toast.makeText(context, text: "Item Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemsAdapter.notifyDataSetChanged();

            }
        });

        }

}

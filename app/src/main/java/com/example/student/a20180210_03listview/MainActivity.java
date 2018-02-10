package com.example.student.a20180210_03listview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<>();
        mylist.add("AA");
        mylist.add("BB");
        mylist.add("CC");
        mylist.add("蘋果");
        mylist.add("香蕉");
        mylist.add("巧克力");
        mylist.add("AA2");
        mylist.add("BB2");
        mylist.add("CC2");
        mylist.add("蘋果2");
        mylist.add("香蕉2");
        mylist.add("巧克力2");
        mylist.add("AA3");
        mylist.add("BB3");
        mylist.add("CC3");
        mylist.add("蘋果3");
        mylist.add("香蕉3");
        mylist.add("巧克力3");
        lv = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, mylist);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, mylist.get(position), Toast.LENGTH_SHORT).show();
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("data", mylist.get(position));
                startActivity(it);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("刪除確認");
                builder.setMessage("確認刪除本筆資料?");
                builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mylist.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }
        });

        lv.setAdapter(adapter);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId()){
            case R.id.menu1:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final EditText ed = new EditText(MainActivity.this);
                builder.setTitle("新增資料");
                builder.setView(ed);
                builder.setPositiveButton("新增", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mylist.add(ed.getText().toString());
                    }
                });
                builder.show();
        }
        return super.onOptionsItemSelected(item);
    }


}

package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends androidx.appcompat.app.AppCompatActivity implements MyAdapter.MyBookClickInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.main);

        RecyclerView recyclerView = findViewById(R.id.recycle);

        MyAdapter mAdapter = new MyAdapter(getMockList(), this);
        recyclerView.setAdapter(mAdapter);
    }

    private List<Book> getMockList() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("olololo 1"));
        list.add(new Book("olololo 2"));
        list.add(new Book("olololo 3"));
        list.add(new Book("olololo 4"));
        list.add(new Book("olololo 5"));
        list.add(new Book("olololo 6"));
        list.add(new Book("olololo 7"));
        return list;
    }

    @Override
    public void onBookClick(Integer position) {
        Toast.makeText(this, "position " + position, Toast.LENGTH_SHORT).show();
    }
}

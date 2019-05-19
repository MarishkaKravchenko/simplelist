package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Book> mDataset;

    private MyBookClickInterface callback;

    public MyAdapter(List<Book> myDataset, MyBookClickInterface callback) {
        mDataset = myDataset;
        this.callback = callback;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).getTitle());

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public android.widget.TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onBookClick(getAdapterPosition());
                    }

                }
            });
        }
    }

    public interface MyBookClickInterface {
        void onBookClick(Integer position);
    }
}

package com.example.jordanrburke.shelbycountyparksapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private String [] mDataset;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView titleSelection = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_view_selection, parent, false);

        MyViewHolder vh = new MyViewHolder(titleSelection);
        return vh;

    }

    public ListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.eventName.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName;
        public MyViewHolder(TextView v) {
            super(v);
            eventName = v;
        }
    }





}

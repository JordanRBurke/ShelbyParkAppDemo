package com.example.jordanrburke.shelbycountyparksapp;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;


public class PoolSelectionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerItem> recyclerItems;
    HorizonalAdapter horizonalAdapter;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pool_selection, container, false);
        ButterKnife.bind(this, view);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = getView().findViewById(R.id.recycler_view_pools_fragment);
        recyclerItems = itemFill();

        horizonalAdapter = new HorizonalAdapter(recyclerItems, getContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManager);
        mRecyclerView.setAdapter(horizonalAdapter);
    }

    private List<RecyclerItem> itemFill() {

        List<RecyclerItem> recyclerItems = new ArrayList<>();

        recyclerItems.add(new RecyclerItem(R.drawable.baby_pool_image,"Baby Pool"));
        recyclerItems.add(new RecyclerItem(R.drawable.indoor_pool_image, "Indoor Pool"));
        recyclerItems.add(new RecyclerItem(R.drawable.outside_pool_image, "Outside Pool"));

        return recyclerItems;
    }

    public class HorizonalAdapter extends RecyclerView.Adapter<HorizonalAdapter.MyViewHolder> {

        List<RecyclerItem> recyclerItems = Collections.emptyList();
        Context context;

        public HorizonalAdapter(List<RecyclerItem> recyclerItems, Context context) {
            this.recyclerItems = recyclerItems;
            this.context = context;
        }


        @NonNull
        @Override
        public HorizonalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pool_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HorizonalAdapter.MyViewHolder holder, final int position) {

            holder.imageView.setImageResource(recyclerItems.get(position).imageOfItem);
            holder.textView.setText(recyclerItems.get(position).textOfItem);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String list = recyclerItems.get(position).textOfItem.toString();
                    Toast.makeText(context, list, Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return recyclerItems.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;
            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageview);
                textView = itemView.findViewById(R.id.txtview);
            }
        }
    }


    public static PoolSelectionFragment newInstance() {

        Bundle args = new Bundle();

        PoolSelectionFragment fragment = new PoolSelectionFragment();
        fragment.setArguments(args);
        return fragment;
    }


}

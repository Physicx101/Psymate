package com.example.bogi.psymate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bogi.psymate.model.Clinic;
import com.example.bogi.psymate.R;
import com.mikhaellopez.circularimageview.CircularImageView;


import java.util.ArrayList;
import java.util.List;

public class AdapterClinic extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Clinic> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Clinic obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterClinic(Context context, List<Clinic> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public CircularImageView image;
        public TextView name;
        public TextView address;
        public TextView distance;
        public TextView rating;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            image =  v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
            address = v.findViewById(R.id.address);
            distance = v.findViewById(R.id.distance);
            rating = v.findViewById(R.id.rating);
            lyt_parent =  v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clinics, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            Clinic c = items.get(position);
            view.image.setImageDrawable(c.clinicImage);
            view.name.setText(c.clinicName);
            view.address.setText(c.address);
            view.distance.setText(c.distance);
            view.rating.setText(c.rating);
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
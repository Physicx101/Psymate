package com.example.bogi.psymate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bogi.psymate.model.People;
import com.example.bogi.psymate.R;
import com.example.bogi.psymate.utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogi on 29-Apr-18.
 */

public class AdapterPsychologists extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<People> items = new ArrayList<>();

    private Context ctx;
    private AdapterPsychologists.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, People obj, int position);
    }

    public void setOnItemClickListener(final AdapterPsychologists.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterPsychologists(Context context, List<People> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView desc;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            image =  v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
           desc = v.findViewById(R.id.description);
            lyt_parent =  v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_psychologists, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof AdapterPsychologists.OriginalViewHolder) {
            AdapterPsychologists.OriginalViewHolder view = (AdapterPsychologists.OriginalViewHolder) holder;

            People p = items.get(position);
            Tools.displayImageRound(ctx, view.image, p.image);
            view.name.setText(p.name);
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

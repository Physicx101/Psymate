package com.example.bogi.psymate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bogi.psymate.model.People;
import com.example.bogi.psymate.adapter.AdapterPsychologists;
import com.example.bogi.psymate.data.DataGenerator;
import com.example.bogi.psymate.utils.SimpleDividerItemDecoration;

import java.util.List;

public class FragmentPsychologists extends Fragment {

    private RecyclerView recyclerView;
    private AdapterPsychologists mAdapter;

    public FragmentPsychologists() {
    }

    public static FragmentPsychologists newInstance() {
        FragmentPsychologists fragment = new FragmentPsychologists();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_psychologists, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setHasFixedSize(true);

        List<People> items = DataGenerator.getPeopleData(getContext());
        items.addAll(DataGenerator.getPeopleData(getContext()));
        //items.addAll(DataGenerator.getPeopleData(getContext()));

        //set data and list adapter
        mAdapter = new AdapterPsychologists(getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterPsychologists.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int position) {
            }
        });

        return root;
    }
}
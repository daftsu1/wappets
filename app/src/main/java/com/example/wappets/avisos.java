package com.example.wappets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class avisos extends Fragment {

    private ListView listview;
    List<String> avisos = new ArrayList<String>();

    public static avisos newInstance() {
        return new avisos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avisos,
                container, false);
        listview = (ListView)view.findViewById(R.id.listAviso);

        initUI(view);


        return view;

    }

    private void initUI(View v){
        FloatingActionButton fab = v.findViewById(R.id.btn_aviso);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        avisos.add("Gato perdido en sector parte alta");
        avisos.add("Perro extraviado en sindempart");
        avisos.add("Perro pastor aleman se escapo en playa la herradura");

        listview.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, avisos));
        registerForContextMenu(listview);

    }
}
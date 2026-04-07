package com.tbt65133334.testgk;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau2Fragment extends Fragment {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandScape;

    public Cau2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau2, container, false);

        recyclerViewDatas = getDataForRecyclerView();

        recyclerViewLandScape = view.findViewById(R.id.ryCau2);

        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLandScape.setLayoutManager(layoutLinearHorizonal);

        landScapeAdapter = new LandScapeAdapter(getContext(), recyclerViewDatas);
        recyclerViewLandScape.setAdapter(landScapeAdapter);

        return view;
    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("thapchamnt", "Tháp chàm Nha Trang");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("bigbenlondon","Tháp Bigben London"));
        return dsDuLieu;
    }
}
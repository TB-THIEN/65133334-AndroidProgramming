package thigk2.tranbaothien.baithigk2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau3Fragment extends Fragment {

    DanhNhanAdapter danhNhanAdapter;
    ArrayList<DanhNhan> recyclerViewDatas;
    RecyclerView recyclerViewDanhNhan;

    public Cau3Fragment() {
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

        View view = inflater.inflate(R.layout.fragment_cau3, container, false);

        recyclerViewDatas = getDataForRecyclerView();

        recyclerViewDanhNhan = view.findViewById(R.id.ryCau3);

        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewDanhNhan.setLayoutManager(layoutLinearHorizonal);

        danhNhanAdapter = new DanhNhanAdapter(getContext(), recyclerViewDatas);
        recyclerViewDanhNhan.setAdapter(danhNhanAdapter);

        return view;
    }

    ArrayList<DanhNhan> getDataForRecyclerView(){
        ArrayList<DanhNhan> dsDuLieu = new ArrayList<DanhNhan>();

        DanhNhan danhNhan1 = new DanhNhan("bacho", "Chủ tịch Hồ Chí Minh");
        dsDuLieu.add(danhNhan1);
        dsDuLieu.add(new DanhNhan("tranhungdao", "Trần Hưng Đạo"));

        return dsDuLieu;
    }
}
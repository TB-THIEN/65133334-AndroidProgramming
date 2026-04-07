package com.tbt65133334.testgk;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Cau1Fragment extends Fragment {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKq;
    Button nutcong, nuttru, nutnhan, nutchia;

    public Cau1Fragment() {
    }

    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void TIMDIEUKIEN(View view){
        // Không cần ép kiểu (EditText) đối với các phiên bản Android Studio mới
        editTextSo1 = view.findViewById(R.id.edtSo1);
        editTextSo2 = view.findViewById(R.id.edtSo2);
        editTextKq  = view.findViewById(R.id.edtKq);

        nutcong = view.findViewById(R.id.btnCong);
        nuttru  = view.findViewById(R.id.btnTru);
        nutnhan = view.findViewById(R.id.btnNhan);
        nutchia = view.findViewById(R.id.btnChia);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        TIMDIEUKIEN(view);

        // Cài đặt sự kiện lắng nghe
        nutcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiCong();
            }
        });

        nuttru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiTru();
            }
        });

        nutnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiNhan();
            }
        });

        nutchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLiChia();
            }
        });

        return view;
    }

    void XuLiCong(){
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        if(!Sothu1.isEmpty() && !Sothu2.isEmpty()) {
            Float soA = Float.parseFloat(Sothu1);
            Float soB = Float.parseFloat(Sothu2);
            Float tong = soA + soB;
            editTextKq.setText(String.valueOf(tong));
        }
    }

    void XuLiTru(){
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        if(!Sothu1.isEmpty() && !Sothu2.isEmpty()) {
            Float soA = Float.parseFloat(Sothu1);
            Float soB = Float.parseFloat(Sothu2);
            Float hieu = soA - soB;
            editTextKq.setText(String.valueOf(hieu));
        }
    }

    void XuLiNhan(){
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        if(!Sothu1.isEmpty() && !Sothu2.isEmpty()) {
            Float soA = Float.parseFloat(Sothu1);
            Float soB = Float.parseFloat(Sothu2);
            Float tich = soA * soB;
            editTextKq.setText(String.valueOf(tich));
        }
    }

    void XuLiChia(){
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        if(!Sothu1.isEmpty() && !Sothu2.isEmpty()) {
            Float soA = Float.parseFloat(Sothu1);
            Float soB = Float.parseFloat(Sothu2);
            if (soB != 0) {
                Float thuong = soA / soB;
                editTextKq.setText(String.valueOf(thuong));
            } else {
                editTextKq.setText("Lỗi: Chia cho 0");
            }
        }
    }
}
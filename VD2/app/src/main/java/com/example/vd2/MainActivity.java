package com.example.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //KHAI BÁO CÁC ĐỐI TƯỢNG
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKq;
    Button nutcong, nuttru, nutnhan, nutchia;

    void TIMDIEUKIEN(){
        editTextSo1 = (EditText)findViewById(R.id.edtSo1);
        editTextSo2 = (EditText)findViewById(R.id.edtSo2);
        editTextKq = (EditText)findViewById(R.id.edtKq);

        nutcong = (Button) findViewById(R.id.btnCong);
        nuttru = (Button) findViewById(R.id.btnTru);
        nutnhan = (Button) findViewById(R.id.btnNhan);
        nutchia = (Button) findViewById(R.id.btnChia);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TIMDIEUKIEN();


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
    }


void XuLiCong(){


        //LẤY DỮ LIỆU
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        //CHUYỂN DỮ LIỆU SANG DẠNG CHUỖI
        Float soA = Float.parseFloat(Sothu1);
        Float soB = Float.parseFloat(Sothu2);

        Float tong = soA + soB;

        //TÌM KẾT QUẢ

        //CHUYỂN SANG DẠNG CHUỖI
        String chuoiKQ = String.valueOf(tong);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKq.setText(chuoiKQ);
    }
void XuLiTru(){
        //LẤY DỮ LIỆU
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        //CHUYỂN DỮ LIỆU SANG DẠNG CHUỖI
        Float soA = Float.parseFloat(Sothu1);
        Float soB = Float.parseFloat(Sothu2);

        Float hieu = soA - soB;

        //CHUYỂN SANG DẠNG CHUỖI
        String chuoiKQ = String.valueOf(hieu);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKq.setText(chuoiKQ);
    }
void XuLiNhan(){
        //LẤY DỮ LIỆU
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        //CHUYỂN DỮ LIỆU SANG DẠNG CHUỖI
        Float soA = Float.parseFloat(Sothu1);
        Float soB = Float.parseFloat(Sothu2);

        Float tich = soA * soB;

        //CHUYỂN SANG DẠNG CHUỖI
        String chuoiKQ = String.valueOf(tich);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKq.setText(chuoiKQ);
    }
void XuLiChia(){
        //LẤY DỮ LIỆU
        String Sothu1 = editTextSo1.getText().toString();
        String Sothu2 = editTextSo2.getText().toString();

        //CHUYỂN DỮ LIỆU SANG DẠNG CHUỖI
        Float soA = Float.parseFloat(Sothu1);
        Float soB = Float.parseFloat(Sothu2);

        Float thuong = soA/soB;

        //CHUYỂN SANG DẠNG CHUỖI
        String chuoiKQ = String.valueOf(thuong);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKq.setText(chuoiKQ);
    }
}
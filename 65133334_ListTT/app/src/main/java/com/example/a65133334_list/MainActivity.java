package com.example.a65133334_list;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

        ArrayList<String> dsTinhthanhVN;
        dsTinhthanhVN = new ArrayList<String>();
        dsTinhthanhVN.add("Nha Trang");
        dsTinhthanhVN.add("Thanh pho Ho Chi Minh");
        dsTinhthanhVN.add("Da Nang");
        dsTinhthanhVN.add("Bac Ninh");
        dsTinhthanhVN.add("Ha Noi");

        ArrayAdapter<String> adapterTinh;
        adapterTinh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsTinhthanhVN);

        ListView lvTenTT = findViewById(R.id.lvDanhSachTT);
        lvTenTT.setAdapter(adapterTinh);
    }
}
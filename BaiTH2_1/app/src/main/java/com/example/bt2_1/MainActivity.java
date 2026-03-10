package com.example.bt2_1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }
    public void XuLiCong(View view){
        EditText editTextView = findViewById(R.id.edtA);
        EditText editTextView1 = findViewById(R.id.edtB);
        EditText editTextView2 = findViewById(R.id.edtKetqua);

        String strA =  editTextView.getText().toString();
        String strB =  editTextView1.getText().toString();

        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        int tong = soA + soB;
        String strTong = String.valueOf(tong);
        editTextView2.setText(strTong);

    }
}
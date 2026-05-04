package com.tbt65133334.vieccanlam;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASK> lvcl;
    TASKRVAdapter adapter;

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

        FloatingActionButton fabAdd = findViewById(R.id.floatingActionButton);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemTaskActivity.class);
                startActivity(intent);
            }
        });

        lvcl = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rcvVCL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new TASKRVAdapter(lvcl);
        recyclerView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("TASK");
        databaseReference.addValueEventListener(ngheFB);
    }

    ValueEventListener ngheFB = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            lvcl.clear();
            for (DataSnapshot obj : snapshot.getChildren()) {
                try {
                    // Cố gắng ép kiểu dữ liệu
                    TASK task = obj.getValue(TASK.class);
                    if (task != null) {
                        lvcl.add(task);
                    }
                } catch (Exception e) {
                    // Nếu gặp dữ liệu lỗi trên Firebase, in ra log và bỏ qua record đó để app không bị văng
                    Log.e("LoiFirebase", "Bỏ qua dữ liệu sai định dạng: " + e.getMessage());
                }
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Log.e(TAG, "Firebase error: " + error.getMessage());
        }
    };
}
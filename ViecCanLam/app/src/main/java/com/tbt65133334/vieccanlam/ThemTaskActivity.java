package com.tbt65133334.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.editTextTenCV);
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextMessage = findViewById(R.id.editTextMessage);
                EditText editTextPriority = findViewById(R.id.editTextPriority);

                String tenCV = editTextName.getText().toString();
                String date = editTextDate.getText().toString();
                String mess = editTextMessage.getText().toString();
                String prio= editTextPriority.getText().toString();
                TASK task = new TASK(date, tenCV, mess, prio);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASK");
                String key = databaseReference.push().getKey();

                HashMap<String , Object> item = new HashMap<String, Object>();
                item.put(key, task.toFireBaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            if(error == null) finish();
                    }
                });
            }
        });
    }
}
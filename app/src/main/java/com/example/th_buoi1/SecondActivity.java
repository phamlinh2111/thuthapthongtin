package com.example.th_buoi1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Ánh xạ TextView và Button
        TextView textinfo = findViewById(R.id.textinfo);
        Button backButton = findViewById(R.id.button);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String receivedText = intent.getStringExtra("data");

        textinfo.setText(receivedText);


        // Xử lý sự kiện nút Back
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

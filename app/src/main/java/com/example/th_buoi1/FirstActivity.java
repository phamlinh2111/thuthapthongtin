package com.example.th_buoi1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private EditText edtName, edtMSSV, edtClass, edtPhone, edtPlan;
    private RadioGroup radioGroupYear;
    private CheckBox chkMTHTN, chkDT, chkVT;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtClass = findViewById(R
                .id.edtClass);
        edtPhone = findViewById(R.id.edtPhone);
        edtPlan = findViewById(R.id.edtPlan);

        radioGroupYear = findViewById(R.id.radioGroup);

        chkMTHTN = findViewById(R.id.chkMTHTN);
        chkDT = findViewById(R.id.chkDT);
        chkVT = findViewById(R.id.chkVT);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = edtName.getText().toString().trim();
        String mssv = edtMSSV.getText().toString().trim();
        String className = edtClass.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String plan = edtPlan.getText().toString().trim();

        // Kiểm tra năm học đã chọn
        int selectedYearId = radioGroupYear.getCheckedRadioButtonId();
        String year = "";
        RadioButton selectedRadioButton = findViewById(selectedYearId);
        year = selectedRadioButton.getText().toString();

        // Kiểm tra chuyên ngành đã chọn
        String major = "";
        if (chkMTHTN.isChecked()) major += "MT-HTN ";
        if (chkDT.isChecked()) major += "ĐT ";
        if (chkVT.isChecked()) major += "VT ";

        String message = "Họ và Tên: " + name + "\n"
                + "MSSV: " + mssv + "\n"
                + "Lớp: " + className + "\n"
                + "SĐT: " + phone + "\n"
                + "Sinh viên: " + year + "\n"
                + "Chuyên ngành: " + major + "\n"
                + "Kế hoạch: " + plan;

        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("data", message);
        startActivity(intent);
    }
}

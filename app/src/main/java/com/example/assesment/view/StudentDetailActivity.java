package com.example.assesment.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.assesment.R;

public class StudentDetailActivity extends AppCompatActivity {

    private ImageView imgStudentDetailPic;
    private TextView txtNameStdDtl, txtAgeStdDtl, txtGradeStdDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_detail);
        initView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.studentDetails), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initView() {
        imgStudentDetailPic = findViewById(R.id.imgStudentDetailPic);
        txtNameStdDtl = findViewById(R.id.txtNameStdDtl);
        txtAgeStdDtl = findViewById(R.id.txtAgeStdDtl);
        txtGradeStdDtl = findViewById(R.id.txtGradeStdDtl);
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String grade = getIntent().getStringExtra("grade");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        txtNameStdDtl.setText(name);
        txtAgeStdDtl.setText(age);
        txtGradeStdDtl.setText(grade);
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.default_profile)
//                .error(R.drawable.error_image)
                .into(imgStudentDetailPic);
    }
}
package com.example.assesment.view;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assesment.MyApplication;
import com.example.assesment.R;
import com.example.assesment.model.Student;
import com.example.assesment.repository.StudentRepository;
import com.example.assesment.view.adapter.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StudentListActivity extends AppCompatActivity {

    @Inject
    StudentRepository studentRepository;

    private RecyclerView recyclerView;

    private StudentAdapter studentAdapter;
    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_list);

        MyApplication.getAppComponent().inject(this);

        recyclerView = findViewById(R.id.studentListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(studentAdapter);

        studentRepository.getStudents(new StudentRepository.StudentsCallback() {
            @Override
            public void onSuccess(List<Student> students) {
                for (Student student : students) {
                    Log.d("Student Info", "Name: " + student.getName() + ", Email: " + student.getGrade());
                    studentList.clear();
                    studentList.addAll(students);
                    studentAdapter.updateData(studentList);
                }
            }

            @Override
            public void onFailure(String error) {
                Log.e("API Error", error);
            }
        });


    }
}
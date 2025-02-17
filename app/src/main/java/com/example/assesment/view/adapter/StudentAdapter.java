package com.example.assesment.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assesment.R;
import com.example.assesment.model.Student;
import com.example.assesment.view.StudentDetailActivity;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card_view, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtStdName.setText(student.getName());
        holder.txtStdAge.setText(student.getAge());
        holder.txtStdGrade.setText(student.getGrade());

        Glide.with(holder.itemView.getContext())
                .load(student.getImage())
                .placeholder(R.drawable.default_profile)
//                .error(R.drawable.error_image)
                .into(holder.imgStdProfilePic);

        holder.imgStdProfilePic.setOnClickListener(v -> {
            Intent intent = new Intent(context, StudentDetailActivity.class);
            intent.putExtra("name", student.getName());
            intent.putExtra("age", student.getAge());
            intent.putExtra("grade", student.getGrade());
            intent.putExtra("imageUrl", student.getImage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView txtStdName, txtStdAge, txtStdGrade;
        ImageView imgStdProfilePic;
        CardView cardViewStudent;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStdName = itemView.findViewById(R.id.txtStdName);
            txtStdAge = itemView.findViewById(R.id.txtStdAge);
            txtStdGrade = itemView.findViewById(R.id.txtStdGrade);
            imgStdProfilePic = itemView.findViewById(R.id.imgStdProfilePic);
            cardViewStudent = itemView.findViewById(R.id.cardViewStudent);
        }
    }

    public void updateData(List<Student> newStudents) {
        this.studentList = newStudents;
        notifyDataSetChanged();
    }
}

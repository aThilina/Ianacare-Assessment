package com.example.assesment.repository;

import com.example.assesment.model.Student;
import com.example.assesment.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentRepository {
    private final ApiService apiService;

    @Inject
    public StudentRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getStudents(StudentsCallback callback) {
        apiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure("Failed to get students");
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface StudentsCallback {
        void onSuccess(List<Student> students);
        void onFailure(String error);
    }
}

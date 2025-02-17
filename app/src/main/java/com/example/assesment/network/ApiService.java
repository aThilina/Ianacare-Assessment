package com.example.assesment.network;

import com.example.assesment.model.Student;

import java.util.List;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.http.GET;

@Singleton
public interface ApiService {

    @GET("students")
    Call<List<Student>> getStudents();
}

package com.example.assesment.di;

import com.example.assesment.network.NetworkModule;
import com.example.assesment.repository.StudentRepository;
import com.example.assesment.view.StudentListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {
    void inject(StudentListActivity studentListActivity);  // ✅ Add this line
    void inject(StudentRepository repository);
}

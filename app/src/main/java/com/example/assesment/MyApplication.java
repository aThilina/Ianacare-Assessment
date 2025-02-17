package com.example.assesment;

import android.app.Application;

import com.example.assesment.di.AppComponent;
import com.example.assesment.di.DaggerAppComponent;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;;

public class MyApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);

        // Point Firebase Authentication to Emulator
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.useEmulator("10.0.2.2", 9099);
        appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent() {
//        appComponent = DaggerAppComponent.create();
        return appComponent;
    }
}

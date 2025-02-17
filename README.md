# Ianacare-Assessment
This is an Android application (Java) that implements Firebase Authentication using the Firebase Authentication Emulator and displays student details in a RecyclerView, retrieved from a Mock API.

## Features
1. Firebase Authentication using Email & Password
2. Firebase Authentication Emulator (Runs locally for testing)
3. Student List using RecyclerView
4. Fetch data from Mock API using Retrofit
5. MVVM Architecture with Dagger 2
6. Glide for Image Loading
7. Navigation Between Activities

## Technologies Used
Java
Firebase Authentication Emulator
Retrofit (API calls)
Dagger 2 (Dependency Injection)
RecyclerView (Display student list)
Glide (Image Loading)
Material Design UI

## Steps to run the project

1. Running Firebase Authentication Emulator
        Install Firebase CLI and Start emulator
            npm install -g firebase-tools
            firebase emulators:start --only auth
            The Emulator UI will be available at: http://localhost:4000

## API Reference
Base URL: https://67adc18e3f5a4e1477def487.mockapi.io/api/v1/students/
Get Students: GET /students
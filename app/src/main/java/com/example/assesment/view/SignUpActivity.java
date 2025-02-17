package com.example.assesment.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assesment.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText txtFName, txtLName, txtEmail, txtPassword;
    private Button btnContinue, btnToLogIn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        initComponent();
        initActions();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initActions() {
        btnToLogIn.setOnClickListener(v -> {
            finish();
        });
        btnContinue.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Enter Email and Password", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initComponent() {
        txtFName = findViewById(R.id.txtSignUpFirstName);
        txtLName = findViewById(R.id.txtSignUpLastName);
        txtEmail = findViewById(R.id.txtSignUpEmail);
        txtPassword = findViewById(R.id.txtSignUpPassword);
        btnContinue = findViewById(R.id.btnSignUpContinue);
        btnToLogIn = findViewById(R.id.btnToLogIn);
    }
}
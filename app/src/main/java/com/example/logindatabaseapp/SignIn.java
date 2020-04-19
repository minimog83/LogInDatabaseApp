package com.example.logindatabaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {
    EditText edtPassword, edtMail;
    Button btnLogIn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtMail = (EditText) findViewById(R.id.edtMail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnLogIn = (Button) findViewById(R.id.btnLogIn);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = edtMail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    edtMail.setError("Name is Required!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    edtPassword.setError("Password is Required!");
                    return;
                }

                if (password.length() < 6) {
                    edtPassword.setError("Password must be more than 6 characters");
                }

//                progressBar.setVisibility(View.VISIBLE);
//                fAuth.signInWithEmailAndPassword(mail, password)
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithEmail:success");
//                                    FirebaseUser user = fAuth.getCurrentUser();
//                                    updateUI(user);
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                    Toast.makeText(SignIn.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
//                                }
//
//                                // ...
//                            }
//                        });
            }
        });

    }
}

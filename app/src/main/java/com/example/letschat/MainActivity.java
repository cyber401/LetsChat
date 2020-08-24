package com.example.letschat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
EditText phoneNumber, editTextVerification;
Button button;
PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber=findViewById(R.id.phone);
        button =findViewById(R.id.button);
        editTextVerification = findViewById(R.id.verification);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }
        };

           sentVerificationCode();

    }

    private void sentVerificationCode() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber.getText().toString(),
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {

    }
}

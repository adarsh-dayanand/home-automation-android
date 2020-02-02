package com.ad.homeautomation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

    }

    public void LedActivity(View view) {

        Intent i = new Intent(ProfileActivity.this, DeviceList.class);
        startActivity(i);

    }

    public void logout(View view) {

        mAuth.signOut();
        sendUserToLogin();

    }

    private void sendUserToLogin() {

        Intent loginIntent = new Intent(ProfileActivity.this, VerifyPhoneActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();

    }
}

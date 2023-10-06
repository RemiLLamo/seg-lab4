package com.github.remilamoureux.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void SetTeamIcon(View view) {
        Intent intent = getIntent();
        intent.putExtra("imageID", view.getId());
        setResult(RESULT_OK, intent);
    }
}
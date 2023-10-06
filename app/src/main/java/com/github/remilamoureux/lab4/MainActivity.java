package com.github.remilamoureux.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = findViewById(R.id.TeamLocation);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=+"+teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        ImageView avatar = findViewById(R.id.imageView);

        String drawableName = "ic_logo_00";
        int e = data.getIntExtra("imageID", R.id.im00);
        if (e == R.id.im00) {
            drawableName = "ic_logo_00";
        } else if (e == R.id.im01) {
            drawableName = "ic_logo_01";
        } else if (e == R.id.im02) {
            drawableName = "ic_logo_02";
        } else if (e == R.id.im03) {
            drawableName = "ic_logo_03";
        } else if (e == R.id.im04) {
            drawableName = "ic_logo_04";
        } else if (e == R.id.im05) {
            drawableName = "ic_logo_05";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatar.setImageResource(resID);


    }

}
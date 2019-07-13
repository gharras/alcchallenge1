package fes.ghm.alcchallenge1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAboutAlc = findViewById(R.id.btnAboutAlc);

        final Intent aboutAlcIntent = new Intent(this, AboutAlc.class);

        btnAboutAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(aboutAlcIntent);
            }
        });

        Button btnMyProfile = findViewById(R.id.btnMyProfile);

        final Intent myProfileIntent = new Intent(this, ProfileActivity.class);

        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myProfileIntent);
            }
        });

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.navigation_blue)));
    }
}

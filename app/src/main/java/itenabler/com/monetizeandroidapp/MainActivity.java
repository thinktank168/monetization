package itenabler.com.monetizeandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_banner = findViewById(R.id.btn_banner);
        Button btn_interstitial = findViewById(R.id.btn_intersitial);


        btn_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BannerActivity.class);
                startActivity(i);

            }
        });

        btn_interstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), InterstitialActivity.class);
                startActivity(j);
            }

        });



    }
}

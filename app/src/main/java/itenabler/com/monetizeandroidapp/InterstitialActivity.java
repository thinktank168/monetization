package itenabler.com.monetizeandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {
    private Button mShowButton;
    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        Button btn_load_interstitial = findViewById(R.id.loadButton);
         mShowButton = findViewById(R.id.showButton);

        mShowButton.setEnabled(false);



    } // End of OnCreate


    public void loadInterstitial(View v) {
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.interstitial_loading));
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new ToastAdListener(this){

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setEnabled(true);
                mShowButton.setText(R.string.interstitial_show);
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mShowButton.setText(getErrorReason());
            }
        });

        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);
    }

    public void showInterstitial(View v) {
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }
        mShowButton.setText(R.string.interstitial_not_ready);
        mShowButton.setEnabled(false);

    }

}

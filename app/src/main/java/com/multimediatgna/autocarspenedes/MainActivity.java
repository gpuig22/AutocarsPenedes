package com.multimediatgna.autocarspenedes;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView myempresa,mycontacte,myserveis,myhoraris,myaudio,myvideo;
    private static Intent myphoneCallIntent;
    private static MediaPlayer mymediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myempresa = (CardView) this.findViewById(R.id.myempresa);
        mycontacte = (CardView) this.findViewById(R.id.mycontacte);
        myserveis = (CardView) this.findViewById(R.id.myserveis);
        myhoraris = (CardView) this.findViewById(R.id.myhoraris);
        myaudio = (CardView) this.findViewById(R.id.myaudio);
        myvideo = (CardView) this.findViewById(R.id.myvideo);
        myempresa.setOnClickListener(this);
        mycontacte.setOnClickListener(this);
        myserveis.setOnClickListener(this);
        myhoraris.setOnClickListener(this);
        myaudio.setOnClickListener(this);
        myvideo.setOnClickListener(this);

    }

    @Override
    public void onClick(View myview) {

        Intent intent;
        String myurl;

        switch (myview.getId()){
            case R.id.myempresa:
                intent = new Intent(MainActivity.this,EmpresaActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.mycontacte:

                myphoneCallIntent = new Intent(Intent.ACTION_CALL);
                myphoneCallIntent.setData(Uri.parse(getString(R.string.callNumber))); //Uri.parse("tel:your number")
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(myphoneCallIntent);
                break;

            case R.id.myaudio:
                mymediaplayer = mymediaplayer.create(this  , R.raw.horn);
                mymediaplayer.start();
                break;

            case R.id.myhoraris:

                WebView mysimpleWebView;
                myurl = getString(R.string.URLHoraris);

                int colorInt = Color.parseColor("#bd3f32"); //red
                CustomTabColorSchemeParams defaultColors = new CustomTabColorSchemeParams.Builder()
                        .setToolbarColor(colorInt)
                        .build();
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                builder.setDefaultColorSchemeParams(defaultColors);
                customTabsIntent.launchUrl(this, Uri.parse(myurl));

                break;

            case R.id.myserveis:

                myurl = new String(getString(R.string.URLServeis));
                try {
                    Uri webpage = Uri.parse(myurl);
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "No application can handle this request. Please install a web browser or check your URL.",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                break;

            case R.id.myvideo:
                    intent = new Intent(MainActivity.this,VideoActivity.class);
                    MainActivity.this.startActivity(intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + myview.getId());
        }

    }
}
package com.multimediatgna.autocarspenedes;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{

    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mybutton = (Button) findViewById(R.id.mybutton3) ;
        mybutton.setOnClickListener(this);

        VideoView mysimpleVideoView = (VideoView) findViewById(R.id.myvideoView);
        mysimpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videobuspenedes));
        mysimpleVideoView.start();
    }


    @Override
    public void onClick(View view) {
        this.finish();
    }
}
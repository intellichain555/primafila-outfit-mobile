package com.app.primafilaoutfit;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.app.primafilaoutfit.util.FullScreenVideoView;

public class SplashActivity extends Activity {
    FullScreenVideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            FullScreenVideoView videoView = (FullScreenVideoView) findViewById(R.id.videoView);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video);
            videoView.setVideoURI(video);

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            videoView.start();
        } catch (Exception ex) {
            jump();
        }
    }

    private void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, StartActivity.class));
        //finish();
    }
}

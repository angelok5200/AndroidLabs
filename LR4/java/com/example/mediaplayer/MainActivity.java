package com.example.mediaplayer;
import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.VideoView;
import android.widget.VideoView;

public class MainActivity extends Activity {

    MediaPlayer mediaPlayer;
    VideoView videoPlayer;
    CheckBox chbLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //am = (AudioManager) getSystemService(AUDIO_SERVICE);
        chbLoop = (CheckBox) findViewById(R.id.chbLoop);
        chbLoop.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (mediaPlayer != null)
                    mediaPlayer.setLooping(isChecked);
            }
        });
    }
    public void onClickStart (View v){
        Button buttonRaw = findViewById(R.id.btnStartRaw);
        buttonRaw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                releaseMP();
                releaseVP();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.explosion);
                mediaPlayer.start();
                if (mediaPlayer == null)
                    return;

                mediaPlayer.setLooping(chbLoop.isChecked());
            }
        });
    }

    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void releaseVP() {
        if (videoPlayer != null) {
            try {
                videoPlayer.stopPlayback();
                videoPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onClick(View view) {
        if (mediaPlayer == null)
            return;
        switch (view.getId()) {
            case R.id.btnPause:
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                break;
            case R.id.btnResume:
                if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
                break;
            case R.id.btnStop:
                mediaPlayer.stop();
                break;
            case R.id.btnBackward:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 30000);
                break;
            case R.id.btnForward:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 30000);
                break;
        }
    }

    public void onVideoClick(View view) {
        if (videoPlayer == null)
            return;
        switch (view.getId()) {
            case R.id.btnPause:
                if (videoPlayer.isPlaying())
                    videoPlayer.pause();
                break;
            case R.id.btnResume:
                if (!videoPlayer.isPlaying())
                    videoPlayer.start();
                break;
            case R.id.btnStop:
                videoPlayer.stopPlayback();
                videoPlayer.resume();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }

    public void Videoplay(View view) {

        releaseVP();
        releaseMP();
        videoPlayer = findViewById(R.id.videoPlayer);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        videoPlayer.setVideoURI(myVideoUri);
        videoPlayer.start();
    }


}
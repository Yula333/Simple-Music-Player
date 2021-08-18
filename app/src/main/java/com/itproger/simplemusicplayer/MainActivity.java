package com.itproger.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jgabrielfreitas.core.BlurImageView;

public class MainActivity extends AppCompatActivity {

    private BlurImageView blurImageView;
    private ImageButton play_btn, stop_btn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blurImageView = findViewById(R.id.BlurImageView);
        blurImageView.setBlur(4);

        play_btn = findViewById(R.id.play_btn);
        stop_btn = findViewById(R.id.stop_btn);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.main_sound);

    }

    public void MusicButtons(View view){
        switch(view.getId()){
            case R.id.play_btn:
                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    play_btn.setImageResource(R.drawable.ic_pause);
                }else {
                    mediaPlayer.pause();
                    play_btn.setImageResource(R.drawable.ic_play);
                }
                break;
            case R.id.stop_btn:
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    play_btn.setImageResource(R.drawable.ic_play);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.main_sound);
                }
                break;
        }

    }
}

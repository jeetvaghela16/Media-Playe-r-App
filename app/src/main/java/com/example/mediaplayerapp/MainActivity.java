package com.example.mediaplayerapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView playerPosition, playerDuration;
    SeekBar seekBar;
    ImageView btRew, btPlay, btPause, btFf, btSkip;

    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    int[] songs = {R.raw.music, R.raw.song2, R.raw.song3};
    int currentSongIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Assign variables
        playerPosition = findViewById(R.id.player_position);
        playerDuration = findViewById(R.id.player_duration);
        seekBar = findViewById(R.id.seek_bar);
        btRew = findViewById(R.id.bt_rew);
        btPlay = findViewById(R.id.bt_play);
        btPause = findViewById(R.id.bt_pause);
        btFf = findViewById(R.id.bt_ff);
        btSkip = findViewById(R.id.bt_skip);

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex]);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
                handler.postDelayed(this, 500);
            }
        };

        int duration = mediaPlayer.getDuration();
        playerDuration.setText(convertFormat(duration));

        btPlay.setOnClickListener(v -> {
            btPlay.setVisibility(View.GONE);
            btPause.setVisibility(View.VISIBLE);
            mediaPlayer.start();
            seekBar.setMax(mediaPlayer.getDuration());
            handler.postDelayed(runnable, 0);
        });

        btPause.setOnClickListener(v -> {
            btPause.setVisibility(View.GONE);
            btPlay.setVisibility(View.VISIBLE);
            mediaPlayer.pause();
            handler.removeCallbacks(runnable);
        });

        btFf.setOnClickListener(v -> {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration1 = mediaPlayer.getDuration();
            if (mediaPlayer.isPlaying() && duration1 != currentPosition) {
                currentPosition += 5000;
                mediaPlayer.seekTo(currentPosition);
            }
        });

        btRew.setOnClickListener(v -> {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (mediaPlayer.isPlaying() && currentPosition > 5000) {
                currentPosition -= 5000;
                mediaPlayer.seekTo(currentPosition);
            }
        });

        btSkip.setOnClickListener(v -> {
            // Stop and release current media player
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            }

            // Move to next song
            currentSongIndex = (currentSongIndex + 1) % songs.length;

            // Initialize new media player
            mediaPlayer = MediaPlayer.create(MainActivity.this, songs[currentSongIndex]);

            int newDuration = mediaPlayer.getDuration();
            playerDuration.setText(convertFormat(newDuration));
            seekBar.setMax(newDuration);

            // Start playback
            mediaPlayer.start();
            btPlay.setVisibility(View.GONE);
            btPause.setVisibility(View.VISIBLE);
            handler.postDelayed(runnable, 0);

            mediaPlayer.setOnCompletionListener(mp -> {
                btPause.setVisibility(View.GONE);
                btPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            });
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mediaPlayer.setOnCompletionListener(mp -> {
            btPause.setVisibility(View.GONE);
            btPlay.setVisibility(View.VISIBLE);
            mediaPlayer.seekTo(0);
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) % 60);
    }
}

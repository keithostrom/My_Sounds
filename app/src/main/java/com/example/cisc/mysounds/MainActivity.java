package com.example.cisc.mysounds;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity implements OnClickListener {
    private SoundPool soundPool;
    int sound1 = -1;
    int sound2 = -1;
    int sound3 = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);



        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        AssetManager assetManager = getAssets();
        AssetFileDescriptor descriptor;
        try {

            descriptor = assetManager.openFd("Impact.wav");
            sound1 = soundPool.load(descriptor, 0);
        }
        catch (IOException e){
            Log.i("info","unable to load Impact.wav");
        }

        try {
            descriptor = assetManager.openFd("Jump.wav");
            sound2 = soundPool.load(descriptor, 0);
        }
        catch (IOException e){
            Log.i("info","unable to load Jump.wav");
        }
        try{
            descriptor = assetManager.openFd("Ocean.wav");
            sound3 = soundPool.load(descriptor,0);
        }
        catch (IOException e){
            Log.i("info","unable to load Ocean.wav");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                soundPool.play(sound1,1,1,0,0,1);
                break;
            case R.id.button2:
                soundPool.play(sound2,1,1,0,0,1);
                break;
            case R.id.button3:
                soundPool.play(sound3,1,1,0,0,1);
                break;

        }
    }
}

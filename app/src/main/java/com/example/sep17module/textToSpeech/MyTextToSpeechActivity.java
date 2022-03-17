package com.example.sep17module.textToSpeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import com.example.sep17module.databinding.ActivityMyTextToSpeechBinding;

import java.util.Locale;

public class MyTextToSpeechActivity extends AppCompatActivity {
    private ActivityMyTextToSpeechBinding binding;
    private TextToSpeech tts;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyTextToSpeechBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i==TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.ENGLISH);
                    tts.setPitch(1.0f);
                    tts.setSpeechRate(1.0f);
                }
            }
        });

        binding.btnSpeak.setOnClickListener(view -> {

            text = binding.edtTextToSpeech.getText().toString();

            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);

        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        tts.stop();
    }
}
package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCsharp;
    private Button buttonD;
    private Button buttonDsharp;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFsharp;
    private Button buttonG;
    private Button buttonGsharp;
    private Button buttonHA;
    private Button buttonHB;
    private Button buttonHBb;
    private Button buttonHC;
    private Button buttonHCs;
    private Button buttonHD;
    private Button buttonHDs;
    private Button buttonHE;
    private Button buttonHF;
    private Button buttonHFs;
    private Button buttonHG;
    private Button buttonHGs;
    private Button buttonScale;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCsharp;
    private int noteD;
    private int noteDsharp;
    private int noteE;
    private int noteF;
    private int noteFsharp;
    private int noteG;
    private int noteGsharp;
    private int noteHA;
    private int noteHB;
    private int noteHBb;
    private int noteHC;
    private int noteHCs;
    private int noteHD;
    private int noteHDs;
    private int noteHE;
    private int noteHF;
    private int noteHFs;
    private int noteHG;
    private int noteHGs;

    private Map<Integer, Integer> noteMap;


    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int WHOLE_NOTE = 1000; // in ms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map, you store a key:value pair
        // the key is the buttonId, the value is the noteId
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_B, noteB);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_csharp, noteCsharp);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_dsharp,noteDsharp);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fsharp, noteFsharp);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gsharp, noteGsharp);
        noteMap.put(R.id.button_synth_higha, noteHA);
        noteMap.put(R.id.button_synth_highb, noteHB);
        noteMap.put(R.id.button_synth_highbb, noteHBb);
        noteMap.put(R.id.button_synth_highc, noteHC);
        noteMap.put(R.id.button_synth_highcs, noteHCs);
        noteMap.put(R.id.button_synth_highd, noteHD);
        noteMap.put(R.id.button_synth_highds, noteHDs);
        noteMap.put(R.id.button_synth_highe, noteHE);
        noteMap.put(R.id.button_synth_highf, noteHF);
        noteMap.put(R.id.button_synth_highg, noteHG);
        noteMap.put(R.id.button_synth_highfs, noteHFs);
        noteMap.put(R.id.button_synth_highgs, noteHGs);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool( 10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec,1);
        noteCsharp = soundPool.load(this, R.raw.scalecs,1);
        noteD = soundPool.load(this, R.raw.scaled,1);
        noteDsharp = soundPool.load(this, R.raw.scaleds,1);
        noteE = soundPool.load(this, R.raw.scalee,1);
        noteF = soundPool.load(this, R.raw.scalef,1);
        noteFsharp = soundPool.load(this, R.raw.scalefs,1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGsharp = soundPool.load(this, R.raw.scalegs, 1);
        noteHA = soundPool.load(this, R.raw.scalehigha, 1);
        noteHB = soundPool.load(this, R.raw.scalehighb, 1);
        noteHBb = soundPool.load(this, R.raw.scalehighbb, 1);
        noteHC = soundPool.load(this, R.raw.scalehighc, 1);
        noteHCs = soundPool.load(this, R.raw.scalehighcs, 1);
        noteHD = soundPool.load(this, R.raw.scalehighd, 1);
        noteHDs = soundPool.load(this, R.raw.scalehighds, 1);
        noteHE = soundPool.load(this, R.raw.scalehighe, 1);
        noteHF = soundPool.load(this, R.raw.scalehighf, 1);
        noteHFs = soundPool.load(this, R.raw.scalehighfs, 1);
        noteHG = soundPool.load(this, R.raw.scalehighg, 1);
        noteHGs = soundPool.load(this, R.raw.scalehighgs, 1);
    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCsharp.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDsharp.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFsharp.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGsharp.setOnClickListener(noteListener);
        buttonHA.setOnClickListener(noteListener);
        buttonHB.setOnClickListener(noteListener);
        buttonHBb.setOnClickListener(noteListener);
        buttonHC.setOnClickListener(noteListener);
        buttonHCs.setOnClickListener(noteListener);
        buttonHD.setOnClickListener(noteListener);
        buttonHDs.setOnClickListener(noteListener);
        buttonHE.setOnClickListener(noteListener);
        buttonHF.setOnClickListener(noteListener);
        buttonHFs.setOnClickListener(noteListener);
        buttonHG.setOnClickListener(noteListener);
        buttonHGs.setOnClickListener(noteListener);
        buttonScale.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_B);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCsharp = findViewById(R.id.button_synth_csharp);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDsharp = findViewById(R.id.button_synth_dsharp);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFsharp = findViewById(R.id.button_synth_fsharp);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGsharp = findViewById(R.id.button_synth_gsharp);
        buttonHA = findViewById(R.id.button_synth_higha);
        buttonHB = findViewById(R.id.button_synth_highb);
        buttonHBb = findViewById(R.id.button_synth_highbb);
        buttonHC = findViewById(R.id.button_synth_highc);
        buttonHCs = findViewById(R.id.button_synth_highcs);
        buttonHD = findViewById(R.id.button_synth_highd);
        buttonHE = findViewById(R.id.button_synth_highe);
        buttonHF = findViewById(R.id.button_synth_highf);
        buttonHFs = findViewById(R.id.button_synth_highfs);
        buttonHDs = findViewById(R.id.button_synth_highds);
        buttonHG = findViewById(R.id.button_synth_highg);
        buttonHGs = findViewById(R.id.button_synth_highgs);

        buttonScale = findViewById(R.id.button_synth_playScale);
    }

    @Override
    public void onClick(View view) {
        // one method to handle the clicks of all the buttons
        // but don't forget to tell the buttons who is doing
        // the listening.
        switch(view.getId()) {
//            case R.id.button_synth_a:
//                soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_bb:
//                soundPool.play(noteBb, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_B:
//                soundPool.play(noteB, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_c:
//                soundPool.play(noteC, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_csharp:
//                soundPool.play(noteCsharp, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_d:
//                soundPool.play(noteD, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_dsharp:
//                soundPool.play(noteDsharp, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_e:
//                soundPool.play(noteE, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_f:
//                soundPool.play(noteF, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_fsharp:
//                soundPool.play(noteFsharp, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_g:
//                soundPool.play(noteG, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;
//            case R.id.button_synth_gsharp:
//                soundPool.play(noteGsharp, 1.0f, 1.0f, 1, 0, 1.0f);
//                break;soundPool
            case R.id.button_synth_playScale:
                playScale();
                break;
        }
    }
    private void playsong(com.example.synthesizer.Song scale){
        for(Note note : scale.getNotes()){
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void playScale() {
        // play all the notes one at a time with a delay in between.
        com.example.synthesizer.Song scale = new com.example.synthesizer.Song();

//        scale.add(new Note(noteE));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteC));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteE,Note.WHOLE_NOTE * 2));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteD, Note.WHOLE_NOTE * 2));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteG));
//        scale.add(new Note(noteG, Note.WHOLE_NOTE * 2));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteC));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteE, Note.WHOLE_NOTE * 2));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteE));
//        scale.add(new Note(noteD));
//        scale.add(new Note(noteC));

        scale.add(new Note(noteHC, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteF));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHF, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHG, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHF));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHB));
        scale.add(new Note(noteHC, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHC));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHG, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHF));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHD, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteHD));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHF, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHF));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteF, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHC));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteF, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHF, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteHG));
        scale.add(new Note(noteHF));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHB));
        scale.add(new Note(noteHC, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHC));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHG, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHF));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHD, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteHD));
        scale.add(new Note(noteHE));
        scale.add(new Note(noteHF, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHF, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteF, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHA));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHA, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHC));
        scale.add(new Note(noteHC, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteG, Note.WHOLE_NOTE * (3/2)));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHBb, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF));
        scale.add(new Note(noteE));
        scale.add(new Note(noteD, Note.WHOLE_NOTE * 2));
        scale.add(new Note(noteE));
        scale.add(new Note(noteF));
        scale.add(new Note(noteA));
        scale.add(new Note(noteB));
        scale.add(new Note(noteC, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteC));
        scale.add(new Note(noteF));
        scale.add(new Note(noteF));
        scale.add(new Note(noteF));
        scale.add(new Note(noteE));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteG));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF));
        scale.add(new Note(noteF));
        scale.add(new Note(noteE, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteC));
        scale.add(new Note(noteC));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteHC, Note.WHOLE_NOTE * 2));

        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteHA));
        scale.add(new Note(noteHBb));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF));


        playsong(scale);

//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteC);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteG);
//        delay(WHOLE_NOTE/2);
//        playNote(noteG);
//        delay(WHOLE_NOTE);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteC);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteE);
//        delay(WHOLE_NOTE/2);
//        playNote(noteD);
//        delay(WHOLE_NOTE/2);
//        playNote(noteC);


    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note,DEFAULT_VOLUME,DEFAULT_VOLUME,DEFAULT_PRIORITY,loop, DEFAULT_RATE);
    }

    private void playNote(int note) {
        playNote(note, 0);
        delay(3);
    }

    private void playNote(Note note) {
        playNote(note.getNoteId(), 0);
        delay(3);
    }

    // make an inner class to handle the button clicks
    // fore the individual notes
    private class KeyboardNoteListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            // get the id of the button that was clicked
            int id = view.getId();
            // use the map to figure out what note to play
            int note = noteMap.get(id);
            // play the note
            playNote(note);
        }
    }


}

package com.example.synthesizer;

public class Note {

    private int noteId; //maybe make this a list of noteId that would all be played at once?
    private int delay;
    public static final int WHOLE_NOTE = 400;

    public Note(int noteId) {
        this.noteId = noteId;
        delay = WHOLE_NOTE;
    }

    public Note(int noteId, int delay) {
        this.noteId = noteId;
        this.delay = delay;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", delay=" + delay +
                '}';
    }
}
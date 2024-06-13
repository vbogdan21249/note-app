package repository;

import model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private List<Note> notes;
    private static int nextId = 1;

    public NoteRepository() {
        notes = new ArrayList<>();
    }

    public void add(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public List<Note> getAll() {
        return notes;
    }
}

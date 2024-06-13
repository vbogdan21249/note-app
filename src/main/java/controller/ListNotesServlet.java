package controller;

import java.util.List;
import model.Note;
import repository.NoteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes")
public class ListNotesServlet extends HttpServlet {
    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        noteRepository = new NoteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Note> notes = noteRepository.getAll();
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}

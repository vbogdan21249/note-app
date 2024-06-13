package controller;

import model.Note;
import repository.NoteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.io.IOException;

@WebServlet(name = "NoteController", urlPatterns = {"/notes", "/notes/add"})
public class NoteController extends HttpServlet {
    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        noteRepository = new NoteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.endsWith("/notes")) {
            listNotes(request, response);
        } else if (uri.endsWith("/notes/add")) {
            showAddForm(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        noteRepository.add(newNote);

        response.sendRedirect(request.getContextPath() + "/notes");
    }

    private void listNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Note> notes = noteRepository.getAll();
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}

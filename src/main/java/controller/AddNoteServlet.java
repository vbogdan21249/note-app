package controller;

import repository.NoteRepository;
import model.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/add")
public class AddNoteServlet extends HttpServlet {
    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        noteRepository = new NoteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
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
}

package co.com.soundMusic.Artista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Medina Pelaez
 */
@WebServlet(name = "controladorArtista", urlPatterns = {"/controladorArtista"})
public class controladorArtista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorArtista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorArtista at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = (String) request.getParameter("opcion");
        if (opcion != null) {
            if (opcion.equals("listarArtistas")) {
                try {
                    mostrarPaginaArtista(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorArtista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("borrar")) {
                String statusArtista = (String) request.getParameter("statusArtista");

                ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();
                try {
                    daoArtista.eliminarArtista(statusArtista);
                    List<Artista> lstArtista = daoArtista.obtenerArtistas();
                    request.setAttribute("lstArtista", lstArtista);
                    RequestDispatcher vista = request.getRequestDispatcher("/artista.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorArtista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("crearArtista")) {

            }
            if (opcion.equals("editar")) {

            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mostrarPaginaArtista(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();

        List<Artista> lstArtista = daoArtista.obtenerArtistas();
        request.setAttribute("lstArtista", lstArtista);
        RequestDispatcher vista = request.getRequestDispatcher("/artista.jsp");
        vista.forward(request, response);
    }

}

package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;
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
                int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));

                ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();
                try {
                    daoArtista.eliminarArtista(statusArtista, idArtista);
                    List<Artista> lstArtista = daoArtista.obtenerArtistas();
                    request.setAttribute("lstArtista", lstArtista);
                    RequestDispatcher vista = request.getRequestDispatcher("/artista.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorArtista.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        String operacion = request.getParameter("operacion");

        if (operacion != null) {
            if (operacion.equalsIgnoreCase("crear")) {
                try {
                    crearArtista(request, response);
                    actulizarLstArtista(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorArtista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (operacion.equals("editar")) {
                int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));
                //editarArtista(request, response, idArtista);
            }
        }
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

    private void actulizarLstArtista(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();

        List<Artista> lstArtista = daoArtista.obtenerArtistas();
        request.setAttribute("lstArtista", lstArtista);
    }

    private void crearArtista(HttpServletRequest request, HttpServletResponse response) {

        try {
            int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            String nombreArtistico = request.getParameter("nombreArtistico");
            String genero = request.getParameter("genero");
            Date fechaNacimiento= Date.valueOf(request.getParameter("fechaNacimiento"));
            //Date fechaCreacion = Date.valueOf(fechaHora.now());
            Date fechaCreacion = Date.valueOf(LocalDate.now());
            String status = "A";

            //CODIGO PARA EL CONTACTO!!!!!
            //CODIGOOOOO
            //
            Contacto contacto = new Contacto();

            String[] datos = {primerNombre, segundoNombre,
                primerApellido, segundoApellido, nombreArtistico, genero, status};
            Date[] fechas = {fechaNacimiento, fechaCreacion};

            Artista artista = new Artista(idArtista, datos, fechas, contacto);
            ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();
            daoArtista.crearArtista(artista);
        } catch (SQLException ex) {
            Logger.getLogger(controladorArtista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

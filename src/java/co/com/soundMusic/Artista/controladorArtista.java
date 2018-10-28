package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class controladorArtista extends HttpServlet {

    List<Artista> lstArtistasp;

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
                mostrarPaginaArtista(request, response);
            }
            if (opcion.equals("borrar")) {
                int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));
                ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
                daoArtista.eliminarArtista("I", idArtista);
                mostrarPaginaArtista(request, response);
            }
            if (opcion.equals("crearArtista")) {
                actualizarDatosFormulario(request);
                RequestDispatcher vista
                        = request.getRequestDispatcher("/registrarArtista.jsp");
                vista.forward(request, response);
            }
            if (opcion.equals("editar")) {
                actualizarDatosFormulario(request);
                int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));
                for (Artista artista : lstArtistasp) {
                    if (artista.getIdArtista() == idArtista) {
                        request.setAttribute("artista", artista);
                    }
                }

                RequestDispatcher vista = request.getRequestDispatcher("modificarArtista.jsp");
                vista.forward(request, response);
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
                crearArtista(request, response);
                actulizarLstArtista(request, response);
            }
            if (operacion.equals("editar")) {
                int idArtista = Integer.parseInt((String) request.getParameter("idArtista"));
                editarArtista(request, response, idArtista);
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

    private void mostrarPaginaArtista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
        lstArtistasp = daoArtista.obtenerArtistas();
        request.setAttribute("lstArtista", lstArtistasp);
        RequestDispatcher vista = request.getRequestDispatcher("/artista.jsp");

        vista.forward(request, response);
    }

    private void actulizarLstArtista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);

        List<Artista> lstArtista = daoArtista.obtenerArtistas();
        request.setAttribute("lstArtista", lstArtista);
    }

    private void crearArtista(HttpServletRequest request, HttpServletResponse response) {
        Pais pais = obtenerPais(Integer.parseInt(request.getParameter("pais")), " ");
        Ciudad ciudad = obtenerCiudad(Integer.parseInt(request.getParameter("ciudad")),
                " ", pais);

        String celular = request.getParameter("celular");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String barrio = request.getParameter("barrio");
        String email = request.getParameter("email");

        String[] datosContacto = {celular, telefono, direccion, barrio, email};

        int idCiudad = Integer.parseInt(request.getParameter("idCiudad"));

        Contacto contacto = new Contacto(0, datosContacto, idCiudad);
        ContactoDaoImpl daoContacto = new ContactoDaoImpl(true);
        daoContacto.crearContacto(contacto);

        String primerNombre = request.getParameter("nombre1");
        String segundoNombre = request.getParameter("nombre2");
        String primerApellido = request.getParameter("apellido1");
        String segundoApellido = request.getParameter("apellido2");
        String nombreArtistico = request.getParameter("nomArtista");
        String genero = request.getParameter("sexo");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNac"));
        Date fechaCreacion = Date.valueOf(LocalDate.now());
        String status = "A";

        String[] datosArtista = {primerNombre, segundoNombre,
            primerApellido, segundoApellido, nombreArtistico, genero, status, null};
        Date[] fechasArtista = {fechaNacimiento, fechaCreacion};

        Artista artista = new Artista(0, datosArtista, fechasArtista, daoContacto.getUltimoIdContacto());
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
        daoArtista.crearArtista(artista);
    }

    private void editarArtista(HttpServletRequest request, HttpServletResponse response, int idArtista) throws IOException, NumberFormatException, ServletException {
        Pais pais = obtenerPais(Integer.parseInt(request.getParameter("idPais")),
                request.getParameter("nombrePais"));
        Ciudad ciudad = obtenerCiudad(Integer.parseInt(request.getParameter("idCiudad")),
                request.getParameter("nombreCiudad"), pais);

        int idContacto = Integer.parseInt(request.getParameter("idContacto"));
        String celular = request.getParameter("celular");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String barrio = request.getParameter("barrio");
        String email = request.getParameter("email");

        String[] datosContacto = {celular, telefono, direccion, barrio, email};

        int idCiudad = Integer.parseInt(request.getParameter("idCiudad"));
        Contacto contacto = new Contacto(idContacto, datosContacto, idCiudad);
        ContactoDaoImpl daoContacto = new ContactoDaoImpl(true);
        daoContacto.actualizarContacto(contacto);

        //Capturar los valores que el artista escribio                        
        String primerNombre = request.getParameter("primerNombre");
        String segundoNombre = request.getParameter("segundoNombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String nombreArtistico = request.getParameter("nombreArtistico");
        String genero = request.getParameter("genero");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
        Date fechaCreacion = Date.valueOf(LocalDate.now());
        String status = "A";

        String[] datosArtista = {primerNombre, segundoNombre,
            primerApellido, segundoApellido, nombreArtistico, genero, status, null};
        Date[] fechasArtista = {fechaNacimiento, fechaCreacion};

        Artista artista = new Artista(idArtista, datosArtista, fechasArtista,
                idContacto);

        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
        daoArtista.actualizarArtista(artista);

        mostrarPaginaArtista(request, response);
    }

    private Pais obtenerPais(int idPais, String nombrePais) {
        PaisDaoImpl paisDao = new PaisDaoImpl(true);

        if (idPais == 0) {
            paisDao.crearPais(new Pais(idPais, nombrePais));
        }
        return paisDao.obtenerPais(idPais);

    }

    private Ciudad obtenerCiudad(int idCiudad, String nombreCiudad, Pais pais) {
        CiudadDaoImpl ciudadDao = new CiudadDaoImpl(true);

        if (idCiudad == 0) {
            ciudadDao.crearCiudad(new Ciudad(idCiudad, nombreCiudad, pais.getIdPais()));
        }
        return ciudadDao.obtenerCiudad(idCiudad);
    }

    private void actualizarDatosFormulario(HttpServletRequest request) {
        PaisDaoImpl daoPais = new PaisDaoImpl(true);
        List<Pais> lstPais = daoPais.obtenerPaises();
        request.setAttribute("lstPais", lstPais);

        CiudadDaoImpl ciudadDao = new CiudadDaoImpl(true);
        List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
        request.setAttribute("lstCiudad", lstCiudad);
    }
}

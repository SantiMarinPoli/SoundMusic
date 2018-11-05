/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.Artista.ArtistaDaoImpl;
import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.LogAuditoria.LogAuditoria;
import co.com.soundMusic.LogAuditoria.LogAuditoriaDaoImpl;
import co.com.soundMusic.Login.Usuario.Usuario;
import co.com.soundMusic.Seguridad.Permisos.Permisos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author medinas
 */
public class controladorAlbum extends HttpServlet {

    List<Album> lstAlbump;
    int identificacion;

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
            out.println("<title>Servlet controladorAlbum</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorAlbum at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher vista;
        switch (opcion) {
            case "listarAlbumes":
                mostrarPaginaAlbum(request, response);
                break;
            case "borrar":
                actualizarDatosFormulario(request);
                vista = request.getRequestDispatcher("/registrarAlbum.jsp");
                vista.forward(request, response);
                break;
            case "crearAlbum":
                actualizarDatosFormulario(request);
                vista = request.getRequestDispatcher("/registrarAlbum.jsp");
                vista.forward(request, response);
                break;
            case "editar":
                break;
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

        switch (operacion) {
            case "crear":
                crearAlbum(request, response);
                //ingresarLogAuditoria(UsuarioId(request, response), 4);
                request.setAttribute("lstAlbum", lstAlbump);
                request.getRequestDispatcher("/album.jsp").forward(request, response);
                break;
            case "editar":
                break;
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

    private void mostrarPaginaAlbum(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlbumDaoImpl daoAlbum = new AlbumDaoImpl(true);

        lstAlbump = daoAlbum.obtenerAlbumes();
        request.setAttribute("lstAlbum", lstAlbump);
        request.getRequestDispatcher("/album.jsp").forward(request, response);
    }

    private void actualizarDatosFormulario(HttpServletRequest request) {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
        List<Artista> lstArtistas = daoArtista.obtenerArtistas();
        request.setAttribute("lstArtistas", lstArtistas);

        CiudadDaoImpl ciudadDao = new CiudadDaoImpl(true);
        List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
        request.setAttribute("lstCiudad", lstCiudad);
    }

    private void crearAlbum(HttpServletRequest request, HttpServletResponse response) {
        Album album = new Album();
        album.setNombre(request.getParameter("nomAlbum"));
        album.setNumeroCanciones(Integer.parseInt(request.getParameter("numCanciones")));
        String fechaFinalizacion = validarFecha(request.getParameter("fechaLanzamiento"));
        if (fechaFinalizacion != null) {
            album.setFechaFinalizacion(Date.valueOf(fechaFinalizacion));
        }
        album.setRutaImagen(request.getParameter("nuevaFoto"));

        if (album.getRutaImagen().equalsIgnoreCase("")) {
            album.setRutaImagen("img/album/default/no-image.png");
        }
        String prueba=request.getParameter("nomArtista");
        String[] datosArtista = prueba.split("-");

        album.getArtista().setIdArtista(Integer.parseInt(datosArtista[0]));
        album.getArtista().setNombreArtistico(datosArtista[1]);
        album.getCiudad().setIdCiudad(Integer.parseInt(request.getParameter("ciudadAlbum")));
        AlbumDaoImpl daoAlbum = new AlbumDaoImpl(true);
        album.setIdAlbum(daoAlbum.crearAlbum(album));
        lstAlbump.add(album);
    }

    private int UsuarioId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = 0;
        response.setContentType("text/html");
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        HttpSession session = request.getSession(false);
        if (session != null) {
            idUsuario = (int) session.getAttribute("usuarioId");
            return idUsuario;
        }
        return idUsuario;
    }

    private void ingresarLogAuditoria(int idUsuario, int idPermisos) {
        LogAuditoriaDaoImpl daoLogAuditoria = new LogAuditoriaDaoImpl(true);
        daoLogAuditoria.crearLog(new LogAuditoria(0, new Usuario(idUsuario), new Permisos(idPermisos)));
    }

    private String validarFecha(String parameter) {
        if (parameter.trim().equals("")) {
            parameter = null;
        }
        return parameter;
    }
}

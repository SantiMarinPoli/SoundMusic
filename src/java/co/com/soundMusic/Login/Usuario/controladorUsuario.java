/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.soundMusic.Login.Usuario;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLogin;
import co.com.soundMusic.Seguridad.Perfiles.Perfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class controladorUsuario extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        
        String nomUsuario = request.getParameter("nomUsuario");
        String password = request.getParameter("password");
        
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
        
        if (daoUsuario.ingresarUsuario(nomUsuario, password)) {
            
            HttpSession objSesion = request.getSession(true);
            objSesion.setAttribute("nomUsuario", nomUsuario);
            
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
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
            if (opcion.equals("listarUsuarios")) {
                try {
                    mostrarPaginaUsuario(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("borrar")) {
                
            }
            if (opcion.equals("crearUsuario")) {
                try {
                    PaisDaoImpl paisDao = new PaisDaoImpl();
                    CiudadDaoImpl ciudadDao = new CiudadDaoImpl();
                    List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
                    List<Pais> lstPais = paisDao.obtenerPaises();
                    
                    request.setAttribute("lstPais", lstPais);
                    request.setAttribute("lstCiudad", lstCiudad);
                    
                    RequestDispatcher vista = request.getRequestDispatcher("/registrarUsuario.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        String operacion = request.getParameter("operacion");
        
        if (operacion != null) {
            if (operacion.equalsIgnoreCase("crear")) {
                try {
                    crearUsuario(request, response);
                    actulizarLstUsuario(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (operacion.equals("editar")) {
                int idUsuario = Integer.parseInt((String) request.getParameter("idUsuario"));
                editarArtista(request, response, idUsuario);
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

    private void mostrarPaginaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
        
        List<Usuario> lstUsuario = daoUsuario.obtenerUsuarios();
        request.setAttribute("lstUsuario", lstUsuario);
        RequestDispatcher vista = request.getRequestDispatcher("/usuario.jsp");
        
        vista.forward(request, response);
    }
    
    private void crearUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int idUsuario = Integer.parseInt(request.getParameter("cod"));
        String primerNombre = request.getParameter("");
        String segundoNombre = request.getParameter("");
        String primerApellido = request.getParameter("");
        String segundoApellido = request.getParameter("");
        Date fechaCreacion = Date.valueOf(request.getParameter(""));
        String satus = request.getParameter("");
        Perfil perfil = null;
        UsuarioLogin usuarioLogin = null;
        Contacto contacto = null;
        
        Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaCreacion, satus, perfil, usuarioLogin, contacto);
        
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
        daoUsuario.crearUsuario(usuario);
        
    }
    
    private void actulizarLstUsuario(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void editarArtista(HttpServletRequest request, HttpServletResponse response, int idUsuario)
            throws IOException, NumberFormatException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

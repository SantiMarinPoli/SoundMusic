package co.com.soundMusic.Login.Usuario;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLogin;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLoginDaoImpl;
import co.com.soundMusic.Seguridad.Perfiles.Perfil;
import co.com.soundMusic.Seguridad.Perfiles.PerfilDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        String nomUsuario = request.getParameter("nomUsuario");
        String password = request.getParameter("password");
        
        Usuario usuario = new Usuario();
        
        if (usuario.ingresarUsuario(nomUsuario, password)) {
            
            HttpSession objSesion = request.getSession(true);
            objSesion.setAttribute("nomUsuario", nomUsuario);
            
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp");
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
            if (opcion.equals("listarUsuarios")) {
                try {
                    mostrarPaginaUsuario(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("borrar")) {
                int idUsuario = Integer.parseInt((String) request.getParameter("IdUsuario"));
                
                UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
                try {
                    daoUsuario.eliminarUsuario("I", idUsuario);
                    List<Usuario> lstUsuario = daoUsuario.obtenerUsuarios();
                    request.setAttribute("lstUsuario", lstUsuario);
                    RequestDispatcher vista = request.getRequestDispatcher("/usuario.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("crearUsuario")) {
                try {
                    PaisDaoImpl daoPais = new PaisDaoImpl();
                    List<Pais> lstPais = daoPais.obtenerPaises();
                    request.setAttribute("lstPais", lstPais);
                    
                    CiudadDaoImpl ciudadDao = new CiudadDaoImpl();
                    List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
                    request.setAttribute("lstCiudad", lstCiudad);
                    
                    PerfilDaoImpl daoPerfil = new PerfilDaoImpl();
                    List<Perfil> lstPerfil = daoPerfil.obtenerPerfiles();
                    request.setAttribute("lstPerfil", lstPerfil);
                    
                    RequestDispatcher vista = request.getRequestDispatcher("/registrarUsuario.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("editar")) {
                try {
                    PaisDaoImpl daoPais = new PaisDaoImpl();
                    List<Pais> lstPais = daoPais.obtenerPaises();
                    request.setAttribute("lstPais", lstPais);
                    
                    CiudadDaoImpl ciudadDao = new CiudadDaoImpl();
                    List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
                    request.setAttribute("lstCiudad", lstCiudad);
                    
                    PerfilDaoImpl daoPerfil = new PerfilDaoImpl();
                    List<Perfil> lstPerfil = daoPerfil.obtenerPerfiles();
                    request.setAttribute("lstPerfil", lstPerfil);
                    
                    int identificacion = Integer.parseInt((String) request.getParameter("IdUsuario"));
                    UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
                    Usuario usuario = daoUsuario.obtenerUsuario(identificacion);
                    request.setAttribute("usuario", usuario);
                    
                    RequestDispatcher vista = request.getRequestDispatcher("modificarUsuario.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void actulizarLstUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
        
        List<Usuario> lstUsuario = daoUsuario.obtenerUsuarios();
        request.setAttribute("lstUsuario", lstUsuario);
        
        RequestDispatcher vista = request.getRequestDispatcher("/usuario.jsp");
        vista.forward(request, response);
    }
    
    private void crearUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");
        
        UsuarioLogin usuarioLogin = new UsuarioLogin(0, nombreUsuario, contrasena);
        UsuarioLoginDaoImpl daoUsuarioLogin = new UsuarioLoginDaoImpl();
        daoUsuarioLogin.crearUsuarioLogin(usuarioLogin);
        usuarioLogin.setIdUsuarioLogin(daoUsuarioLogin.getUltimmoIdUsuarioLogin());
        
        String celular = request.getParameter("celular");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String barrio = request.getParameter("barrio");
        String email = request.getParameter("email");
        int idCiudad = Integer.parseInt(request.getParameter("IdCiudad"));
        
        String[] datosContacto = {celular, telefono, direccion, barrio, email};
        
        Contacto contacto = new Contacto(0, datosContacto, idCiudad);
        ContactoDaoImpl daoCiudad = new ContactoDaoImpl();
        daoCiudad.crearContacto(contacto);
        contacto.setIdContacto(daoCiudad.getUltimoIdContacto());
        
        String primerNombre = request.getParameter("primerNombre");
        String segundoNombre = request.getParameter("segundoNombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        Date fechaCreacion = Date.valueOf(LocalDate.now());
        String satus = request.getParameter("A");
        int idPerfil = Integer.parseInt((String) request.getParameter("idPerfil"));
        
        Usuario usuario = new Usuario(0, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaCreacion,
                satus, idPerfil, usuarioLogin.getIdUsuarioLogin(), contacto.getIdContacto());
        
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
        daoUsuario.crearUsuario(usuario);
    }
    
    private void editarArtista(HttpServletRequest request, HttpServletResponse response, int idUsuario)
            throws IOException, NumberFormatException, ServletException {
        try {
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasena = request.getParameter("contrasena");
            int idUsuarioLogin = Integer.parseInt(request.getParameter("idUsuarioLogin"));
            
            UsuarioLogin usuarioLogin = new UsuarioLogin(idUsuarioLogin, nombreUsuario, contrasena);
            
            String celular = request.getParameter("celular");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String barrio = request.getParameter("barrio");
            String email = request.getParameter("email");
            
            int idContacto = Integer.parseInt(request.getParameter("idContacto"));
            int idCiudad = Integer.parseInt(request.getParameter("idCiudad"));
            
            String[] datosContacto = {celular, telefono, direccion, barrio, email};
            
            Contacto contacto = new Contacto(idContacto, datosContacto, idCiudad);
            
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");            
            
            int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
            
            Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, null, "A",
                    idPerfil, idUsuarioLogin, contacto.getIdContacto());
            
            ContactoDaoImpl daoContacto = new ContactoDaoImpl();
            UsuarioLoginDaoImpl daoUsuarioLogin = new UsuarioLoginDaoImpl();
            UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl();
            
            daoContacto.actualizarContacto(contacto);
            daoUsuarioLogin.actualizarUsuarioLogin(usuarioLogin);
            daoUsuario.actualizarUsuario(usuario);
            mostrarPaginaUsuario(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
}

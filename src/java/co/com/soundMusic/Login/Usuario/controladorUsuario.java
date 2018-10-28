package co.com.soundMusic.Login.Usuario;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import co.com.soundMusic.LogAuditoria.LogAuditoria;
import co.com.soundMusic.LogAuditoria.LogAuditoriaDaoImpl;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLogin;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLoginDaoImpl;
import co.com.soundMusic.Seguridad.Perfiles.Perfil;
import co.com.soundMusic.Seguridad.Perfiles.PerfilDaoImpl;
import co.com.soundMusic.Seguridad.Permisos.Permisos;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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

    List<Usuario> lstUsuariop;

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
                mostrarPaginaUsuario(request, response);
            }
            if (opcion.equals("borrar")) {
                int idUsuario = Integer.parseInt((String) request.getParameter("IdUsuario"));
                UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(true);
                daoUsuario.eliminarUsuario("I", idUsuario);
                mostrarPaginaUsuario(request, response);

            }
            if (opcion.equals("crearUsuario")) {
                actualizarDatosFormulario(request);
                RequestDispatcher vista = request.getRequestDispatcher("/registrarUsuario.jsp");
                vista.forward(request, response);
            }
            if (opcion.equals("editar")) {
                actualizarDatosFormulario(request);
                int identificacion = Integer.parseInt((String) request.getParameter("IdUsuario"));
                for (Usuario usuario : lstUsuariop) {
                    if (usuario.getIdUsuario() == identificacion) {
                        request.setAttribute("usuarioEditar", usuario);
                        break;
                    }
                }
                RequestDispatcher vista = request.getRequestDispatcher("modificarUsuario.jsp");
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
                crearUsuario(request);
                //ingresarLogAuditoria(UsuarioId(request, response), 3);
                mostrarPaginaUsuario(request, response);
            }
            if (operacion.equals("editar")) {
                int idUsuario = Integer.parseInt((String) request.getParameter("idUsuario"));
                editarUsuario(request, response, idUsuario);
                // ingresarLogAuditoria(UsuarioId(request, response), 4);
                mostrarPaginaUsuario(request, response);
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
            throws ServletException, IOException {
        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(true);
        lstUsuariop = daoUsuario.obtenerUsuarios();
        request.setAttribute("lstUsuario", lstUsuariop);
        request.getRequestDispatcher("/usuario.jsp").forward(request, response);
    }

    private void crearUsuario(HttpServletRequest request)
            throws ServletException, IOException {
        UsuarioLogin usuarioLogin = crearUsuarioLogin(request);
        Contacto contacto = crearContacto(request);
        Perfil perfil = obtenerPerfil(request);
        Usuario usuario = new Usuario();

        usuario.setPrimerNombre(request.getParameter("nombre1"));
        usuario.setSegundoNombre(request.getParameter("nombre2"));
        usuario.setPrimerApellido(request.getParameter("apellido1"));
        usuario.setSegundoApellido(request.getParameter("apellido2"));
        usuario.setFechaCreacion(Date.valueOf(LocalDate.now()));
        usuario.setStatus("A");
        usuario.setGenero(request.getParameter("sexo"));
        usuario.setUsuarioLogin(usuarioLogin);
        usuario.setContacto(contacto);
        usuario.setPerfil(perfil);

        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(true);
        daoUsuario.crearUsuario(usuario);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response, int idUsuario)
            throws IOException, NumberFormatException, ServletException {
        UsuarioLogin usuarioLogin = editarUsuarioLogin(request);
        Contacto contacto = editarContacto(request);
        Perfil perfil = obtenerPerfil(request);
        Usuario usuario = new Usuario();

        usuario.setPrimerNombre(request.getParameter("nombre1"));
        usuario.setSegundoNombre(request.getParameter("nombre2"));
        usuario.setPrimerApellido(request.getParameter("apellido1"));
        usuario.setSegundoApellido(request.getParameter("apellido2"));
        usuario.setFechaCreacion(Date.valueOf(LocalDate.now()));
        usuario.setStatus("A");
        usuario.setGenero(request.getParameter("sexo"));
        usuario.setUsuarioLogin(usuarioLogin);
        usuario.setContacto(contacto);
        usuario.setPerfil(perfil);

        UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(true);
        
        daoUsuario.actualizarUsuario(usuario);

    }

    private void actualizarDatosFormulario(HttpServletRequest request) {
        PaisDaoImpl daoPais = new PaisDaoImpl(true);
        List<Pais> lstPais = daoPais.obtenerPaises();
        request.setAttribute("lstPais", lstPais);

        CiudadDaoImpl ciudadDao = new CiudadDaoImpl(true);
        List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
        request.setAttribute("lstCiudad", lstCiudad);

        PerfilDaoImpl daoPerfil = new PerfilDaoImpl(true);
        List<Perfil> lstPerfil = daoPerfil.obtenerPerfiles();
        request.setAttribute("lstPerfil", lstPerfil);
    }

    private void ingresarLogAuditoria(int idUsuario, int idPermisos) {
        LogAuditoriaDaoImpl daoLogAuditoria = new LogAuditoriaDaoImpl(true);
        daoLogAuditoria.crearLog(new LogAuditoria(0, new Usuario(idUsuario), new Permisos(idPermisos)));
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

    private Usuario obtenerUsuarioAEditar(List<Usuario> lstUsuario, int idUsuario) {
        Usuario usuario = new Usuario();

        for (int i = 1; i < lstUsuario.size(); i++) {
            if (lstUsuario.get(i).getIdUsuario() == idUsuario) {
                usuario = lstUsuario.get(i);
                break;
            }
        }
        return usuario;
    }

    private UsuarioLogin crearUsuarioLogin(HttpServletRequest request) {
        UsuarioLogin usuarioLogin = new UsuarioLogin();
        usuarioLogin.setNombreUsuario(request.getParameter("nomUsuario"));
        usuarioLogin.setContrasena(request.getParameter("pass1"));

        UsuarioLoginDaoImpl daoUsuarioLogin = new UsuarioLoginDaoImpl(true);
        daoUsuarioLogin.crearUsuarioLogin(usuarioLogin);

        usuarioLogin.setIdUsuarioLogin(daoUsuarioLogin.getUltimmoIdUsuarioLogin());

        return usuarioLogin;
    }

    private Contacto crearContacto(HttpServletRequest request) {
        Contacto contacto = new Contacto();
        contacto.setCelular(request.getParameter("numCel"));
        contacto.setTelefono(request.getParameter("numTel"));
        contacto.setDireccion(request.getParameter("direccion"));
        contacto.setBarrio(request.getParameter("barrio"));
        contacto.setEmail(request.getParameter("email"));
        contacto.getCiudad().setIdCiudad(Integer.parseInt(request.getParameter("ciudad")));

        ContactoDaoImpl daoContacto = new ContactoDaoImpl(true);
        daoContacto.crearContacto(contacto);
        contacto.setIdContacto(daoContacto.getUltimoIdContacto());

        return contacto;
    }

    private Perfil obtenerPerfil(HttpServletRequest request) {
        PerfilDaoImpl daoPerfil = new PerfilDaoImpl(true);
        Perfil perfil = daoPerfil.obtenerPerfil(Integer.parseInt((String) request.getParameter("perfil")));
        return perfil;
    }

    private UsuarioLogin editarUsuarioLogin(HttpServletRequest request) {
        UsuarioLogin usuarioLogin = new UsuarioLogin();
        usuarioLogin.setIdUsuarioLogin(Integer.parseInt(request.getParameter("idUsuarioLogin")));
        usuarioLogin.setNombreUsuario(request.getParameter("nomUsuario"));
        usuarioLogin.setContrasena(request.getParameter("pass1"));

        UsuarioLoginDaoImpl daoUsuarioLogin = new UsuarioLoginDaoImpl(true);
        daoUsuarioLogin.actualizarUsuarioLogin(usuarioLogin);

        return usuarioLogin;
    }

    private Contacto editarContacto(HttpServletRequest request) {
        Contacto contacto = new Contacto();
        contacto.setIdContacto(Integer.parseInt(request.getParameter("idContacto")));
        contacto.setCelular(request.getParameter("numCel"));
        contacto.setTelefono(request.getParameter("numTel"));
        contacto.setDireccion(request.getParameter("direccion"));
        contacto.setBarrio(request.getParameter("barrio"));
        contacto.setEmail(request.getParameter("email"));
        contacto.getCiudad().setIdCiudad(Integer.parseInt(request.getParameter("ciudad")));

        ContactoDaoImpl daoContacto = new ContactoDaoImpl(true);
        daoContacto.actualizarContacto(contacto);

        return contacto;
    }
}

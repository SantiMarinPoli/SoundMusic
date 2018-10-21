package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividadDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusora;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusoraDaoImpl;
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

/**
 *
 * @author Santiago Medina Pelaez
 */
public class controladorEmpresaDifusora extends HttpServlet {

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
            out.println("<title>Servlet controladorEmpresaDifusora</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorEmpresaDifusora at " + request.getContextPath() + "</h1>");
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
            if (opcion.equals("listarEmpresa")) {
                try {
                    mostrarPaginaEmpresas(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorEmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("borrar")) {
                int idEmpresa = Integer.parseInt((String) request.getParameter("idEmpresa"));
                EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();
                try {
                    daoEmpresa.eliminarEmpresaDifusora("I", idEmpresa);
                    List<EmpresaDifusora> lstEmpresas = daoEmpresa.obtenerEmpresasDifusoras();
                    request.setAttribute("lstEmpresas", lstEmpresas);
                    RequestDispatcher vista = request.getRequestDispatcher("/empresa.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorEmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (opcion.equals("crearEmpresa")) {
                try {
                    PaisDaoImpl daoPais = new PaisDaoImpl();
                    List<Pais> lstPais = daoPais.obtenerPaises();
                    request.setAttribute("lstPais", lstPais);

                    CiudadDaoImpl ciudadDao = new CiudadDaoImpl();
                    List<Ciudad> lstCiudad = ciudadDao.obtenerCiudades();
                    request.setAttribute("lstCiudad", lstCiudad);

                    TipoEmpresaDifusoraDaoImpl daoTipoEmpresa = new TipoEmpresaDifusoraDaoImpl();
                    List<TipoEmpresaDifusora> lstTipoEmpresa = daoTipoEmpresa.obtenerTipoEmpresaDifusora();
                    request.setAttribute("lstTipoEmpresa", lstTipoEmpresa);

                    RequestDispatcher vista = request.getRequestDispatcher("/registrarEmpresa.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorEmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
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

                    TipoEmpresaDifusoraDaoImpl daoTipoEmpresa = new TipoEmpresaDifusoraDaoImpl();
                    List<TipoEmpresaDifusora> lstTipoEmpresa = daoTipoEmpresa.obtenerTipoEmpresaDifusora();
                    request.setAttribute("lstTipoEmpresa", lstTipoEmpresa);

                    int idEmpresaDifusora = Integer.parseInt((String) request.getParameter("idEmpresa"));
                    EmpresaDifusoraDaoImpl daoEmpresaDifusora = new EmpresaDifusoraDaoImpl();
                    EmpresaDifusora empresaDfifusora = daoEmpresaDifusora.obtenerEmpresaDifusora(idEmpresaDifusora);
                    request.setAttribute("empresaDfifusora", empresaDfifusora);

                    RequestDispatcher vista = request.getRequestDispatcher("modificarEmpresa.jsp");
                    vista.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Excepción: " + ex.getMessage());
                    Logger.getLogger(controladorEmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
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
                    crearEmpresaDifusora(request, response);
                    actualizarLstEmpresa(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorEmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (operacion.equalsIgnoreCase("editar")) {
                int idEmpresaDifusora = Integer.parseInt((String) request.getParameter("idEmpresa"));
                editarEmpresaDifusora(request, response, idEmpresaDifusora);
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

    private void mostrarPaginaEmpresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();

        List<EmpresaDifusora> lstEmpresas = daoEmpresa.obtenerEmpresasDifusoras();
        request.setAttribute("lstEmpresas", lstEmpresas);
        RequestDispatcher vista = request.getRequestDispatcher("/empresa.jsp");

        vista.forward(request, response);
    }

    private void actualizarLstEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();

        List<EmpresaDifusora> lstEmpresas = daoEmpresa.obtenerEmpresasDifusoras();
        request.setAttribute("lstEmpresas", lstEmpresas);

        RequestDispatcher vista = request.getRequestDispatcher("/empresa.jsp");
        vista.forward(request, response);
    }

    private void crearEmpresaDifusora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        float costo = Float.parseFloat((String) request.getParameter("valorOp"));

        CostoActividad costoOperacion = new CostoActividad(0, costo, Date.valueOf(LocalDate.now()), null);
        CostoActividadDaoImpl daoCostoActividad = new CostoActividadDaoImpl();
        daoCostoActividad.crearCostoActividad(costoOperacion);
        costoOperacion.setIdCostoActividad(daoCostoActividad.getUltimoIdCostoActividad());

        String telefono = request.getParameter("numFijo");
        String email = request.getParameter("correo");
        int idCiudad = Integer.parseInt(request.getParameter("IdCiudad"));

        String[] datosContacto = {null, telefono, null, null, email};

        Contacto contacto = new Contacto(0, datosContacto, idCiudad);
        ContactoDaoImpl daoCiudad = new ContactoDaoImpl();
        daoCiudad.crearContacto(contacto);
        contacto.setIdContacto(daoCiudad.getUltimoIdContacto());

        String nombre = request.getParameter("nomEmpresa");
        Date fechaCreacion = Date.valueOf(LocalDate.now());
        String rutaImagen = request.getParameter("rutaImagenemprea");
        int idTipoActividad = Integer.parseInt((String) request.getParameter("idTipoActividad"));

        EmpresaDifusora empresaDifusora = new EmpresaDifusora(0, nombre,
                fechaCreacion, null, "A", rutaImagen, idTipoActividad, contacto.getIdContacto(),
                costoOperacion.getIdCostoActividad());

        EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();
        daoEmpresa.crearEmpresaDifusora(empresaDifusora);
    }

    private void editarEmpresaDifusora(HttpServletRequest request, HttpServletResponse response, int idEmpresaDifusora)
            throws IOException, NumberFormatException, ServletException {
        try {
            float costo = Float.parseFloat((String) request.getParameter("costoPorActividad"));
            int idCostoOperacion = Integer.parseInt((String) request.getParameter("idCostoOperacion"));

            CostoActividad costoOperacion = new CostoActividad(idCostoOperacion, costo, null, null);

            String telefono = request.getParameter("telefonoEmpresa");
            String email = request.getParameter("emailEmpresa");

            int idContacto = Integer.parseInt(request.getParameter("idContacto"));
            int idCiudad = Integer.parseInt(request.getParameter("idCiudad"));

            String[] datosContacto = {null, telefono, null, null, email};

            Contacto contacto = new Contacto(idContacto, datosContacto, idCiudad);

            String nombre = request.getParameter("nombreEmpresa");
            String rutaImagen = request.getParameter("rutaImagenemprea");
            int idTipoActividad = Integer.parseInt((String) request.getParameter("idTipoActividad"));

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora,
                    nombre, null, null, "A", rutaImagen, idTipoActividad, contacto.getIdContacto(),
                    idCostoOperacion);

            ContactoDaoImpl daoContacto = new ContactoDaoImpl();
            CostoActividadDaoImpl daoCostoOperacion = new CostoActividadDaoImpl();
            EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();

            daoContacto.actualizarContacto(contacto);
            daoCostoOperacion.actualizarCostoActividad(costoOperacion);
            daoEmpresa.actualizarEmpresaDifusora(empresaDifusora);
            mostrarPaginaEmpresas(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}

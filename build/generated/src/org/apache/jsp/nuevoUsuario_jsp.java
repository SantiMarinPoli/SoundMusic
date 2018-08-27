package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nuevoUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/navbar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>SoundMusic</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"icon\" type=\"img/png\" href=\"icon/musica.png\"/>\r\n");
      out.write("        <link href=\"style/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"bootstrap/CSS/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("  <a class=\"navbar-brand\" href=\"#\">Music Sound</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("  <div class=\"collapse navbar-collapse nav\" id=\"navbarNavDropdown\">\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link \" href=\"home.jsp\">Home</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"usuario.jsp\">Usuarios</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"empresa.jsp\">Empresas Difunsoras</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item \">\n");
      out.write("          <a class=\"nav-link\" href=\"artista.jsp\">Artistas</a>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("    </ul>\n");
      out.write("      <div class=\"row\">\n");
      out.write("          <div class=\"col display-flex\">\n");
      out.write("              <a href =\"login.jsp\" class=\"btn btn-danger\" type=\"button\" click=\"cerrarSesion()\">Salir</a>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container main-container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-2\"></div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-md-8\">\r\n");
      out.write("\r\n");
      out.write("                    <h3>Registro de Usuario</h3>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <br>\r\n");
      out.write("\r\n");
      out.write("                    <form>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>Identificacion</label>\r\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"textId\" placeholder=\"Ingrese el numero Idenficacion\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-row\">\r\n");
      out.write("                            <div class=\"col\">\r\n");
      out.write("                                <label>Nombre</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"textName\" placeholder=\"Ingresar el nombre del operador\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col\">\r\n");
      out.write("                                <label>Apellido</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"textLastname\" placeholder=\"Ingresar el apellido del operador\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <label>Genero</label>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <div class=\"form-check-inline\">\r\n");
      out.write("                                <input class=\"form-check-input\" type=\"radio\" name=\"sexo\" id=\"textSex1\" value=\"Masculino\">\r\n");
      out.write("                                <label class=\"form-check-label\" for=\"textSex1\">Masculino</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\" form-check-inline\">\r\n");
      out.write("                                <input class=\"form-check-input\" type=\"radio\" name=\"sexo\" id=\"textSex2\" value=\"Femenino\">\r\n");
      out.write("                                <label class=\"form-check-label\" for=\"textSex2\">Femenino</label>\r\n");
      out.write("                            </div>                         \r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>Fecha de Nacimiento</label>\r\n");
      out.write("                            <input type=\"date\" name=\"fechaNac\" id=\"birthDate\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>Nombre del Usuario</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"textNameUser\" placeholder=\"Ingresar el nuevo usuario del operador\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-row\">\r\n");
      out.write("                            <div class=\"col\">\r\n");
      out.write("                                <label>Contraseña</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"textPass\" placeholder=\"Password\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col\">\r\n");
      out.write("                                <label>Repita Contraseña</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"textRepeatPass\" placeholder=\"Password\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <br>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label >Numero del Celular</label>\r\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"numCelular\" id=\"numPhone\"placeholder=\"Ingrese el numero de celular\"\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <br>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <div class=\"form-check\">\r\n");
      out.write("                                <input class=\"form-check-input\" type=\"checkbox\" id=\"check\">\r\n");
      out.write("                                <label class=\"form-check-label\" for=\"check\">\r\n");
      out.write("                                    Terminos y condiciones\r\n");
      out.write("                                </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\" id=\"btnGuardar\">Registrar Usuario</button>\r\n");
      out.write(" \r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-2\"></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!--SCRIPT-->\r\n");
      out.write("    <script src=\"bootstrap/JS/popper.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"bootstrap/JS/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"bootstrap/JS/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

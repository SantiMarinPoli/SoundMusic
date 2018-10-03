package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>SoundMusic</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" type=\"img/png\" href=\"icon/musica.png\"/>\n");
      out.write("        <link href=\"style/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"bootstrap/CSS/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"bootstrap/JS/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body >\n");
      out.write("\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">Music Sound</a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"collapse navbar-collapse nav\" id=\"navbarNavDropdown\">\n");
      out.write("        <ul class=\"navbar-nav\">\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link \" href=\"home.jsp\">Home</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"usuario.jsp\">Usuarios</a>\n");
      out.write("                <!--<a class=\"nav-link\" href=\"controladorUsuario?opcion=listarUsuarios\">Usuarios</a>-->\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"empresa.jsp\">Empresas Difunsoras</a>\n");
      out.write("               <!-- <a class=\"nav-link\" href=\"controladorEmpresaDifusora?opcion=listarEmpresa\">Empresas Difunsoras</a>-->\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item \">\n");
      out.write("                <a class=\"nav-link\" href=\"artista.jsp\">Artistas</a>\n");
      out.write("                <!--<a class=\"nav-link\" href=\"controladorArtista?opcion=listarArtista\">Artistas</a>-->\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item \">\n");
      out.write("                <a class=\"nav-link\" href=\"regalias.jsp\">Regalias</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item \">\n");
      out.write("                <a class=\"nav-link\" href=\"auditoria.jsp\">Log de Auditoria</a>\n");
      out.write("            </li>            \n");
      out.write("        </ul>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col display-flex\">\n");
      out.write("                <a href =\"login.jsp\" class=\"btn btn-danger\" type=\"button\" click=\"cerrarSesion()\">Salir</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container main-container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                    <h3>Artistas Mas Destacados Del 2018</h3>\n");
      out.write("                    <hr>\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("                    <div class=\"card-columns animated fadeIn fast\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii <span> <img src=\"icon/discoOro.png\"  class=\"img img-thumbnail disco\"/></span></h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii <span><img src=\"icon/discoPlat.png\"  class=\"img img-thumbnail disco\"/></span></h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii</h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii</h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii</h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <img class=\"card-img-top\" src=\"img/art1.jpg\" >\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">Avicii</h5>\n");
      out.write("                                <span class=\"badge badge-primary\">Wake Up</span>\n");
      out.write("                                <span class=\"badge badge-primary\">Stories</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                    <h3>Albunes Recientes</h3>\n");
      out.write("                    <hr>\n");
      out.write("                    <br> \n");
      out.write("\n");
      out.write("                    <!--LISTA DE ALBUN INICIO-->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-4\">\n");
      out.write("                            <img src=\"img/artistas/axwell&ingrosso/art4.jpg\" class=\"img img-thumbnail \"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <h4>Axwell & Ingrosso</h4>\n");
      out.write("                            <hr>\n");
      out.write("                            <br>\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr class=\"thead-dark\">\n");
      out.write("                                        <th></th>\n");
      out.write("                                        <th scope=\"col\">Nombre del Albun</th>\n");
      out.write("                                        <th scope=\"col\">No. Canciones</th>\n");
      out.write("                                        <th scope=\"col\">Fecha de Lanzamiento</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> \n");
      out.write("                                            <img src=\"img/artistas/axwell&ingrosso/albun1.jpg\" class=\"img img-thumbnail icon-artista\"/>\n");
      out.write("                                        </th>\n");
      out.write("                                        <td>More Than You Know</td>\n");
      out.write("                                        <td>15</td>\n");
      out.write("                                        <td>8 de diciembre del 2017</td>\n");
      out.write("                                    </tr>\n");
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> \n");
      out.write("                                            <img src=\"img/artistas/axwell&ingrosso/albun1.jpg\" class=\"img img-thumbnail icon-artista\"/>\n");
      out.write("                                        </th>\n");
      out.write("                                        <td>Renegade</td>\n");
      out.write("                                        <td>30</td>\n");
      out.write("                                        <td>8 de diciembre del 2017</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <br>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--LISTA DE ALBUN FIN-->\n");
      out.write("\n");
      out.write("                    <!--LISTA DE ALBUN INICIO-->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-4\">\n");
      out.write("                            <img src=\"img/artistas/axwell&ingrosso/art4.jpg\" class=\"img img-thumbnail \"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <h4>Axwell & Ingrosso</h4>\n");
      out.write("                            <hr>\n");
      out.write("                            <br>\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr class=\"thead-dark\">\n");
      out.write("                                        <th></th>\n");
      out.write("                                        <th scope=\"col\">Nombre del Albun</th>\n");
      out.write("                                        <th scope=\"col\">No. Canciones</th>\n");
      out.write("                                        <th scope=\"col\">Fecha de Lanzamiento</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> \n");
      out.write("                                            <img src=\"img/artistas/axwell&ingrosso/albun1.jpg\" class=\"img img-thumbnail icon-artista\"/>\n");
      out.write("                                        </th>\n");
      out.write("                                        <td>More Than You Know</td>\n");
      out.write("                                        <td>15</td>\n");
      out.write("                                        <td>8 de diciembre del 2017</td>\n");
      out.write("                                    </tr>\n");
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> \n");
      out.write("                                            <img src=\"img/artistas/axwell&ingrosso/albun1.jpg\" class=\"img img-thumbnail icon-artista\"/>\n");
      out.write("                                        </th>\n");
      out.write("                                        <td>Renegade</td>\n");
      out.write("                                        <td>30</td>\n");
      out.write("                                        <td>8 de diciembre del 2017</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <br>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--LISTA DE ALBUN FIN-->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--SCRIPT-->\n");
      out.write("        <script src=\"bootstrap/JS/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"bootstrap/JS/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/navbar.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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

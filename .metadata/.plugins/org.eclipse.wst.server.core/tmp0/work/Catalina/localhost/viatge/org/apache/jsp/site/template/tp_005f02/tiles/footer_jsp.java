/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-04-14 17:59:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.site.template.tp_005f02.tiles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\t\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("\n");
      out.write("\t<div class=\"container\">\n");
      out.write("    \n");
      out.write("    \t<div class=\"col-01\">\n");
      out.write("        \t<!-- MENU FOOTER -->\n");
      out.write("        \t<div class=\"nav-footer\">\n");
      out.write("                <h2 class=\"txt-thema\">NAVEGAÇÃO</h2>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\">CATEGORIAS</a></li>\n");
      out.write("                    <li><a href=\"#\">VIAGEM PERFEITA</a></li>\n");
      out.write("                    <li><a href=\"#\">BLOG</a></li>\n");
      out.write("                    <li><a href=\"#\">COMPRE ONLINE</a></li>\n");
      out.write("                    <li><a href=\"#\">QUEM SOMOS</a></li>\n");
      out.write("                    <li><a href=\"#\">CONTATO</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- FIM MENU FOOTER -->\n");
      out.write("            \n");
      out.write("            <!-- TELEFONE FOOTER -->\n");
      out.write("            <div class=\"phone-footer\">\n");
      out.write("            \t<h2 class=\"txt-thema\">TELEFONE</h2>\n");
      out.write("                NOSSA LINHA DIRETA E RÁPIDA,<br> LIGUE AGORA MESMO  <span class=\"txt-thema\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</span>\n");
      out.write("            </div>\n");
      out.write("            <!-- FIM TELEFONE FOOTER -->\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"col-02\">\n");
      out.write("        \n");
      out.write("        \t<div class=\"feeds-footer\">\n");
      out.write("            \t<h2 class=\"txt-thema\">NO BLOG</h2>\n");
      out.write("                <!-- FEEDS DE NOTÍCIAS -->\n");
      out.write("                <ul>\n");
      out.write("                \t<li>\n");
      out.write("                    \t<figure><a href=\"#\"><img src=\"public/image/temp/post-p01.jpg\" alt=\"\"></a></figure> <!-- IMAGEM DE 70 x 70 PX -->\n");
      out.write("                        <div>\n");
      out.write("                            <h3><a href=\"#\">AMAZING PLACES</a></h3>\n");
      out.write("                            <p><a href=\"#\">Purus ac congue arcu cursus ut vitae pulvinar massaidp.</a></p>\n");
      out.write("                            <p>25 março, 2015</p>\n");
      out.write("                    \t</div>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                    <li>\n");
      out.write("                    \t<figure><a href=\"#\"><img src=\"public/image/temp/post-p02.jpg\" alt=\"\"></a></figure> <!-- IMAGEM DE 70 x 70 PX -->\n");
      out.write("                        <div>\n");
      out.write("                            <h3><a href=\"#\">TRAVEL INSURANCE</a></h3>\n");
      out.write("                            <p><a href=\"#\">Purus ac congue arcu cursus ut vitae pulvinar massaidp.</a></p>\n");
      out.write("                            <p>25 março, 2015</p>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- FIM FEEDS DE NOTÍCIAS -->\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"col-03\">\n");
      out.write("        \t\n");
      out.write("            <!-- FORM DE MEWSLETTER -->\n");
      out.write("\t\t\t<div class=\"newsletter\">\n");
      out.write("            \t<h2 class=\"txt-thema\">NEWSLETTER</h2>\n");
      out.write("            \t<p>Purus ac congue arcu cursus ut vitae pulvinar massaidp.</p>\n");
      out.write("        \t\t<form action=\"#\" method=\"post\" class=\"form-newsletter\">\n");
      out.write("                \t<div><input type=\"email\" name=\"newsletter\" placeholder=\"Seu E-mail_\"></div>\n");
      out.write("                    <div><button type=\"submit\" name=\"cadasdrar-newsletter\"></button></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <!-- FIM FORM DE MEWSLETTER -->\n");
      out.write("            \n");
      out.write("            <!-- REDES SOCIAIS -->\n");
      out.write("            <div class=\"midia-social-footer\">\n");
      out.write("            \t<h2 class=\"txt-thema\">REDE SOCIAIS</h2>\n");
      out.write("                <ul class=\"midia-social\">\n");
      out.write("                    <li class=\"facebook\"><a href=\"#\"></a></li>\n");
      out.write("                    <li class=\"twitter\"><a href=\"#\"></a></li>\n");
      out.write("                    <li class=\"instagram\"><a href=\"#\"></a></li>\n");
      out.write("                    <li class=\"youtube\"><a href=\"#\"></a></li>\n");
      out.write("                    <li class=\"plus\"><a href=\"#\"></a></li>\n");
      out.write("                    <li class=\"linkedin\"><a href=\"#\"></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- FIM REDES SOCIAIS -->\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("    <div class=\"copyright bg-thema\">\n");
      out.write("    \t<div class=\"container\">\n");
      out.write("            <p>Todos os direitos reservador a <strong>");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("</strong>.</p>\n");
      out.write("            <a href=\"#\" target=\"_blank\" class=\"joocebox\"></a> <!-- LOGO JOOCEBOX -->\n");
      out.write("            <a href=\"#\" onclick=\"$('html,body').animate({ scrollTop: $('body').offset().top }, 1800);\"  class=\"voltar-top\"></a> <!-- LINK VOLTAR AO TOPO -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("</footer>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /site/template/tp_02/tiles/footer.jsp(28,92) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tenant.agencyPhone}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent(null);
    // /site/template/tp_02/tiles/footer.jsp(97,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tenant.agencyName}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }
}

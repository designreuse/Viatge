/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2015-04-14 17:21:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.site.template.tp_005f01.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class default_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<!--<![endif]-->\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<!-- Page Title -->\n");
      out.write("<title>JooceBox | Site Template 01</title>\n");
      out.write("\n");
      out.write("<!-- Meta Tags -->\n");
      out.write("<meta name=\"keywords\" content=\"HTML5 Template\" />\n");
      out.write("<meta name=\"description\" content=\"JooceBox | Site Template 01\">\n");
      out.write("<meta name=\"author\" content=\"JooceBox\">\n");
      out.write("\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("<!-- Theme Styles -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/font-awesome.min.css\">\n");
      out.write("<link href='http:/fonts.googleapis.com/css?family=Lato:300,400,700'\n");
      out.write("\trel='stylesheet' type='text/css'>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/animate.min.css\">\n");
      out.write("\n");
      out.write("<!-- Current Page Styles -->\n");
      out.write("\n");
      out.write("<!-- Box Slider css -->\n");
      out.write("<link id=\"main-style\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/components/jquery.bxslider/jquery.bxslider.css\">\n");
      out.write("\n");
      out.write("<!-- Main Style -->\n");
      out.write("<link id=\"main-style\" rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/style.css\">\n");
      out.write("\n");
      out.write("<!-- Custom Styles -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/custom.css\">\n");
      out.write("\n");
      out.write("<!-- Updated Styles -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/updates.css\">\n");
      out.write("\n");
      out.write("<!-- Responsive Styles -->\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/css/responsive.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/components/pwstabs-master/assets/jquery.pwstabs-1.2.1.min.css\">\n");
      out.write("\n");
      out.write("<!-- CSS for IE -->\n");
      out.write("<!--[if lte IE 9]>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/ie.css\" />\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("      <script type='text/javascript' src=\"http:/html5shiv.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("      <script type='text/javascript' src=\"http:/cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js\"></script>\n");
      out.write("      <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"page-wrapper\">\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Javascript -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery.noconflict.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/modernizr.2.7.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery-migrate-1.2.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery.placeholder.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery-ui.1.10.4.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- Twitter Bootstrap -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- Box Slider -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/components/jquery.bxslider/jquery.bxslider.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<!-- parallax -->\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/jquery.stellar.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- waypoint -->\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/waypoints.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- load page Javascript -->\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/theme-scripts.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/js/scripts.js\"></script>\n");
      out.write("\t\t\n");
      out.write("\t<!-- Shorten Text Plugin -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://viralpatel.net/blogs/demo/jquery/jquery.shorten.1.0.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<!--  Tab Plugin -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/site/resources/tp_01/components/pwstabs-master/assets/jquery.pwstabs-1.2.1.min.js\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\tjQuery(function ($) {\n");
      out.write("\t\t\t\n");
      out.write("\t         $('.tabset1').pwstabs({\n");
      out.write("\t             effect: 'scale',\n");
      out.write("\t             defaultTab: 3,\n");
      out.write("\t          });\n");
      out.write("\t         \n");
      out.write("\t         $('.bxslider').bxSlider({\n");
      out.write("\t        \t  infiniteLoop: false,\n");
      out.write("\t        \t  hideControlOnEnd: true\n");
      out.write("\t        \t});\n");
      out.write("\t         \n");
      out.write("\t\t\t\t$('.comment').shorten({\n");
      out.write("\t\t\t\t\t\"showChars\" : 1000,\n");
      out.write("\t\t\t\t\t\"moreText\" : \"Ver Mais\",\n");
      out.write("\t\t\t\t\t\"lessText\" : \"Menos\",\n");
      out.write("\t\t\t\t});\t\t\n");
      out.write("\t\t});\n");
      out.write(" \n");
      out.write(" \n");
      out.write("\t\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    _jspx_th_tiles_005finsertAttribute_005f0.setJspContext(_jspx_page_context);
    // /site/template/tp_01/template/default.jsp(68,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("header");
    _jspx_th_tiles_005finsertAttribute_005f0.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f1 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    _jspx_th_tiles_005finsertAttribute_005f1.setJspContext(_jspx_page_context);
    // /site/template/tp_01/template/default.jsp(70,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setName("body");
    _jspx_th_tiles_005finsertAttribute_005f1.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f2 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    _jspx_th_tiles_005finsertAttribute_005f2.setJspContext(_jspx_page_context);
    // /site/template/tp_01/template/default.jsp(72,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f2.setName("footer");
    _jspx_th_tiles_005finsertAttribute_005f2.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    return false;
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-11-20 06:25:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sg.menupojo.Menu;
import java.util.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("com.sg.menupojo.Menu");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Menu Details</title>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .container {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-wrap: wrap;\r\n");
      out.write("            gap: 20px;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card {\r\n");
      out.write("            width: 23%;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            background-color: #f5f5f5;\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            transition: transform 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card img {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 250px;\r\n");
      out.write("            border-radius:20px;\r\n");
      out.write("            object-fit: cover;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card-content {\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card-content h3 {\r\n");
      out.write("            margin: 10px 0;\r\n");
      out.write("            font-size: 1.2em;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card-content p {\r\n");
      out.write("            margin: 5px 0;\r\n");
      out.write("            font-size: 0.9em;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .card:hover {\r\n");
      out.write("            transform: scale(1.05);\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        select {\r\n");
      out.write("            width: 20%;\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            margin: 10px 0;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            background-color: #FF734C;\r\n");
      out.write("            border: none;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: #ff3d00;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* Responsive Design */\r\n");
      out.write("        @media (max-width: 768px) {\r\n");
      out.write("            .card {\r\n");
      out.write("                width: 45%;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        @media (max-width: 480px) {\r\n");
      out.write("            .card {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .cart-button {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    margin-right: 30px;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    color: white;\r\n");
      out.write("    background: linear-gradient(90deg, #ff7e5f, #feb47b);\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 25px;\r\n");
      out.write("    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    transition: all 0.3s ease-in-out;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".cart-button:hover {\r\n");
      out.write("    background: linear-gradient(90deg, #feb47b, #ff7e5f);\r\n");
      out.write("    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    transform: translateY(-2px);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".cart-button:active {\r\n");
      out.write("    transform: translateY(0);\r\n");
      out.write("    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        // Function to handle adding an item to the cart using AJAX\r\n");
      out.write("        function addToCart(menuId) {\r\n");
      out.write("            const quantity = document.getElementById(\"quantity-\" + menuId).value;\r\n");
      out.write("\r\n");
      out.write("            // Perform AJAX request\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: 'AddToCartController',\r\n");
      out.write("                method: 'POST',\r\n");
      out.write("                data: { menuId: menuId, quantity: quantity },\r\n");
      out.write("                success: function(response) {\r\n");
      out.write("                    alert(\"added the cart item successfully\"); // Notify success\r\n");
      out.write("                },\r\n");
      out.write("                error: function(xhr) {\r\n");
      out.write("                    alert(\"Error: \" + xhr.responseJSON.message); // Notify error\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>Menu Item Details</h1>\r\n");
      out.write("    \r\n");
      out.write("    <a href=\"cart.jsp\" class = \"cart-button\">Go to Cart</a>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        ");
 
            // Get the menu list from the request
            List<Menu> menuList = (List<Menu>) request.getAttribute("menu");
            
            // Check if the menu list is not null and not empty
            if (menuList != null && !menuList.isEmpty()) { 
                // Loop through the menu list and display each item
                for (Menu menu : menuList) {
        
      out.write("\r\n");
      out.write("        <div class=\"card\">\r\n");
      out.write("            <div class=\"card-content\">\r\n");
      out.write("                <img alt=\"Menu Items\" src=\"");
      out.print( menu.getImage() );
      out.write("\">\r\n");
      out.write("                <h3>");
      out.print( menu.getName() );
      out.write("</h3>\r\n");
      out.write("                <p><strong>Description:</strong> ");
      out.print( menu.getDescription() );
      out.write("</p>\r\n");
      out.write("                <p><strong>Price:</strong> ₹");
      out.print( menu.getPrice() );
      out.write("</p>\r\n");
      out.write("                <p><strong>Rating:</strong> ");
      out.print( menu.getRating() );
      out.write("/5</p>\r\n");
      out.write("                <p><strong>Available:</strong> ");
      out.print( menu.isAvailable() ? "Yes" : "No" );
      out.write("</p>\r\n");
      out.write("                <label for=\"quantity-");
      out.print( menu.getMenuId() );
      out.write("\">Quantity:</label>\r\n");
      out.write("                <select id=\"quantity-");
      out.print( menu.getMenuId() );
      out.write("\" name=\"quantity\">\r\n");
      out.write("                    ");
 for (int i = 1; i <= 10; i++) { 
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( i );
      out.write('"');
      out.write('>');
      out.print( i );
      out.write("</option>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </select>\r\n");
      out.write("                <button type=\"button\" onclick=\"addToCart(");
      out.print( menu.getMenuId() );
      out.write(")\">Add to Cart</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
 
                } // End of for loop
            } else { // If no menu items are available
        
      out.write("\r\n");
      out.write("        <p>No menu details found for this restaurant.</p>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div style=\"text-align: center; margin-top: 20px;\">\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

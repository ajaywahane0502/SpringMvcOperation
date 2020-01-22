/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Priti
 */
@WebServlet(urlPatterns = {"/UpdatePhoto"})
public class UpdatePhoto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String path="E:\\JAVARespository\\JAVAPrograms\\NetBeansProjects\\ServletWebApplication\\web\\assets\\Images";
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
            if(ServletFileUpload.isMultipartContent(request))
            {
                String filename=null;
                String filesize=null;
                String filetype=null;
                String username=null;
                try
                {
                    List<FileItem> multiparts= new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    for(FileItem item : multiparts)
                    {
                        if(!item.isFormField())
                        {
                            filename=new File(item.getName()).getName();
                            filesize=new Long(item.getSize()).toString();
                            filetype=item.getContentType();
                            item.write(new File(path+File.separator+filename));
                        }
                        else
                        {
                            if(item.getFieldName().equalsIgnoreCase("username"))
                            {
                                username=item.getString();
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    out.println(e);
                }
                try
                {
                    Connection con;
                    PreparedStatement pst;
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/servlet_test";
                    con=DriverManager.getConnection(url, "root", "");
                    String sql="update form set filename='"+filename+"' where username='"+username+"'";
                    pst=con.prepareStatement(sql);
                    int i=pst.executeUpdate();
                    if(i>0)
                    {
                        response.sendRedirect("DisplayImg.jsp?filename="+filename);
                    }
                }
                catch(Exception e)
                {
                    out.println(e);
                }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}

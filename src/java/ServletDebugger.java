/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDebugger extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // parameter "name"
        String strpm = request.getParameter("name");
        ServletContext context = getServletContext( );
        // checks if the parameter is set or not
        if (strpm == null || strpm.equals(""))
            context.log("No message received:", new IllegalStateException("Sorry, the"
                    + "parameter is missing."));
        else
            context.log("Here is the visitor’s message: " +strpm);
    }

}

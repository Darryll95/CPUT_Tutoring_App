/**
 * Servlet file
 *
 * @author Anathi Mhlom
 */
package com.tutoringapp.tutoringapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userServ extends HttpServlet {

    private usersDAO usersDAO = new usersDAO();

    public userServ() throws SQLException {
        super();
    }

    /*@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            out.println(name);
            out.println(surname);
            out.println(phone);
            out.println(email);
            out.println(password);
            //Get Connection Driver to establish database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Establish connection
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/tutoringApp", "Anathim", "Anathim");
            //Write SQL query to insert data
            PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, phone);
            pst.setString(4, email);
            pst.setString(5, password);
            int i = pst.executeUpdate();
            //Check if values are saved successfully or not
            if (i != 0) {
                out.println("<br>Record has been inserted");
            } else {
                out.println("Failed to insert the data");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }
    }*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.html");
        dispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        pw.println("<html><body>");
        try {
            ps = con.prepareStatement("select * from users where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                pw.println("<h3>Welcome " + " " + email + "</h3>");
                RequestDispatcher rd1 = request.getRequestDispatcher("index2.html");
                rd1.include(request, response);
                //or  
                response.sendRedirect("./home.html");  
                //pw.println("<form method=\"post\" action=\"Login.html\">");
                //pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
                //pw.println("</form>");
            } else {
                pw.println("<center><h3>Invalid email/password /n Enter correct email/password</h3></center>");
                RequestDispatcher rd2 = request.getRequestDispatcher("index.html");
                rd2.include(request, response);
                //or  
                //response.sendRedirect("./Login.html");  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        users user = new users(name, surname, phone, email, password);
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);

        try {
            usersDAO.insertUser();
        } catch (SQLException ex) {
            Logger.getLogger(userServ.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd1 = request.getRequestDispatcher("login.html");
        rd1.include(request, response);
    }

}
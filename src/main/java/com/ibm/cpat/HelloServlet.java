package com.ibm.cpat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hello CP4A Chapter. Count is: " + callDb());
    }

    protected String callDb () {
        String result = null;

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/HelloServletDS");

            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select count(*) from BLUADMIN.supplier";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                result = rs.getString(1);
                System.out.println(String.format("************* Count #%d:", rs.getInt(1)));
            }
        } catch (Exception catchAll) {
            result =  "Failed to connect to db [" + catchAll.getMessage() + "]";
        }

        return result;
    }
}



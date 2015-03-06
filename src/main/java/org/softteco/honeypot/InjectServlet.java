package org.softteco.honeypot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.postgresql.Driver;

/**
 *
 * @author andy
 */
@WebServlet("/inject")
public class InjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final String id = req.getParameter("id");
            try (Connection connect = new Driver().connect("jdbc:postgresql://localhost/genes?user=genes", null)) {
                String sql = "select * from test where id = " + id;
                final PreparedStatement prepareStatement = connect.prepareStatement(sql);
                final ResultSet query = prepareStatement.executeQuery();
                resp.getWriter().write("<html><body><table>");
                while(query.next()) {
                    resp.getWriter().write("<tr><td>" + query.getInt(1)+ "</td><td>" + query.getString(2)+ "</td></tr>");
                }
                resp.getWriter().write("</table></body></html>");
            }
        } catch (SQLException ex) {
            throw new ServletException("", ex);
        }

    }
    
}

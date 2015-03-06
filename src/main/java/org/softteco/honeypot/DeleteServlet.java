package org.softteco.honeypot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final String id = req.getParameter("id");
            try (Connection connect = new Driver().connect("jdbc:postgresql://localhost/genes?user=genes", null)) {
                String sql = "delete from test where id = " + id;
                final PreparedStatement prepareStatement = connect.prepareStatement(sql);
                int deleted = prepareStatement.executeUpdate();
                resp.getWriter().write("<html><body>");
                resp.getWriter().write("Deleted " + deleted + " records.");
                resp.getWriter().write("</body></html>");
            }
        } catch (SQLException ex) {
            throw new ServletException("", ex);
        }

    }
    
}

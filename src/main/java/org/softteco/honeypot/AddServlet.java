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
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = req.getParameter("text");
        try (Connection connect = new Driver().connect("jdbc:postgresql://localhost/genes?user=genes", null)) {
            String sql = "insert into test select COALESCE(max(id) + 1, 1), ? from test";
            final PreparedStatement prepareStatement = connect.prepareStatement(sql);
            prepareStatement.setString(1, text);
            int added = prepareStatement.executeUpdate();
            resp.getWriter().write("<html><body>Added " + added + " records.</body></html>");
        } catch (SQLException ex) {
            throw new ServletException("", ex);
        }

    }

}

package org.zj.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zj.entity.User;

/**
 * Servlet implementation class User2Servlet
 */
@WebServlet("/UserHandleServlet")
public class UserHandleServlet extends HttpServlet {

    private static final long serialVersionUID = -7259117829849340969L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, User> users = (Map<Integer, User>) request.getServletContext().getAttribute("users");
        String id = request.getParameter("id");
        users.remove(Integer.parseInt(id));
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Map<Integer, User> users = (Map<Integer, User>) request.getServletContext().getAttribute("users");
        users.put(id, new User(id, name));
        response.sendRedirect("index.jsp");
    }

}

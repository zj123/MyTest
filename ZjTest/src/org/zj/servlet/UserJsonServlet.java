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
@WebServlet("/UserJsonServlet")
public class UserJsonServlet extends HttpServlet {

    private static final long serialVersionUID = 4730970531041578811L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        getServletConfig()
        Map<Integer, User> users = (Map<Integer, User>) request.getServletContext().getAttribute("users");
        response.getOutputStream().write(users.toString().getBytes());
        response.setContentType("application/json; charset=utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

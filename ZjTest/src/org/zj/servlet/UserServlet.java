package org.zj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zj.entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 553770476086161408L;

	// public static Map<Integer, User> users = new ConcurrentHashMap<Integer,
	// User>();
	public static List<User> users = new ArrayList<User>();

	@Override
	public void init() throws ServletException {
		// users.put(1, new User(1, "a"));
		// users.put(2, new User(2, "b"));
		// users.put(3, new User(3, "c"));

		users.add(new User(1, "a"));
		users.add(new User(2, "b"));
		users.add(new User(3, "c"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("users", users);
		response.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.jspidr.servlet3.hobby;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hobby")
public class Hobby extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hobby() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String[] hobbies = request.getParameterValues("hobby");
		writer.println("<h3>YOUR SELECTED VALUES ARE</h3> ");
		for (String hobby : hobbies) {
			writer.println(hobby + "<br>");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

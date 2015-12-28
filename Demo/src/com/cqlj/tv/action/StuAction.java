package com.cqlj.tv.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuAction", urlPatterns = { "/stuAction.do" })
public class StuAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("请求到达");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String jona = "{" + '"' + "name" + '"' + ":" + '"' + "张三" + '"' + "," + '"' + "age" + '"' + ":" + '"' + "20"
				+ '"' + "}";
		out.println(jona);
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		String jona = "{" + '"' + "name" + '"' + ":" + '"' + "张三" + '"' + "," + '"' + "age" + '"' + ":" + '"' + "20"
				+ '"' + "}";
		System.out.println(jona);
	}

}

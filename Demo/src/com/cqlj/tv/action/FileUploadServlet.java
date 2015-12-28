package com.cqlj.tv.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = { "/servlet/upload" })
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("upload");
		// 格式如：form-data; name="upload"; filename="YNote.exe"
		String disposition = part.getHeader("content-disposition");
		System.out.println(disposition);
		String fileName = disposition.substring(disposition.lastIndexOf("=") + 2, disposition.length() - 1);
		String fileType = part.getContentType();
		long fileSize = part.getSize();
		System.out.println("fileName: " + fileName);
		System.out.println("fileType: " + fileType);
		System.out.println("fileSize: " + fileSize);
		String uploadPath = request.getServletContext().getRealPath("/upload");
		System.out.println("uploadPath" + uploadPath);
		//part.write(uploadPath + File.separator + fileName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.cham.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cham.Dao.StaffDao;
import com.cham.Dao.UserDao;
import com.cham.bean.User;

/**
 * Servlet implementation class Infor
 */
@WebServlet("/InforUser")
public class InforUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if("getUser".equals(request.getParameter("action"))) {
			ArrayList<User> userList = UserDao.getAllTeacherAndStaff();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/Admin.jsp").forward(request, response);
//			if(request.getParameter("type").equals("staff")) {
//				System.out.print("staff");
//			}
//			else if(request.getParameter("type").equals("teacher")) {
//				System.out.print("teacher");
//			}
//			else {
//				System.out.print("all");
//			}
		}
//		
//		StaffDao userDao = new StaffDao();
//		request.setAttribute("listStaff", userDao.getListStaffs());
//		System.out.println("size: "+userDao.getListStaffs().size());
//		RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
//		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

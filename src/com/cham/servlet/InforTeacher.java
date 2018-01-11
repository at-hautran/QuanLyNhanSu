package com.cham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cham.Dao.StaffDao;
import com.cham.Dao.TeacherDao;
import com.cham.bean.Teacher;
import com.cham.bean.User;

/**
 * Servlet implementation class InforTeacher
 */
@WebServlet("/InforTeacher")
public class InforTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userinfor = (User)session.getAttribute("userinfor");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action;
		action = request.getParameter("action");
		System.out.println(action);
		if(action == null) {
			TeacherDao teacherDao = new TeacherDao();
			request.setAttribute("listTeacher", teacherDao.getListTeachers());
			System.out.println("size: "+teacherDao.getListTeachers().size());
			RequestDispatcher rd = request.getRequestDispatcher("/listTeacher.jsp");
			rd.forward(request, response);
		}
		else {
				switch (action) {
					case "edit":
						Teacher teacher = TeacherDao.getTeacher(userinfor.getUserID());
						request.setAttribute("teacher", teacher);
						RequestDispatcher rd1 = request.getRequestDispatcher("/editTeacher.jsp");
						rd1.forward(request, response);
						break;
					case "update":
						
						System.out.println("size: update here");
						Teacher teacher_update = getTeacher(request);
						boolean update_return = TeacherDao.update(teacher_update);
						System.out.println(update_return);
						if (update_return) {
							Teacher teacher1 = TeacherDao.getTeacher(userinfor.getUserID());
							request.setAttribute("teacher", teacher1);
							RequestDispatcher rd2 = request.getRequestDispatcher("/editTeacher.jsp");
							rd2.forward(request, response);
							
						}
						else {
							
						}
						
					}
					
						
		}
	}
	
	public Teacher getTeacher(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userinfor = (User)session.getAttribute("userinfor");
		String name;
		name = (request.getParameter("name"));
		System.out.println("b" + name);
		int userId = userinfor.getUserID();
		Teacher teacher = new Teacher(userId, name);
		
		return teacher;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

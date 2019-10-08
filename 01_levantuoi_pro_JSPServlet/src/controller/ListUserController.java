package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import model.UserDatabaseModel;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Kết nối lấy dữ liệu
			UserDatabaseModel database = new UserDatabaseModel();
			ArrayList<UserModel> list = database.getList();
			// gửi dữ liệu
			request.setAttribute("ListUser", list);
			RequestDispatcher rd = request.getRequestDispatcher("View/listUser.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("View/error.jsp");
			e.printStackTrace();
		}
	}
}

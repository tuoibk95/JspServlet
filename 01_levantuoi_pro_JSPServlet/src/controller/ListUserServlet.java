package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListUser;
import model.UserDatabase;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// Kết nối lấy dữ liệu
			UserDatabase database = new UserDatabase();
			ArrayList<ListUser> list = database.getList();
			// gửi dữ liệu
			request.setAttribute("ListUser", list);
			RequestDispatcher rd = request.getRequestDispatcher("listUser.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Đã xảy ra lỗi");
			e.printStackTrace();
		}
	}
}

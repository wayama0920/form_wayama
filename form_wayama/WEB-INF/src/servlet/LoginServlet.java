package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminInfo;
import dao.AdminDAO;

//ログイン画面で入力したuseridとpasswordを取得し、userinfoデータベースで検索してもらう
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminInfo admininfo = new AdminInfo();
		AdminDAO adminDao = new AdminDAO();
		String userid = "";
		String password = "";
		String error = "";

			try {
				// 文字のコーティング
				request.setCharacterEncoding("UTF-8");

				//jspデータのuseridとpasswordを取得する
				userid = request.getParameter("userid");
				password = request.getParameter("password");

				admininfo = adminDao.selectById(userid,password);

			} catch (IllegalStateException e) {



			} finally {

				if (admininfo.getUserid() != null) {

						request.getRequestDispatcher("/view/adminList.jsp").forward(request, response);
					}else {
						error = "※useridまたはpassowrdが間違っております。";

						request.setAttribute("error", error);
						request.getRequestDispatcher("/view/login.jsp").forward(request, response);
					}
			}

	}
}

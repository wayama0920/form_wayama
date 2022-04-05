package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginInfo;
import dao.LoginDAO;

//ログイン画面で入力したuseridとpasswordを取得し、userinfoデータベースで検索してもらう
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginInfo logininfo = new LoginInfo();
		LoginDAO loginDao = new LoginDAO();
		String userid = "";
		String password = "";
		String error = "";

			try {
				// 文字のコーティング
				request.setCharacterEncoding("UTF-8");

				//jspデータのuseridとpasswordを取得する
				userid = request.getParameter("userid");
				password = request.getParameter("password");


				logininfo = loginDao.selectById(userid,password);

			} catch (IllegalStateException e) {



			} finally {

				if (logininfo.getUserid() != null) {
					HttpSession session = request.getSession();
					session.setAttribute("logininfo", logininfo);
					request.getRequestDispatcher("/inquiryList").forward(request, response);
				}else {
					error = "※useridまたはpassowrdが間違っております。";

					request.setAttribute("error", error);
					request.getRequestDispatcher("/view/login.jsp").forward(request, response);
				}
			}

	}
}

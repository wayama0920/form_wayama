package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//ログアウトを行う
public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		//セッションオブジェクトを作成
		HttpSession session = request.getSession();

		//セッションの破棄
		session.invalidate();

		//login.jspにフォワードし、ログイン画面に戻る
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);

	}
}

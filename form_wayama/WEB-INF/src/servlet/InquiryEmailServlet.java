package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.InquiryInfo;
import bean.LoginInfo;
import dao.InquiryDAO;
import util.SendMailTestByGmail;

public class InquiryEmailServlet  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// DAOオブジェクト宣言
		InquiryDAO objDao = new InquiryDAO();

		HttpSession session = request.getSession();

		try {
			// セッションから"logininfo"を取得しUserに代入
			LoginInfo logininfo = (LoginInfo) session.getAttribute("logininfo");

			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");
			// パラメータの取得
			String text = request.getParameter("text");

			String title = request.getParameter("title");


			// DTOオブジェクト宣言しselectByNoメゾットの呼び出し
			SendMailTestByGmail mail = new SendMailTestByGmail();
			mail.sendReply(title,text);



		} catch (IllegalStateException e) {

		} finally {

			request.getRequestDispatcher("/view/inquiryCompletion.jsp").forward(request, response);
		}
	}

}

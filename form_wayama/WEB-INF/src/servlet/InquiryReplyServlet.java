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

public class InquiryReplyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// DAOオブジェクト宣言
		InquiryDAO objDao = new InquiryDAO();


		HttpSession session = request.getSession();

		try {
			// セッションから"logininfo"を取得しにLoginInfo代入
			LoginInfo logininfo = (LoginInfo) session.getAttribute("logininfo");

			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");
			// パラメータの取得
			String inquiryNo = request.getParameter("inquiryNo");


			// DTOオブジェクト宣言しselectByNoメゾットの呼び出し
			InquiryInfo inquiry = objDao.selectByNo(Integer.parseInt(inquiryNo));

			// 検索結果を持ってlist.jspにフォワード
			request.setAttribute("inquiry", inquiry);

		} catch (IllegalStateException e) {

		} finally {

			request.getRequestDispatcher("/view/inquiryReply.jsp").forward(request, response);
		}
	}
}



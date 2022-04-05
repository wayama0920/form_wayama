package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.InquiryInfo;
import bean.LoginInfo;
import dao.InquiryDAO;

public class InquiryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		commonProcess(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		commonProcess(request, response);
	}

	private void commonProcess(HttpServletRequest request, HttpServletResponse response) {
		InquiryInfo inquiryinfo = new InquiryInfo();
		InquiryDAO inquiryDao = new InquiryDAO();
		HttpSession session = request.getSession();
		ArrayList<InquiryInfo> list = null;

		try {
			// 文字のコーティング
			request.setCharacterEncoding("UTF-8");

			// セッションから"logininfo"を取得しUserに代入
			LoginInfo logininfo = (LoginInfo) session.getAttribute("logininfo");

			list = inquiryDao.selectAll();

		} catch (IllegalStateException e) {

		} catch (Exception e) {

		} finally {

			request.setAttribute("list", list);
			try {
				request.getRequestDispatcher("/view/inquiryList.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
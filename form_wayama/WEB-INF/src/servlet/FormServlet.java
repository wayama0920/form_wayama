package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.InquiryInfo;
import dao.InquiryDAO;

public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// DTOオブジェクト宣言
			InquiryInfo inquiryInfo = new InquiryInfo();

			// パラメータの取得
			inquiryInfo.setName(request.getParameter("name"));
			inquiryInfo.setNumber(request.getParameter("number"));
			inquiryInfo.setEmail(request.getParameter("email"));
			inquiryInfo.setSelectmenu(request.getParameter("selectmenu"));
			inquiryInfo.setText(request.getParameter("text"));

			// DAOオブジェクト宣言
			InquiryDAO objDao = new InquiryDAO();

			// 1件登録メソッドを呼び出し
			int count = objDao.insert(inquiryInfo);

			// 登録されたdateをフォワード
			request.setAttribute("count", count);

		} catch (IllegalStateException e) {
//            error ="DB接続エラーの為、お問合せできませんでした。";
//
//        }catch(Exception e){
//            error ="予期せぬエラーが発生しました。<br>"+e;

		} finally {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/formCompletion.jsp").forward(request, response);
		}
	}
}
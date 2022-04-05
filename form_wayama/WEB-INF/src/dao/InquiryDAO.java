package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.InquiryInfo;

public class InquiryDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/formdb";
	private static String USER = "root";
	private static String PASSWD = "root123";

	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = (Connection) DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	public ArrayList<InquiryInfo> selectAll() {
		Connection con = null;
		Statement smt = null;

		ArrayList<InquiryInfo> list = new ArrayList<InquiryInfo>();
		String sql = "SELECT * FROM inquiry ORDER BY inquiryNo DESC";

		try {

			con = InquiryDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				InquiryInfo inquiryinfo = new InquiryInfo();
				inquiryinfo.setInquiryNo(rs.getInt("inquiryNo"));
				inquiryinfo.setName(rs.getString("name"));
				inquiryinfo.setNumber(rs.getString("number"));
				inquiryinfo.setEmail(rs.getString("email"));
				inquiryinfo.setSelectmenu(rs.getString("selectmenu"));
				inquiryinfo.setText(rs.getString("text"));
				inquiryinfo.setDate(rs.getDate("date"));

				list.add(inquiryinfo);
			}



		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;

	}


	public InquiryInfo selectByNo(int inquiryNo) { // データベースからinquriNoの番号からデータを検索する
		Connection con = null;
		Statement smt = null;

		InquiryInfo inquiry = new InquiryInfo();

		try {
			String sql = "SELECT * FROM inquiry WHERE inquiryNo ='" + inquiryNo + "'";

			con = InquiryDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				inquiry.setInquiryNo(rs.getInt("inquiryNo"));
				inquiry.setName(rs.getString("name"));
				inquiry.setNumber(rs.getString("number"));
				inquiry.setEmail(rs.getString("email"));
				inquiry.setSelectmenu(rs.getString("selectmenu"));
				inquiry.setText(rs.getString("text"));
				inquiry.setDate(rs.getDate("date"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return inquiry;
	}

	// データベースへデータを登録するメソッド
	public int insert(InquiryInfo inquiryInfo) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用変数
		int count = 0;

		// SQL文
		String sql = "INSERT INTO inquiry VALUES(NULL,'" + inquiryInfo.getName() + "','" + inquiryInfo.getNumber()
				+ "','" + inquiryInfo.getEmail() + "','" + inquiryInfo.getSelectmenu() + "','" + inquiryInfo.getText()
				+ "',CURDATE())";

		try {
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			count = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// リソースの開放
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return count;
	}
}

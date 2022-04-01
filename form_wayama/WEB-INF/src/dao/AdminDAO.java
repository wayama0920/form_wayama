package dao;

import java.sql.*;


import bean.AdminInfo;



public class AdminDAO {

    // 接続用の情報をフィールドに定数として定義
    private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/formdb";
    private static String USER = "root";
    private static String PASSWD = "root123";

    // データベース接続を行うメソッド
    public static Connection getConnection() {
        try {
            Class.forName(RDB_DRIVE);
            Connection con = DriverManager.getConnection(URL, USER, PASSWD);
            return con;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

  //データベースから指定された1件のアカウント情報の検索を行うメソッド
    public AdminInfo selectById(String userid,String password) {
        // 変数宣言
        Connection con = null;
        Statement smt = null;

        // return用ｵﾌﾞｼﾞｪｸﾄ宣言
        AdminInfo adminInfo = new AdminInfo();

        // SQL文
        String sql = "SELECT * FROM admininfo WHERE userid ='" + userid + "' AND password='"+password+"'";


        try {
            con = AdminDAO.getConnection();
            smt = con.createStatement();

            // SQLをDBへ発行

            ResultSet rs = smt.executeQuery(sql);

            // 取得した結果をDTOオブジェクトに格納
            while (rs.next()) {
                adminInfo.setUserid(rs.getString("userid"));
                adminInfo.setPassword(rs.getString("password"));
            }


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
        return adminInfo;
    }
}
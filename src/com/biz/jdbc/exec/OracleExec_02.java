package com.biz.jdbc.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleExec_02 {

	public static void main(String[] args) {
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "user4";
		String password = "1234";

		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("오라클 연결 성공");

			PreparedStatement pstr = null;

			String sql = " SELECT * FROM tbl_student ";
			
			pstr = con.prepareStatement(sql);
			
			ResultSet rs = pstr.executeQuery();
			
			while(rs.next()) {
				String strNum = rs.getString(1);
				String strName = rs.getString(2);
				
				System.out.println(strNum + " : " + strName);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 실행오류");

		} catch (SQLException e) {
			System.out.println("오라클에 연결할 수 없음");
		}
	}

}

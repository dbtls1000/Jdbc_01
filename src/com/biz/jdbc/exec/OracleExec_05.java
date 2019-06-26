package com.biz.jdbc.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.model.IolistVO;

public class OracleExec_05 {
	/*
	 * user4 schema에 있는 tbl_iolist 테이블을 읽어서
	 * 리스트를 콘솔에 보이시오
	 */
	public static void main(String[] args) {
		List<IolistVO> ioList = new ArrayList<IolistVO>();
		
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "user4";
		String password = "1234";
		
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(url,userName,password);
			
			PreparedStatement ps = null;
			String sql = " SELECT * FROM tbl_iolist ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				IolistVO vo = new IolistVO();
				vo.setIo_seq(rs.getLong(1));
				vo.setIo_date(rs.getString(2));
				vo.setIo_inout(rs.getString(3));
				vo.setIo_amt(rs.getInt(4));
				vo.setIo_price(rs.getInt(5));
				vo.setIo_total(rs.getInt(6));
				vo.setIo_pcode(rs.getString(7));
				vo.setIo_ccode(rs.getString(8));
				ioList.add(vo);
			}
			for(IolistVO vo : ioList) {
				System.out.println(vo);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

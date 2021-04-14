package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.servlet.dto.BookDTO;
import com.sun.tools.javac.util.Context;

public class BookDAO {
	
	DataSource dataSource;
	//String driver = "oracle.jdbc.driver.OracleDriver";
	//String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	//String id = "scott";
	//String pw = "tiger";
	
	public BookDAO( ) {
	try {
			//Class.forName(driver);
		Context context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g")
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<BookDTO> select() {
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			
			//con = DriverManager.getConnection(url,id,pw);
			con = dataSource.getConnection();
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while (res.next()) {
				int bookId = res.getInt("BOOK_ID");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				BookDTO bookDTO = new BookDTO(bookId, bookName , bookLoc);
				list.add(bookDTO);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if (res != null) res.close();
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					}
			}
		return list;
	}
	
}

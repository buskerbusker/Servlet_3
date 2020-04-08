package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		try {
			Connection con = DBConnect.getConnect();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnect() throws Exception {
		// 로그인 정보 4가지
		// 드라이버를 메모리에 로딩
		// 로그인 커넥션 객체 반환

		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// logon deny
		// id나 pw가 틀렸을 경우
		// DB에 해당 유저가 없을 경우
		// 유저의 권한이 적용되지 않은 경우

		// not connect
		// ip port xe정보가 틀린경우
		// 물리적으로 랜선이 뽑혔을 경우
		// listener문제, db 재시동

		// class not found
		// driver명이 틀린경우
		// jdbc api가 없는 경우

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}

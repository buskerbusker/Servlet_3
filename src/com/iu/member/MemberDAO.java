package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {

	// join

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "insert into member values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setInt(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());

		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	// login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnect.getConnect();
		String sql = "select * from member where id=? and password=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setPhone(rs.getInt("phone"));
			memberDTO.setEmail(rs.getString("email"));
		} else {
			memberDTO = null;
		}
		rs.close();
		st.close();
		con.close();
		return memberDTO;
	}

	// delete
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "delete from member where id=?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

	// update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "update member set name=?, age=?, phone=?, email=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getName());
		st.setInt(2, memberDTO.getAge());
		st.setInt(3, memberDTO.getPhone());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getId());

		result = st.executeUpdate();
		st.close();
		con.close();
		return result;

	}

}

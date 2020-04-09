package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.util.DBConnect;

public class MemberDAO {

	// join

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setInt(5, memberDTO.getPhone());

		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

}

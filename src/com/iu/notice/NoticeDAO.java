package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.iu.util.DBConnect;

public class NoticeDAO {

	public ArrayList<NoticeDTO> noticeList() throws Exception {
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();

		Connection con = DBConnect.getConnect();
		String sql = "select * from notice order by create_date asc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setCreate_date(rs.getDate("create_date"));
			ar.add(noticeDTO);
		}
		// 자원을 해제
		rs.close();
		st.close();
		con.close();

		return ar;

	}

	// 2. Select
	public NoticeDTO noticeSelect(int no) throws Exception {
		NoticeDTO noticeDTO = null;
		Connection con = DBConnect.getConnect();
		String sql = "select * from notice where no=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, no);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setCreate_date(rs.getDate("create_date"));
		}

		rs.close();
		st.close();
		con.close();
		return noticeDTO;
	}

	// 3. Insert / add
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "insert into notice values (SEQ_NUM.nextval,?,?,?,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getId());
		st.setString(2, noticeDTO.getSubject());
		st.setString(3, noticeDTO.getContents());

		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	// 4. update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "update notice set subject=?,contents=? where no=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, noticeDTO.getSubject());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNo());

		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	// 5. delete
	public int noticeDelete(int no) throws Exception {
		int result = 0;
		Connection con = DBConnect.getConnect();
		String sql = "delete from notice where no = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);

		result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}

}

package com.iu.notice;

import java.util.ArrayList;

public class NoticeService {
	NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	public ArrayList<NoticeDTO> noticeList() throws Exception {
		return noticeDAO.noticeList();
	}

	// 2.Select
	public NoticeDTO noticeSelect(int no) throws Exception {
		return noticeDAO.noticeSelect(no);
	}

	// 3.Delete
	public int noticeDelete(int no) throws Exception {
		return noticeDAO.noticeDelete(no);
	}

	// 4.Add / Insert
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.noticeAdd(noticeDTO);
	}

	// 5.Update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.noticeMod(noticeDTO);
	}

}

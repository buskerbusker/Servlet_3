package com.iu.member;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO();
	}

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}

}

# Servlet_3
 
 ##기능
 
 - point list 출력
 - point 등록
 - point 상세 정보 출력
 - point 수정
 - point 삭제
 
 ## JSP
 
 - pointList.jsp : 리스트 출력
 - pointAdd.jsp : 입력 폼
 - pointSelect.jsp : point 상세정보 출력
 - pointMod.jsp : point 수정 폼
 
 ## URL 주소 / jsp / Method
 ## /Web-INF/views/point/**
 
 - /point/pointList/ pointList.jsp / get
 - /point/pointAdd/ pointAdd.jsp / get
 - /point/pointAdd/             / post
 - /point/pointSelect/ pointSelect.jsp / get
 - /point/pointMod/ pointMod.jsp / get
 - /point/pointMod/        / post
 - /point/pointDelete/      /get
 
 ======================================================
 
 ### Member
- 회원가입(insert)
- 로그인(select one)
- 회원수정(update)
- 회원탈퇴(delete)
- 마이페이지(select)

 ## JSP
 - web-inf/views/member/....
 - /member/memberJoin memberJoin.jsp / get
 - /member/memberJoin  / post
 - /member/memberLogin memberLogin.jsp / get
 - /member/memberLogin / post
 - /member/memberPage memberPage.jsp / get
 - /member/memberUpdate memberUpdate.jsp / get
 - /member/memberUpdate / get
 - /member/memberDelete / get
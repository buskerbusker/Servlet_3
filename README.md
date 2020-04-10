# Servlet_3

####
- 공지사항 게시판(notice)
- 글쓰기, 수정, 삭제는 id가 admin만 가능
- 글 리스트 페이지, 최신순으로 출력
- 리스트페이지에서 글쓰기 버튼을 누르면 글쓰기 이동
- 리스트페이지에서 글제목을 누르면 글보기로 이동
- 글 상세보기에서 글 수정, 글 삭제 버튼 존재
- 글 삭제 버튼을 누르면 확인 || 취소 창을 띄우고 확인 누르면 삭제. 취소는 아무반응x
- 글 수정 누르면 글수정 이동
 
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
 - /member/memberUpdate / post
 - /member/memberDelete / get
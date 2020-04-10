package com.iu.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.point.PointDTO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeController() {
		super();
		noticeService = new NoticeService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String command = request.getPathInfo();
		String method = request.getMethod();
		String path = "";
		boolean check = true;

		try {

			if (command.equals("/noticeList")) {

				ArrayList<NoticeDTO> ar = noticeService.noticeList();
				request.setAttribute("list", ar);

				path = "../WEB-INF/views/notice/noticeList.jsp";

			} else if (command.equals("/noticeAdd")) {

				if (method.equals("POST")) {

					NoticeDTO noticeDTO = new NoticeDTO();
					String id = request.getParameter("id");
					String subject = request.getParameter("subject");
					String contents = request.getParameter("contents");

					noticeDTO.setId(id);
					noticeDTO.setSubject(subject);
					noticeDTO.setContents(contents);

					int result = noticeService.noticeAdd(noticeDTO);

					check = false;
					path = "../";
				} else {
					path = "../WEB-INF/views/notice/noticeAdd.jsp";
				}

			} else if (command.equals("/noticeMod")) {

				if (method.equals("POST")) {

					NoticeDTO noticeDTO = new NoticeDTO();

					int no = Integer.parseInt(request.getParameter("no"));
					String id = request.getParameter("id");
					String subject = request.getParameter("subject");
					String contents = request.getParameter("contents");

					noticeDTO.setNo(no);
					noticeDTO.setId(id);
					noticeDTO.setSubject(subject);
					noticeDTO.setContents(contents);

					int result = noticeService.noticeMod(noticeDTO);

					String msg = "수정 실패";
					if (result > 0) {
						msg = "수정 성공";
						request.setAttribute("path", "./noticeSelect?no=" + noticeDTO.getNo());
					} else {
						request.setAttribute("path", "./noticeList");
					}
					request.setAttribute("result", msg);
					path = "../WEB-INF/views/common/result.jsp";

				} else {
					int no = Integer.parseInt(request.getParameter("no"));
					NoticeDTO noticeDTO = noticeService.noticeSelect(no);
					request.setAttribute("dto", noticeDTO);
					path = "../WEB-INF/views/notice/noticeMod.jsp";
				}

			} else if (command.equals("/noticeSelect")) {

				int no = Integer.parseInt(request.getParameter("no"));
				NoticeDTO noticeDTO = noticeService.noticeSelect(no);
				request.setAttribute("dto", noticeDTO);
				path = "../WEB-INF/views/notice/noticeSelect.jsp";

			} else if (command.equals("/noticeDelete")) {
				check = false;
				int no = Integer.parseInt(request.getParameter("no"));
				noticeService.noticeDelete(no);
				path = "./noticeList";

			} else {
				System.out.println("ETC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			response.sendRedirect(path);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

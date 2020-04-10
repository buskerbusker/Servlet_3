package com.iu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.iu.point.PointService;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/memberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		memberService = new MemberService();
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

			if (command.equals("/memberJoin")) {

				if (method.equals("POST")) {

					MemberDTO memberDTO = new MemberDTO();
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					String name = request.getParameter("name");
					int age = Integer.parseInt(request.getParameter("age"));
					int phone = Integer.parseInt(request.getParameter("phone"));
					String email = request.getParameter("email");

					memberDTO.setId(id);
					memberDTO.setPassword(password);
					memberDTO.setName(name);
					memberDTO.setAge(age);
					memberDTO.setPhone(phone);
					memberDTO.setEmail(email);

					int result = memberService.memberJoin(memberDTO);
					check = false;
					path = "../";
				} else {
					path = "../WEB-INF/views/member/memberJoin.jsp";
				}

			} else if (command.equals("/memberLogin")) {
				if (method.equals("POST")) {

					MemberDTO memberDTO = new MemberDTO();
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					memberDTO.setId(id);
					memberDTO.setPassword(password);
					memberDTO = memberService.memberLogin(memberDTO);

					if (memberDTO != null) {
						HttpSession session = request.getSession();
						session.setAttribute("member", memberDTO);
						check = false;
						path = "../";
					} else {
						request.setAttribute("result", "Login Fail");
						request.setAttribute("path", "./memberLogin");
						path = "../WEB-INF/views/common/result.jsp";
					}

				} else {
					path = "../WEB-INF/views/member/memberLogin.jsp";
				}

			} else if (command.equals("/memberLogout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				check = false;
				path = "../";

			} else if (command.equals("/memberPage")) {
				path = "../WEB-INF/views/member/memberPage.jsp";

			} else if (command.equals("/memberDelete")) {
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
				int result = memberService.memberDelete(memberDTO);

				check = false;
				path = "../";
				if (result > 0) {
					session.invalidate();
				}

			} else if (command.equals("/memberUpdate")) {
				if (method.equals("POST")) {
					HttpSession session = request.getSession();

					MemberDTO memberDTO = new MemberDTO();
					String id = request.getParameter("id");
					String password = request.getParameter("password");
					String name = request.getParameter("name");
					int age = Integer.parseInt(request.getParameter("age"));
					int phone = Integer.parseInt(request.getParameter("phone"));
					String email = request.getParameter("email");

					memberDTO.setId(id);
					memberDTO.setPassword(password);
					memberDTO.setName(name);
					memberDTO.setAge(age);
					memberDTO.setPhone(phone);
					memberDTO.setEmail(email);

					int result = memberService.memberUpdate(memberDTO);
					check = false;
					path = "../";

					if (result > 0) {
						session.setAttribute("member", memberDTO);
					}

				} else {
					path = "../WEB-INF/views/member/memberUpdate.jsp";
				}
			}
		} catch (

		Exception e) {
			// TODO: handle exception
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

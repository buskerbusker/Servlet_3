package com.iu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/memberController")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public memberController() {
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

			if (command.equals("memberJoin")) {

				if (method.equals("POST")) {

					MemberDTO memberDTO = new MemberDTO();
					String id = request.getParameter("id");
					String pw = request.getParameter("pw");
					String name = request.getParameter("name");
					int age = Integer.parseInt(request.getParameter("age"));
					int phone = Integer.parseInt(request.getParameter("phone"));
					String email = request.getParameter("email");

					memberDTO.setId(id);

					int result = memberService.memberJoin(memberDTO);
					path = "./memberJoin";
				}

			}
		} catch (Exception e) {
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

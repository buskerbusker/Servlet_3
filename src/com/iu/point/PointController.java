package com.iu.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PointService pointService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PointController() {
		super();
		this.pointService = new PointService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// pathinfo
		String command = request.getPathInfo();
		// method 형식
		String method = request.getMethod();
		// forward(true) redirect(false) 선택
		boolean check = true;
		// url을 담을 변수
		String path = "";
		try {
			if (command.equals("/pointList")) {

				try {
					ArrayList<PointDTO> ar = pointService.pointList();
					request.setAttribute("list", ar);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				path = "../WEB-INF/views/point/pointList.jsp";

			} else if (command.equals("/pointAdd")) {

				if (method.equals("POST")) {

					PointDTO pointDTO = new PointDTO();
					String name = request.getParameter("name");
					int num = Integer.parseInt(request.getParameter("num"));
					int kor = Integer.parseInt(request.getParameter("kor"));
					int eng = Integer.parseInt(request.getParameter("eng"));
					int math = Integer.parseInt(request.getParameter("math"));
					int total = Integer.parseInt(request.getParameter("total"));
					double avg = Integer.parseInt(request.getParameter("avg"));
					pointDTO.setName(name);
					pointDTO.setNum(num);
					pointDTO.setKor(kor);
					pointDTO.setEng(eng);
					pointDTO.setMath(math);
					pointDTO.setTotal(total);
					pointDTO.setAvg(avg);

					check = false;
					int result = pointService.pointAdd(pointDTO);
					path = "./pointList";

				} else {

					path = "../WEB-INF/views/point/pointAdd.jsp";
				}

			} else if (command.equals("/pointMod")) {

				if (method.equals("POST")) {

				} else {
					path = "../WEB-INF/views/point/pointMod.jsp";
				}

			} else if (command.equals("/pointSelect")) {

				int num = Integer.parseInt(request.getParameter("num"));
				PointDTO pointDTO = pointService.pointSelect(num);
				request.setAttribute("dto", pointDTO);
				path = "../WEB-INF/views/point/pointSelect.jsp";

			} else if (command.equals("/pointDelete")) {
				check = false;
				int num = Integer.parseInt(request.getParameter("num"));
				int result = pointService.pointDelete(num);
				path = "./pointList";

			} else {
				System.out.println("ETC");
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

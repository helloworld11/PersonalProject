package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {
	// 메서드오버라이딩 alt shift s v
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberFrontController doProcess()");
		// 1. 가상주소 /~~~.me 주소값 뽑아오기
		// URI /ShoppingMall/Main.me
		String requestURI = request.getRequestURI();
		System.out.println("URI주소 : " + requestURI);
		// 프로젝트주소 /ShoppingMall
		String contextPath = request.getContextPath();
		System.out.println("프로젝트주소 : " + contextPath);
		System.out.println("프로젝트주소 길이 : " + contextPath.length());
		// URI에서 가상주소 뽑아오기 /Main.me
		String command = requestURI.substring(contextPath.length());
		System.out.println("가상주소뽑기 : " + command);
		// 2. 주소값 비교 (jsp, 자바메서드호출())
		ActionForward forward = null;
		Action action = null;
		if (command.equals("/Main.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Main/Main.jsp");
		}else if(command.equals("/Joinreg.me")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Member/Joinreg.jsp");
		}else if(command.equals("/Join.me")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Member/Join.jsp");
		} 
		

		// 3. 이동
		// 이동정보 있는경우
		if (forward != null) {
			if (forward.isRedirect()) {
				// 이동방식 true sendRedirect
				response.sendRedirect(forward.getPath());
			} else {
				// 이동방식 false forward
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberFrontController doPost()");
		doProcess(request, response);
	}
}

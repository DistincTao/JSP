package com.jspbasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin3.do")
public class SessionLoginServlet_JSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionLoginServlet_JSTL() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		if (userId.equals("asdf") && userPw.equals("1234")) {
			HttpSession ses = request.getSession();
			
			ses.setAttribute("loginMemberId", userId);
			response.sendRedirect(request.getContextPath() + "/mainTest_JSTL.jsp?status=loginSuccess");

		}
	}
}

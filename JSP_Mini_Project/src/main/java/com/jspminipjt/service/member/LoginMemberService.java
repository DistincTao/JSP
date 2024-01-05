package com.jspminipjt.service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspminipjt.controller.MemberFactory;
import com.jspminipjt.dao.MemberDao;
import com.jspminipjt.dao.MemberDaoCRUD;
import com.jspminipjt.service.MemberService;
import com.jspminipjt.vo.MemberVo;

public class LoginMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberFactory mf = MemberFactory.getInstance();
		System.out.println("로그인 절차 시작");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		HttpSession sess = request.getSession();
		
		System.out.println(userId + " " + userPwd);
		
		MemberDao dao = MemberDaoCRUD.getInstance();
		
		try {
			MemberVo vo = dao.loginMember(userId, userPwd);
			
			
			if (vo != null) { // 로그인 성공
				System.out.println(vo.toString());
				sess.setAttribute("userId", userId);
				
			}
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mf;
	}

}

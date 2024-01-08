package com.jspminipjt.service.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspminipjt.controller.MemberFactory;
import com.jspminipjt.dao.MemberDao;
import com.jspminipjt.dao.MemberDaoCRUD;
import com.jspminipjt.service.MemberService;
import com.jspminipjt.vo.MemberPointVo;
import com.jspminipjt.vo.MemberVo;

public class MyPageService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원 맴버 정보 + pointlog 정보
		MemberFactory mf = MemberFactory.getInstance();
		MemberVo vo = null;
		List<MemberPointVo> list = null;
		String userId = request.getParameter("userId");
		
		System.out.println("조회할 멤버 아이디 : " + userId);
		
		MemberDao dao = MemberDaoCRUD.getInstance();
		
		try {
			vo = dao.getMemberInfo(userId);
			list = dao.getMembePointInfo(userId);
			
			request.setAttribute("memberInfo", vo);
			request.setAttribute("pointlog", list);
			
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		return null;
	}

}

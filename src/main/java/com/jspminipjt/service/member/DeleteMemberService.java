package com.jspminipjt.service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspminipjt.controller.member.MemberFactory;
import com.jspminipjt.dao.member.MemberDao;
import com.jspminipjt.dao.member.MemberDaoCRUD;
import com.jspminipjt.service.MemberService;

public class DeleteMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원 삭제 프로세스 진행");
		MemberFactory mf = MemberFactory.getInstance();
		MemberDao dao = MemberDaoCRUD.getInstance();
		String userId = request.getParameter("deleteMember");
		HttpSession sess = request.getSession();
		
		System.out.println(userId);
		int result = -1;
		
 		try {
			result = dao.deleteMember(userId);
			
			if (result == 1) {
				sess.removeAttribute("login");
				sess.invalidate();
				mf.setRedirect(true);
				mf.setWhereToGo(request.getContextPath() + "/index.jsp");
			}
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mf;
	}

}

package com.jspminipjt.service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspminipjt.controller.board.BoardFactory;
import com.jspminipjt.dao.board.BoardDao;
import com.jspminipjt.dao.board.BoardDaoCRUD;
import com.jspminipjt.service.BoardService;

public class LikeCountService implements BoardService {

	@Override
	public BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("좋아요 수 증가 진행 시작");
		BoardFactory bf = BoardFactory.getInstance();
		BoardDao dao = BoardDaoCRUD.getInstance();
		HttpSession sess = request.getSession();
		String userId = (String) sess.getAttribute("userId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String userIp = getIp(request);
		
		System.out.println(userId + " " + boardNo + " " + userIp);
		
		
		
		
		
		
		
		
		return bf;
	}

	private String getIp(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		System.out.println(">>>> X-Forwarded-For : " + ip);

		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
			System.out.println(">>>> Proxy-Client-IP : " + ip);
		}

		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			System.out.println(">>>> WL-Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			System.out.println(">>>> HTTP_CLIENT_IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			System.out.println(">>>> HTTP_X_FORWARDED_FOR : " + ip);
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		
		System.out.println(">>>> Result : IP Address : " + ip);

		
		return ip;

	}
	
}

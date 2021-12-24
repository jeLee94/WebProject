package jungeun_free.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jungeun_free.domain.*;

import jungeun_free.persistence.*;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		//request.setContentType("text/html; charset=UTF-8");
		String cmdReq="";
		cmdReq = request.getParameter("cmd");
		
		if(cmdReq.equals("join")) {
			response.sendRedirect("register.html");
		}
		else if(cmdReq.equals("list")) {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList",memberList);
			RequestDispatcher view = request.getRequestDispatcher("member_list.jsp");
			view.forward(request, response);
		}
		else if(cmdReq.equals("update")) {
			MemberDAO dao = new MemberDAO();
			MemberVO member = dao.read(request.getParameter("id"));
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		}
		else if(cmdReq.equals("delete")) {
			MemberDAO dao = new MemberDAO();
			MemberVO member = dao.read(request.getParameter("id"));
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("delete.jsp");
			view.forward(request, response);
		}
		else if(cmdReq.equals("contact")) {
			response.sendRedirect("contact.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq="";
		String message="";
		cmdReq = request.getParameter("cmd");
		if(cmdReq.equals("join")) {
			MemberVO memberVO = new MemberVO(); 
			
			memberVO.setID(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setMobile(request.getParameter("mobile"));
			memberVO.setAddress(request.getParameter("address"));
			memberVO.setEmail(request.getParameter("email"));
			
			MemberDAO memberDAO = new MemberDAO();
			
			if(memberDAO.add(memberVO) ) message = "가입을 축하합니다";
			else message = "가입 실패입니다";
			
			request.setAttribute("greetings", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		
		
		}
		else if(cmdReq.equals("update")) {
			MemberVO memberVO = new MemberVO();
			
			memberVO.setID(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd")); 
			memberVO.setUsername(request.getParameter("username"));
			memberVO.setMobile(request.getParameter("mobile"));
			memberVO.setAddress(request.getParameter("address"));
			memberVO.setEmail(request.getParameter("email"));
			
			
			MemberDAO dao = new MemberDAO();
			
			if(dao.update(memberVO)) message = "수정이 완료되었습니다.";
			else message = "수정 실패입니다.";
			
			request.setAttribute("greetings", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}	
		
		else if(cmdReq.equals("delete")) {
			MemberVO memberVO = new MemberVO();
			
			memberVO.setID(request.getParameter("id"));
			memberVO.setPasswd(request.getParameter("passwd"));
			
			MemberDAO dao = new MemberDAO();
			
			if(dao.delete(memberVO)) message = "탈퇴가 완료되었습니다.";
			else message = "탈퇴 실패입니다.";
			
			request.setAttribute("greetings", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}	
		
		else if(cmdReq.equals("contact")) {
			MemberVO memberVO = new MemberVO();
			
			memberVO.setID(request.getParameter("id"));
			memberVO.setEmail(request.getParameter("email"));
			memberVO.setMessage(request.getParameter("message"));
			
			MemberDAO dao = new MemberDAO();
			
			if(dao.contact(memberVO)) message = "문의가 완료되었습니다.";
			else message = "문의 실패입니다.";
			
			request.setAttribute("greetings", message);
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("c_result.jsp");
			view.forward(request, response);
		}	
	
	}

}

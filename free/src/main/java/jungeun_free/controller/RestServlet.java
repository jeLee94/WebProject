package jungeun_free.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jungeun_free.domain.*;
import jungeun_free.persistence.*;
/**
 * Servlet implementation class RestServelet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      response.setContentType("application/json;charset=UTF-8");
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      
      PrintWriter out = response.getWriter();
      
      String cmdReq, id;
      cmdReq = request.getParameter("cmd");
      id = request.getParameter("id");
      if(cmdReq == null) return;
      
      MemberDAO memberDAO = new MemberDAO();
      List<MemberVO> memberList = memberDAO.getMemberList();
      JSONArray arrayJson = new JSONArray();
       
      if (cmdReq.equals("list")) {
         try {
             for(MemberVO vo : memberList ) {
                JSONObject json = new JSONObject();
                json.put("id", vo.getID()); 
                json.put("passwd", vo.getPasswd()); 
                json.put("username", vo.getUsername()); 
                json.put("mobile", vo.getMobile()); 
                json.put("address", vo.getAddress()); 
                json.put("email", vo.getEmail()); 
                arrayJson.put(json);
             }
          } catch (JSONException e) {
             e.printStackTrace();
          }
          out.print(arrayJson);  
      }
      else if (cmdReq.equals("read")) {
         MemberDAO dao = new MemberDAO();
         MemberVO vo = new MemberVO();
         vo = dao.read(id);
         if (vo == null) {
            out.print("정보가 없습니다.");
         }
         else {
            JSONObject json = new JSONObject();
            try {           
                json.put("id", vo.getID()); 
                json.put("passwd", vo.getPasswd()); 
                json.put("username", vo.getUsername()); 
                json.put("mobile", vo.getMobile()); 
                json.put("address", vo.getAddress()); 
                json.put("email", vo.getEmail()); 
              } catch (JSONException e) {
                 e.printStackTrace();
              }
            out.print(json);
         }
      }
      else {
         out.println("RestServlet?cmd=list : 전체 정보");
         out.println("RestServlet?cmd=read&id=* :  id가 *인 정보 출력");
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
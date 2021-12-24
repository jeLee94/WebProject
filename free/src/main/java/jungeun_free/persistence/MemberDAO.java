package jungeun_free.persistence;
import java.sql.*;
import java.util.*;
import java.util.HashMap;

import jungeun_free.domain.*;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url= "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

	private static Map<String, MemberVO> storage = new HashMap<String, MemberVO>();
	
	public boolean join (MemberVO member) {
		try {
			storage.put(member.getID(), member);
			storage.put(member.getPasswd(), member);
			storage.put(member.getUsername(), member);
			storage.put(member.getAddress(), member);
			storage.put(member.getMobile(), member);
			storage.put(member.getEmail(), member);
			storage.put(member.getMessage(), member);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"jspbook","passwd");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}	
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean add(MemberVO vo) {
		connect();
		String sql = "insert into members values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getID());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getMobile());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<MemberVO> getMemberList(){
		connect();
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		String sql = "select * from members";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setID(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUsername(rs.getString("username"));
				vo.setMobile(rs.getString("mobile"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				memberlist.add(vo);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return memberlist;
	}


	public boolean update(MemberVO vo) {
	      connect();
	      
	      String sql = "update members set id=?, passwd=?, username=?, mobile=?, address=?, email=? where id=?;";  
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, vo.getID());
	         pstmt.setString(2, vo.getPasswd());
	         pstmt.setString(3, vo.getUsername());
	         pstmt.setString(4, vo.getMobile());
	         pstmt.setString(5, vo.getAddress());
	         pstmt.setString(6, vo.getEmail());
	         pstmt.setString(7, vo.getID());
	         pstmt.executeUpdate();         
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	      } finally {
	         disconnect();
	      }
	      
	      return true;      
	   }

	   
	   public MemberVO read(String id) {
	      connect();
	      String sql = "select * from members where id=?;";   
	      
	      MemberVO vo = new MemberVO();      
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         ResultSet rs = pstmt.executeQuery();            
	         rs.next();      
	         vo.setID(rs.getString("id"));
	         vo.setPasswd(rs.getString("passwd"));
	         vo.setUsername(rs.getString("username"));
	         vo.setMobile(rs.getString("mobile"));
	         vo.setAddress(rs.getString("address"));
	         vo.setEmail(rs.getString("email"));
	      } catch(SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      
	      return vo;   
	   }
	   
		public boolean delete(MemberVO vo) {
		      connect();
		      
		      String sql = "delete from members where id=?;";  
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, vo.getID());
		         pstmt.executeUpdate();         
		      } catch (SQLException e) {
		         e.printStackTrace();
		         return false;
		      } finally {
		         disconnect();
		      }
		      
		      return true;      
		   }
		
		public boolean contact(MemberVO vo) {
		      connect();
		      
		      String sql = "insert into message values(?,?,?);";  
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, vo.getID());
		         pstmt.setString(2, vo.getEmail());
		         pstmt.setString(3, vo.getMessage());		        
		         pstmt.executeUpdate();         
		      } catch (SQLException e) {
		         e.printStackTrace();
		         return false;
		      } finally {
		         disconnect();
		      }
		      
		      return true;      
		   }


}

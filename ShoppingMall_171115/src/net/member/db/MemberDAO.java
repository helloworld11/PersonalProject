package net.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanAttributeInfo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.util.modeler.modules.MbeansDescriptorsDigesterSource;

import com.sun.org.apache.xml.internal.security.Init;

import jdk.nashorn.internal.runtime.arrays.ArrayData;



public class MemberDAO {
	
	//DB연결함수
	private Connection getConnection() throws Exception {
	/*	String dbUrl = "jdbc:mysql://localhost:3306/jspdb2";
		// 데이터베이스사용자
		String dbUser = "jspid";
		// 데이터베이스사용자비밀번호
		String dbPass = "jsppass";
		Connection con = null;
		//드라이버로더
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 디비연결
		//데이터베이스주소
		con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		return con;*/
		
		Connection con = null;
		//context 객체생성
		Context init=new InitialContext();
		// DataSource ds= 메서드 호출 lookup(자원의 이름)
		DataSource ds =(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		//con =getconnection()
		con=ds.getConnection();
		return con;
	}
	
	
	
	
	
	
	// 멤버변수
	// 생성자
	// 메서드(멤버함수)
	// public 리턴할형 insertMember(폼에서 입력받은 데이터주소값을 받을 변수){
	public void insertMember(MemberBean mb) {
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		try {
			// 예외발생 명령문
			// 1단계 드러이버로더	// 2단계 디비연결	함수호출
			con = getConnection();
			// 3단계 sql insert
			sql = "insert into member(id,pass,name,reg_date,age,gender,email) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPass());
			pstmt.setString(3, mb.getName());
			pstmt.setTimestamp(4, mb.getReg_date());
			pstmt.setInt(5, mb.getAge());
			pstmt.setString(6, mb.getGender());
			pstmt.setString(7, mb.getEmail());
			
			// 4단계 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			// 예외처리
			e.printStackTrace();
		} finally {
			// 마무리 객체닫기
			if(pstmt!=null) try{pstmt.close();}catch(SQLException se){}
			if(con!=null) try{con.close();}catch(SQLException se){}
		}
	}// insertMember()

	public int userCheck(String id,String pass){
		// int 자바에서 만든 데이터형 리턴 타입
		Connection con=null;
		String sql="";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int check=-1;
		try {
			con = getConnection();
			//3단계 sql select pass가져오기  조건 id에 해당하는
			sql="select pass from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			//4단계  rs <= 실행
			rs=pstmt.executeQuery();
			//5단계 rs 첫행이동 데이터 있으면
			//    비밀번호비교 맞으면  check=1 
			//            틀리면  check=0
			//    데이터 없음 check=-1
			if(rs.next()){
				//데이터있으면 "아이디있음"
				if(pass.equals(rs.getString("pass"))){
					//비밀번호맞음
					check=1;
				}else{
					//비밀번호틀림
					check=0;
				}
			}else{
				//데이터 없으면 "아이디없음"
				check=-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException se){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException se){}
			if(con!=null) try{con.close();}catch(SQLException se){}
			
		}
		return check;
	}// userCheck()

	public MemberBean getMember(String id){
		// MemberBean 내가만든 자료형
		
		Connection con=null;
		String sql=""; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberBean mb =new MemberBean();

		try{
			con=getConnection();
			sql="select * from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			//4단계 rs 실행저장
			rs=pstmt.executeQuery();
			//rs = id 조회결과
		
			//5단계 rs 첫행으로 이동 데이터 있으면
			//rs에 있는 "id"열→MemberBean 변수id 저장
			while(rs.next()){
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException se){}
			if(pstmt!=null) try{rs.close();}catch(SQLException se){}
			if(con!=null) try{rs.close();}catch(SQLException se){}
		}
		return mb;
		
	}
	

	
	
	
	
	
	//접근지정자 //리턴할형 //함수명 //(업데이트하러 갈때 이정보를 담아주는데 내가만든자료형// id)
	public int updateMember(MemberBean mb) {
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int check=-1;
		try {
			// 예외발생 명령문
			// 1단계 드러이버로더
			con=getConnection();
			// 3단계 sql insert
			sql="select pass from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			// 4단계 실행 → 결과저장
			 rs=pstmt.executeQuery();;
			if(rs.next()){
				//데이터있으면 "아이디있음"
				if(mb.getPass().equals(rs.getString("pass"))){
					//비밀번호맞음
					check=1;
					sql = "update member set name=?, age=?, email=?, gender=? where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mb.getName());
					pstmt.setInt(2, mb.getAge());
					pstmt.setString(3, mb.getEmail());
					pstmt.setString(4, mb.getGender());
					pstmt.setString(5, mb.getId());
					
					//4단계 sql객체를 실행
					pstmt.executeUpdate();
					
				}else{
					//비밀번호틀림
					check=0;
				}
			}else{
				//데이터 없으면 "아이디없음"
				check=-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException se){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException se){}
			if(con!=null) try{con.close();}catch(SQLException se){}
		}
		return check;
	}// userCheck()

	

	public int deleteMember(String id,String pass){
		
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		MemberBean mb =new MemberBean();
		int check=-1;
		try {
			// 예외발생 명령문
			con=getConnection();
			// 3단계 sql insert
			sql="select pass from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			// 4단계 실행 → 결과저장
			ResultSet rs=pstmt.executeQuery();;
			if(rs.next()){
				//데이터있으면 "아이디있음"
				if(pass.equals(rs.getString("pass"))){
					//비밀번호맞음
					check=1;
					sql = "delete from member where id=? and pass=?";
					pstmt=con.prepareStatement(sql);
					//sql 실행할 객체를 생성한다.
					pstmt.setString(1,id);
					pstmt.setString(2, pass);
					//4단계 sql객체를 실행
					pstmt.executeUpdate();
					
				}else{
					//비밀번호틀림
					check=0;
				}
			}else{
				//데이터 없으면 "아이디없음"
				check=-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}return check;
	}
	public List getMemberList(){
		//list memberList 객체생성
		//5명 회원 저장
		//5명저장할 기억공간 생성
		List memberList =new ArrayList();
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet  rs=null;
		//모든 참조형 변수는 null로..
		try{
			con=getConnection();
			//1,2 디비연결 메서드호출
			sql="select * from member";
			pstmt=con.prepareStatement(sql);
			//3 sql member모든 데이터 가져오기
			rs=pstmt.executeQuery();
			//4 rs = 실행
			while(rs.next()){
			//5 while rs커서 다음행이동했을때
				MemberBean mb=new MemberBean();
				//   MemberBean mb 객체 생성 
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("Pass"));
				mb.setName(rs.getString("Name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				//   멤버변수 = rs정보 저장
				memberList.add(mb);
				//   memberList 배열 한칸에 mb 저장	
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException se){}
			if(pstmt!=null) try{rs.close();}catch(SQLException se){}
			if(con!=null) try{rs.close();}catch(SQLException se){}
		
		
		}return memberList;	
	
	}
	
	
	
	
	
	
	
}// 클래스
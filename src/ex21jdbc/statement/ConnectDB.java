package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//객체생성 목적 아닌 상속 목적 정의된 추상클래스
public abstract class ConnectDB
{
	/*
	 멤버변수: 상속받은 하위클래스 접근 허용 위해 접근 지정자 protected선언
	 */
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	
	//UpdateSQL에서 사용할 생성자
	public ConnectDB(String id, String pw) {
		try {
			//드라이버로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//커넥션(매개변수 전달된 id, pw통해 연결)
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl", id, pw);
			System.out.println("오라클DB연결 성공");
			
		}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알수없는 예외발생");
		}
	}
	public ConnectDB() {
		try {
			//1.오라클 드라이버로드
			Class.forName("oracle.jdbc.OracleDriver");
	//2.커넥션 객체 통해 연결
	con = DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:orcl",
			"kosmo", "1234");
	System.out.println("오라클 DB연결성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버로딩실패");
			e.printStackTrace();
		}
	catch(SQLException e) {
		System.out.println("DB연결 실패");
		e.printStackTrace();
	}
		catch(Exception e) {
		System.out.println("알수없는 예외발생");
	}
}
	//자원반납 위한 메소드
	public void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납 오류 발생");
		}
	}//end of close
	
	/*
	 오버라이딩 목적으로 정의한 추상메소드
	 */
	abstract void execute();
	}

package ex21jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IConnectImpl implements Iconnect {

	//동적쿼리처리를 위한 객체
	public PreparedStatement psmt;
	public Connection con;
	
	public ResultSet rs;
	
	public IConnectImpl() {
		System.out.println("IConnectImpl기본생성자 호출");
	}
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl인자생성자 호출");
		try {
			//드라이버로드
			Class.forName(ORACLE_DRIVER);
			//DB연결
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
			e.printStackTrace();
			
		}
	}
	
	//오라클 DB 실제접속
	@Override
	public void connect(String user, String pass)
	{
	try {
		con = DriverManager.getConnection(ORACLE_URL, user, pass);
	}
	catch(SQLException e) {
		System.out.println("데이터베이스 연결오류");
		e.printStackTrace();
	}
}


	/*오버라이딩 목적 메소드 쿼리실행 각클래스 진행
	
	 
	 */
	@Override
	public void execute() 
	{
		// 하는일 X
		
	}
	@Override
	public void close() {
	try {
		if(con!=null) con.close();
		if(psmt!=null) psmt.close();
		if(rs!=null) rs.close();
		System.out.println("자원반납완료");
	}
	catch(Exception e) {
		System.out.println("자원 반납 오류발생");
		e.printStackTrace();
	}
	}
	
	//사용자로부터 입력값 받는 메소드
	@Override
	public String scanValue(String title)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을 입력(exit->종료):");
		String inputStr = scan.nextLine();
		
		/*
		 equalsIgnoreCase()
		 : equals()메소드 동일하게 문자열 같은지 비교하는 메소드
		 다른점 대소문자 구분안함X
		 */
		
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램 종료");
			close();
			//프록그램 자체 종료
			System.exit(0);
	}
		return inputStr;
}
}

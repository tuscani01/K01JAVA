package ex21jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class DBCONNECTION
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		/*
		 JDBC 프로그래밍절차
		 1] 오라클용 JDBC드라이버 메모리 로드함
		 :new 사용하지 않고 클래스명으로 직접 찾아서 객체 생성후 메모리 로드 forName()메소드 사용
		 메모리 로딩된 드라이버 DriverManager라는 클래스 등록
		 
		 */
		Class.forName("oracle.jdbc.OracleDriver");
		/*
		 2]오라클 연결하기 위한 커넥션URL, 계정ID, 패스워드 준비한다
		 커넥션URL =>
		jdbc:oracle:thin://@ip주소:1521포트번호:SID
		서버환경 따라 ip,포트번호,sid는 변경
		 */
		
		String url = "jdbc:oracle:thin://@localhost:1521:orcl";
				String userid = "hr";
		String userpw = "1234";
		
		/*
		 2-1] DriverManager클래스 getConnection()메소드 호출해 오라클 연결시도 연결 성공시 연결된 주소 반환한다
		 */
		
		Connection con = DriverManager.getConnection(url, userid, userpw);
		
		if(con!=null) {System.out.println("Oracle DB연결");
		
		/*
		 3]쿼리문작성
		 : 쿼리문 작성할때 주의할점 줄바꿈 할때 앞뒤로 스페이스 넣는것 중요하다 공간 없으면 문장이 이어져 syntaxerror가 발생하게된다
		 */
		String sql = "select * from employees where " + " department_id=50 " + " order by employee_id desc";
		
		/*
		 4] 쿼리문 전송 위한 statement계열 객체 생성 해당 객체 ㅜ로 정적인 쿼리 실행할때 사용된다
		 */
		
		Statement stmt = con.createStatement();
		
		/*
		 5] statement 객체 사용해 오라클로 작성된 쿼리문 전송한다 오라클은 전송받은 쿼리를 실행후 결과를 반환하는데 이를 ResultSet객체 통해 받는다
		 */
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			/*
			 오라클 반환해준 ResultSet객체 객수만큼 반복하며 콘솔에 출력한다
			 getXXX()계열의 함수 인자로는 select절의 순서대로 '인덱스'를 쓸수 있고 '컬럼명'을 쓸수도있다
			 */
			String emp_id = rs.getString(1); //employee_id 컬럼
			String f_name = rs.getString("first_name"); //컬럼명 그대로 이용
			String l_name = rs.getString(3);
			java.sql.Date h_date = rs.getDate("hire_date");
			int sal = rs.getInt("salary");
			
			System.out.printf("%s %s %s %s %s%n", emp_id, f_name, l_name, h_date, sal);
		}
		/*
		 6]자원반납: 모든작업 마친후 메모리 절약위해 연결했던 자원을 반납한다
		 */
		rs.close();
		stmt.close();
		con.close();
		
		}
		else {
			System.out.println("연결실패");
		}
		
	}

}

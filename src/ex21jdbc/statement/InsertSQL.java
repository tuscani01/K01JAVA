package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL
{
	//멤버변수
	Connection con; //DB연결위한 객체
	Statement stmt; //쿼리전송 및 실행 위한 객체
	
	//생성자
	public InsertSQL() {
		try {
			//1. 오라클 드라이버로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.커넥션 객체 통해 db연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"kosmo",
					"1234");
			System.out.println("오라클 DB연결 성공");			
		}
		catch (ClassNotFoundException e) {
			//ojdbc6.jar 파일이 없거나 연동되지 않았을때 예외발생
			System.out.println("오라클 드라이버 로딩실패");
			e.printStackTrace();
		}
		catch (SQLException e) {
			//계정명, 커넥션url이 잘못된경우
			System.out.println("db연결 실패");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알수없는 예외발생");
		}
	}//end of InsertSQL

	//쿼리작성및 실행메소드
	private void execute() {
		try {
			//3.Statement 객체 생성위한 메소드 호출
			stmt = con.createStatement();
			
			//4.SQL(쿼리문) 작성
			String sql = "INSERT INTO member VALUES "
					+ " ('test1', '1111', '홍길동', SYSDATE) ";
			
			//5.쿼리실행 및 결과값 반환
			/*
			 executeUpdate() : 쿼리문이 insert/update/delete 같이 기존 레코드 영향 미친 쿼리 실행할때 사용
			 실행후 영향 받은 행개수(int)가 반환된다
			 
			 executeQuery() : 쿼리문이 select일때 호출하는 메소드 레코드 영향 미치지 않는 쿼리를 실행한다 즉 조회만
			 진행하고 반환타입은 ResultSet이다
			 
			 */
			int  affected = stmt.executeUpdate(sql);
			System.out.println(affected +"행이 입력되었다");
		}
		catch(SQLException e) {
			System.out.println("쿼리실행 문제 발생");
					e.printStackTrace();
		}
		finally {
			//6.자원반납
			close();
					
	}
}//end of execute
private void close() {
		try {
			if(stmt!=null) stmt.close(); //statement객체 자원반납
			if(con!=null) con.close(); //connection객체 자원반납
			System.out.println("DB자원반납완료");
		}
		catch(SQLException e) {
			System.out.println("자원반납시 오류가 발생하였다");
		}
	}//end of close
public static void main(String[] args) {
	
	//실행방법1: 객체생성후 참조변수에 대입후 메소드 호출
//	InsertSQL iSQL = new InsertSQL();
//	iSQL.execute();
	
	//실행방법2: 참조변수 없이 객체생성과 동시에 메소드호출
	new InsertSQL().execute();
	
}//end of main
}
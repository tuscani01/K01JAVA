package ex21jdbc.statement;

import java.sql.SQLException;

public class SelectSQL1 extends ConnectDB {
{
	//생성자메소드
	public SelectSQL() {
		super();
	}
	
	
	/*
	ResultSet클래스
	: select문 실행시 쿼리 실행결과가 ResultSet객체 저장된다 결과로 반환된 레코드 
	처음부터 마지막까지 next()메소드 통해 확인후 반복 추출한다
	
	-getXXX()계열 메소드
	오라클 자료형
	number타입: getInt()
	char/varchar2타입: getString()
	date타입: getDate()
	메소드 각 컬럼 데이터 추출한다
	-인자는 selece절 컬럼 순서대로 인덱스(1부터시작) 사용하거나
	컬럼명 사용할수있다
	-자료형 상관없이 getString()로 모든 데이터 추출할수있다
	
	 */
	
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT id, pass, name, regidate " + FROM member";
					rs = stmt.executeQuery(query);
			while(rs.next()) {
					String id = rs.getString(1);
					String pw = rs.getString("pass");
					String name = rs.getString("name");
					/*
					오라클 date타입 getDate()로 추출하면
					2020-03-25 형태로 출력 이럴때 date형 자료라서 java.sql.Date클래스 참조변수로 저장해야한다
					 */
					
					
					
					java.sql.Date regidate = rs.getDate("regidate");
					
					System.out.printf("%-10s %-10s %-13s %-20s\n", id, pw,
							name, regidate);
				
		}
	}
	catch(SQLException e) {
		System.out.println("쿼리오류발생");
		e.printStackTrace();
	}
		finally {
			close(); //DB자원반납
		}
	}
	
	public static void main(String[] args)
	{
		SelectSQL selectSQL = new SelectSQL();
		selectSQL.execute();
	}

}

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
	-인자는 select절 컬럼 순서대로 인덱스(1부터시작) 사용하거나
	컬럼명 사용할수있다
	-자료형 상관없이 getString()로 모든 데이터 추출할수있다
	
	 */
	
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT id, pass, name, "
					+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') format1"
					+ " regidate "
					+ " FROM member "
					+ " ORDER BY regidate DESC";
					rs = stmt.executeQuery(query);
					
			while(rs.next()) {
					String id = rs.getString(1);
					String pw = rs.getString("pass");
					String name = rs.getString("name");
					/*
					날짜 to_char() 함수 이용해 문자형 변환하였으며 추출시 getDate() 사용할수없다
					그리고 컬럼명 대신 별칭 사용한다
					 */
					
					
					
					String regidate = rs.getString("format1");
					/*
					 오라클 date형 getString()으로 추출하면
					 2020-03-25 11:59:09 형태로 시간까지 출력된다
					 만약 날짜 문자열 잘라서 출력하고 싶을때 substring()을 활용한다
					 
					 */
					//String regidate2 = rs.getString("regidate");
					String regidate2 = rs.getString("regidate").substring(0,13);
					/*
					 날짜 시간까지 잘라서 출력(분 이후 출력 X)
					 */
					
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

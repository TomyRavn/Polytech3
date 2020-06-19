package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {
	public static void main(String[] args) {
		//"1.학생목록 2.학생추가 3.학생삭제 4.종료" 라고 메뉴를 출력
		//번호를 입력받는다
		//"1"을 입력한 경우, student 테이블에 존재하는 모든 학생 목록을 출력
		//"2"를 입력한 경우, 학번, 이름, 성적을 입력받아서 student 테이블에 저장
		//"3"을 입력한 경우, "삭제할 학생의 학번 입력 : "라고 출력하고, 해당 학생을 테이블에서 삭제
		//"4"를 입력한 경우, 프로그램을 종료
		//"5.성적 변경" 메뉴를 추가
		//"5"을 입력한 경우,
		//"성적을 변경할 학생의 학번을 입력하세요"라고 출력하고, 학번을 입력받는다.
		//입력받은 학번의 학생의 학번, 이름, 성적을 출력한다.
		//"변경할 성적을 입력하세요"라고 출력하고, 성적을 입력받는다.
		//해당 학생의 성적을 입력한 성적으로 테이블에서 변경
		//위 작업을 무한 반복
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "com";
		String password = "com01";
		String sql = "";

		while (flag) {

			System.out.println("1.학생목록 2.학생추가 3.학생삭제 4.종료 5.성적변경");
			String input = sc.nextLine();

			switch(input) {
			case "1":
				sql = "SELECT stu_no, stu_name, stu_score FROM student";

				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						) {

					while(rs.next()) {
						String stuNo = rs.getString("stu_no");
						String stuName = rs.getString("stu_name");
						int stuScore = rs.getInt("stu_score");

						System.out.println(stuNo + " : " + stuName + " : " + stuScore);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("==============================");
				break;

			case "2":
			{
				System.out.println("추가할 학생의 '학번'을 입력하세요");
				String stuNo = sc.nextLine();
				System.out.println("추가할 학생의 '이름'을 입력하세요");
				String stuName = sc.nextLine();
				System.out.println("추가할 학생의 '성적'을 입력하세요");
				int stuScore = Integer.parseInt(sc.nextLine());

				sql = "INSERT INTO student (stu_no, stu_name, stu_score) "
						+ "VALUES (?, ?, ?)";

				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {

					pstmt.setString(1, stuNo);
					pstmt.setString(2, stuName);
					pstmt.setInt(3, stuScore);

					int num = pstmt.executeUpdate();
					System.out.println(num + "개의 레코드가 추가 되었습니다.");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;

			case "3":
			{
				System.out.print("삭제할 학생의 학번 입력 : ");
				String stuNo = sc.nextLine();

				sql = "DELETE FROM student WHERE stu_no = ?";

				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {

					pstmt.setString(1, stuNo);

					int num = pstmt.executeUpdate();					//저장은 안하더라도 업데이트 하지 않으면 반영되지 않음
					System.out.println(num + "개의 레코드가 삭제 되었습니다.");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;

			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;

			case "5":
				System.out.println("성적을 변경할 학생의 학번을 입력하세요");
				String altNo = sc.nextLine();

//				{
//					//출력
//					sql = "SELECT stu_no, stu_name, stu_score from student where stu_no = " + "'" + altNo + "'";
//
//					try (
//							Connection conn = DriverManager.getConnection(url, user, password);
//							PreparedStatement pstmt = conn.prepareStatement(sql);
//							ResultSet rs = pstmt.executeQuery();
//							) {
//
//						while(rs.next()) {
//							String stuNo = rs.getString("stu_no");
//							String stuName = rs.getString("stu_name");
//							int stuScore = rs.getInt("stu_score");
//
//							System.out.println(stuNo + " : " + stuName + " : " + stuScore);
//						}
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
				
				{
					//출력
					sql = "SELECT stu_no, stu_name, stu_score FROM student WHERE stu_no = ?";

					try (	/*클로즈 할 수 있지 않으면 들어갈 수 없음*/
							Connection conn = DriverManager.getConnection(url, user, password);
							PreparedStatement pstmt = conn.prepareStatement(sql);
							
//							//실행하기 전에 집어 넣어야한다
//							pstmt.setString(1, altNo);
							
//							ResultSet rs = pstmt.executeQuery();
							) {

						//pstmt.setString(1, altNo);
						//ResultSet rs = pstmt.executeQuery();		//rs의 위치가 setString보다 앞서면 컴파일 에러가 난다.. 왜??
						//rs를 pstmt보다 먼저 닫으면 rs를 가져올 수 없다?		'?'는 왜 기능이 정상작동하는지??
						
						pstmt.setString(1, altNo);
						
						try (
								ResultSet rs = pstmt.executeQuery();	
								){
							/*0~1명 밖에 안되니까 while 대신 if를 쓰는게 옳다*/
							if(rs.next()) {
								String stuNo = rs.getString("stu_no");
								String stuName = rs.getString("stu_name");
								int stuScore = rs.getInt("stu_score");

								System.out.println(stuNo + " : " + stuName + " : " + stuScore);
								
								
								System.out.println("변경할 성적을 입력하세요");
								int altScore = Integer.parseInt(sc.nextLine());

								sql = "UPDATE student SET stu_score = ? WHERE stu_no = ?";

								try (
										Connection conn2 = DriverManager.getConnection(url, user, password);
										PreparedStatement pstmt2 = conn2.prepareStatement(sql);
										) {

									pstmt2.setInt(1, altScore);
									pstmt2.setString(2, altNo);
									
									//pstmt.executeUpdate();
									int num = pstmt2.executeUpdate();		//executeUpdate() 하지 않으면 업데이트 되지 않음
									System.out.println(num + "개의 레코드가 변경 되었습니다.");

								} catch (SQLException e) {
									e.printStackTrace();
								}

								
							}
						}/*catch는 안해도 된다. 외부에 이미 catch가 있으니까*/

						//rs.close();									//rs 닫음(근데 try때만 실행됨..) -> 질문해야함

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
				//잘못된 학번 입력시에 굳이 변경 입력 필요없음
//				System.out.println("변경할 성적을 입력하세요");
//				int altScore = Integer.parseInt(sc.nextLine());
//
//				sql = "UPDATE student SET stu_score = ? where stu_no = ?";
//
//				try (
//						Connection conn = DriverManager.getConnection(url, user, password);
//						PreparedStatement pstmt = conn.prepareStatement(sql);
//						) {
//
//					pstmt.setInt(1, altScore);
//					pstmt.setString(2, altNo);
//					
//					//pstmt.executeUpdate();
//					int num = pstmt.executeUpdate();		//executeUpdate() 하지 않으면 업데이트 되지 않음
//					System.out.println(num + "개의 레코드가 변경 되었습니다.");
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				break;

			default:
				break;
			}
		}




	}
}
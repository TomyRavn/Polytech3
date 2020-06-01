package kr.ac.kopo.exapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {

	public static void main(String[] args) {
		//1.학생 목록 2.학생 추가 3.학생 삭제 4.종료 라고 메뉴를 출력
		//번호를 입력 받는다.
		//"1"을 입력한 경우 Student 테이블에 존재하는 모든 회원 목록을 출력
		//"2"를  학번, 이름, 성적을 입력받아서 데이터 베이스의 Student테이블에 저장하고,
		//"3"를 입력한 경우, "삭제할 학생의 학번 : "라고 출력하고, 입력한 학생을 Student 테이블에서 삭제
		//"4"를 입력한 경우, 프로그램을 종료
		//위 작업을 무한 반복
		
		//"5.성적 변경" 메뉴를 추가
		//"5"를 입력한 경우, 
		//"성적을 변경할 학생의 학번을 입력하세요" 라고 출력하고, 학번을 입력 받는다.
		//입력 받은 학번의 학생의 학번, 이름, 성적을 출력한다.
		//"변경할 성적을 입력하세요."라고 출력하고, 성적을 입력 받는다. 
		//해당 학생의 성적을 입력한 성적으로 테이블에서 변경
				
				try {
					Class.forName("new oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "com";
				String password = "com01";
				

				Scanner sc = new Scanner(System.in);
				
				boolean flag = true;
				while (flag) {
					System.out.println("1.학생 목록 2.학생 추가 3.학생 삭제 4.종료 5.성적 변경");
					String menu = sc.nextLine();
					
					switch (menu) {
					case "1":
						
						String sql = "SELECT stu_no, stu_name, stu_score FROM student";

						try (Connection conn = DriverManager.getConnection(url, user, password);
								PreparedStatement pstmt = conn.prepareStatement(sql);
								ResultSet rs = pstmt.executeQuery();) {

						while (rs.next()) {
							String stno = rs.getString("stu_no");
							String stname = rs.getString("stu_name");
							String stscore = rs.getString("stu_score");
							System.out.println(stno + ":" + stname + ":" + stscore);

						}

						} catch (SQLException e) {
						e.printStackTrace();
						}
						break;
				
					
					case "2" :
							System.out.println("이름을 입력하세요");
							String stno = sc.nextLine();
							System.out.println("학번을 입력하세요");
							String stname = sc.nextLine();
							System.out.println("점수를 입력하세요");
							int stscore = Integer.parseInt(sc.nextLine());
							try {
								Class.forName("new oracle.jdbc.OracleDriver");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							
							sql = "INSERT INTO student (stu_no, stu_name, stu_score) " + "VALUES (?,?,?)";
							try (Connection conn = DriverManager.getConnection(url, user, password);
							PreparedStatement pstmt = conn.prepareStatement(sql);) {		
							pstmt.setString(1, stno); 
							pstmt.setString(2, stname); 
							pstmt.setInt(3, stscore); 
							int num = pstmt.executeUpdate();
							System.out.println(num + "명의 학생 추가");

							} catch (SQLException e) {
									e.printStackTrace();
							}break;
					
					case "3" : 
							{System.out.println("삭제할 학생의 학번 : ");
							String delstno = sc.nextLine();
							{
								sql = "DELETE FROM member where stu_no = ?";

							try(
								Connection conn = DriverManager.getConnection(url, user, password);		
								PreparedStatement pstmt = conn.prepareStatement(sql);
							) {
								pstmt.setString(1, delstno); 
								int num = pstmt.executeUpdate(); 
								System.out.println(num + "명의 학생 삭제");

							} catch (SQLException e) {
							e.printStackTrace();
							} 
							}
							}
							break;
						
						
					case "4":
							flag = false;
							break;
							
					case "5":
						System.out.println("성적을 변경할 학생의 학번을 입력하세요");
						String delstno = sc.nextLine();
						sql = "SELECT stu_no, stu_name, stu_score FROM student";

						try (Connection conn = DriverManager.getConnection(url, user, password);
								PreparedStatement pstmt = conn.prepareStatement(sql);
								ResultSet rs = pstmt.executeQuery();) {

						while (rs.next()) {
							stno = rs.getString("stu_no");
							stname = rs.getString("stu_name");
							stscore = rs.getInt("stu_score");
							System.out.println(stno + ":" + stname + ":" + stscore);
							break;
					
							
					default:
							break;
				}
						
			}


			}
		}

		
	}




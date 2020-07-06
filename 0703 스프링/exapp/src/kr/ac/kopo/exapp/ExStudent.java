package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {

	public static void main(String[] args) {
		// 1.학생 목록 2.학생 추가 3.학생 삭제 4.종료 라고 메뉴를 출력
		// 번호를 입력 받는다.
		// "1"을 입력한 경우 Student 테이블에 존재하는 모든 회원 목록을 출력
		// "2"를 학번, 이름, 성적을 입력받아서 데이터 베이스의 Student테이블에 저장하고,
		// "3"를 입력한 경우, "삭제할 학생의 학번 : "라고 출력하고, 입력한 학생을 Student 테이블에서 삭제
		// "4"를 입력한 경우, 프로그램을 종료
		// 위 작업을 무한 반복

		// "5.성적 변경" 메뉴를 추가
		// "5"를 입력한 경우,
		// "성적을 변경할 학생의 학번을 입력하세요" 라고 출력하고, 학번을 입력 받는다.
		// 입력 받은 학번의 학생의 학번, 이름, 성적을 출력한다.
		// "변경할 성적을 입력하세요."라고 출력하고, 성적을 입력 받는다.
		// 해당 학생의 성적을 입력한 성적으로 테이블에서 변경

		try {
			Class.forName("oracle.jdbc.OracleDriver");
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
						ResultSet rs = pstmt.executeQuery();) { // 실행 결과 레코드

					while (rs.next()) {// 다음 레코드로 이동하고, 다음 레코드가 없으면 false
						String stno = rs.getString("stu_no"); // 현재 rs가 가르키는 레코드
						String stname = rs.getString("stu_name"); // 현재 rs가 가르키는 레코드
						String stscore = rs.getString("stu_score"); // 현재 rs가 가르키는 레코드
						System.out.println(stno + " : " + stname + " : " + stscore);

					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case "2":
				System.out.println("학번을 입력하세요");
				String stno = sc.nextLine();
				System.out.println("이름을 입력하세요");
				String stname = sc.nextLine();
				System.out.println("점수를 입력하세요");
				int stscore = Integer.parseInt(sc.nextLine());

				// sql 문에서 변화하는 값은 ?로 표시
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
				}
				break;

			case "3": {
				System.out.println("삭제할 학생의 학번 : ");
				String delstno = sc.nextLine();
				{
					sql = "DELETE FROM student WHERE stu_no = ?";

					try (Connection conn = DriverManager.getConnection(url, user, password);
							PreparedStatement pstmt = conn.prepareStatement(sql);) {
						pstmt.setString(1, delstno);
						int num = pstmt.executeUpdate(); // 실행 결과 변경된 레코드 수를 반환
						System.out.println(num + "명의 학생 삭제");

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
				break;

			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;

			case "5":
				System.out.println("성적을 변경할 학생의 학번을 입력하세요");
				String No = sc.nextLine();

				sql = "SELECT stu_no, stu_name, stu_score FROM student WHERE stu_no = ?";

				try (Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, No); // No 값을 첫 번째 물음표에 채워라.
					try (ResultSet rs = pstmt.executeQuery();) // 실행결과 레코드들을 가리키고 있는 resultset 값 반환
					{
						if (rs.next()) {
							String stuNo = rs.getString("stu_no");
							String stuName = rs.getString("stu_name");
							int stuScore = rs.getInt("stu_score");
							System.out.println(stuNo + " : " + stuName + " : " + stuScore);

							System.out.println("변경할 성적을 입력하세요");
							int Score = Integer.parseInt(sc.nextLine());

							String sql2 = "UPDATE student SET stu_score = ? WHERE stu_no = ?";

							try (Connection conn2 = DriverManager.getConnection(url, user, password);
									PreparedStatement pstmt2 = conn.prepareStatement(sql2);) {

								pstmt2.setInt(1, Score);
								pstmt2.setString(2, No);
								int num = pstmt2.executeUpdate(); // 실행결과 변경된 레코드값 반환
								System.out.println(num + "개의 레코드가 변경 되었습니다.");

							} catch (SQLException e) {
								e.printStackTrace();
							}

						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			default:
				break;
			}
		}

	}
}
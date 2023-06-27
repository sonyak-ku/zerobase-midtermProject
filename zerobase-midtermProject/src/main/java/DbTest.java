import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTest {
	private String dbFile = "C:\\Dev\\sqlite\\zerobaseWifiProject.sqlite3";

	public void dbSelect() {
		// 1. 드라이버로드
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 커넥션 객체 생성
		Connection con = null;
		java.sql.Statement statement = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			// 3. 스테이트먼트 객체 생성
			statement = con.createStatement();

			String sql = "select * from topic";

			// 4. 쿼리실행
			rs = statement.executeQuery(sql);

			// 5. 결과 수행
			while (rs.next()) {
				String title = rs.getString("title");
				String body = rs.getString("body");
				String created = rs.getString("created");
				String author = rs.getString("author_name");
				String profile = rs.getString("author_profile");

				System.out.println("title: " + title + " bdoy: " + body + " created: " + created + " author: " + author
						+ " profile: " + profile);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			// 6. 객체 연결 해제
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			try {
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void dbInsert(String title, String body, String author) {
		// 1. 드라이버로드
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		// 2. 커넥션 객체 생성
		Connection con = null;
		java.sql.Statement statement = null;

		try {
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			// 3. 스테이트먼트 객체 생성
			statement = con.createStatement();

			String sql = " insert into topic (title, body, author_name)\r\n " + " values (?, ?, ?) ";

			// 4. 쿼리실행
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, body);
			preparedStatement.setString(3, author);

			// 5. 결과 수행
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 6. 객체 연결 해제

			try {
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void dbUpdate(String date, String profile, String target) {
		// 1. 드라이버로드
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e) {
				
					e.printStackTrace();
				}
				
				// 2. 커넥션 객체 생성
				Connection con = null;
				java.sql.Statement statement = null;
				
				
				try {
					con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

					// 3. 스테이트먼트 객체 생성
					statement = con.createStatement();
					// 물음표에 따옴표 처리 안해주어야 에러 안남
					String sql = " update topic "
							+ " set "
						    + " author_profile = ?, "
						    + " created = ? "
						+ " where author_name = ? ";
					// 4. 쿼리실행
					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, profile);
					preparedStatement.setString(2, date);
					preparedStatement.setString(3, target);


					// 5. 결과 수행
					int affectedRows = preparedStatement.executeUpdate();
					if (affectedRows > 0) {
						System.out.println("업데이트 성공");
					} else {
						System.out.println("업데이트 실패");
					}


				} catch (SQLException e) {
					
					e.printStackTrace();
				} finally {
					// 6. 객체 연결 해제
					
					try {
						if (statement!= null && !statement.isClosed()) {
							statement.close();
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}

					try {
						if (con != null && !con.isClosed()) {
							con.close();
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}

	}

	public void dbDelete(String target) {
		// 1. 드라이버로드
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		// 2. 커넥션 객체 생성
		Connection con = null;
		java.sql.Statement statement = null;
		
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			// 3. 스테이트먼트 객체 생성
			statement = con.createStatement();
			// 물음표에 따옴표 처리 안해주어야 에러 안남
			String sql = "delete from topic\r\n"
					+ "where title = ?";
			// 4. 쿼리실행
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, target);
			
			// 5. 결과 수행
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}


		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			// 6. 객체 연결 해제
			
			try {
				if (statement!= null && !statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {

		DbTest dbTest = new DbTest();
		dbTest.dbSelect();
		System.out.println("\rn");
		dbTest.dbDelete("james");

		dbTest.dbSelect();

	}
}

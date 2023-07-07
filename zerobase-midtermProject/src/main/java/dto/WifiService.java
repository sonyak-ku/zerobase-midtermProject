package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DbTest;

public class WifiService {
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

	public void dbInsert(List<List<WifiDTO>> list) {
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

			String sql = " insert into insertTestTable "
			+ " (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR , X_SWIFI_INSTL_TY"
			+ ", X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNG, WORK_DTTM)\r\n " 
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			for (List<WifiDTO> dtoList : list) {
				for (WifiDTO dto : dtoList) {
					// 4. 쿼리실행
					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, dto.get관리번호());
					preparedStatement.setString(2, dto.get자치구());
					preparedStatement.setString(3, dto.get와이파이명());
					preparedStatement.setString(4, dto.get도로명());
					preparedStatement.setString(5, dto.get상세주소());
					preparedStatement.setString(6, dto.get설치위치());
					preparedStatement.setString(7, dto.get설치유형());
					preparedStatement.setString(8, dto.get설치기관());
					preparedStatement.setString(9, dto.get서비스구분());
					preparedStatement.setString(10, dto.get망종류());
					preparedStatement.setString(11, dto.get설치년도());
					preparedStatement.setString(12, dto.get실내구분());
					preparedStatement.setString(13, dto.get와이파이명());
					preparedStatement.setString(14, dto.getLAT_Y());
					preparedStatement.setString(15, dto.getLNT_X());
					preparedStatement.setString(16, dto.get작업일자());
					
					// 5. 결과 수행
					int affectedRows = preparedStatement.executeUpdate();
					if (affectedRows > 0) {
						System.out.println("저장 성공");
					} else {
						System.out.println("저장 실패");
					}
				}
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

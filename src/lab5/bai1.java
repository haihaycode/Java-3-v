package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bai1 {

	/**
	 *
	 * @author Administrator
	 */

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDA;encrypt=true;trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(url, "sa", "123");
			Statement stm = con.createStatement();// TẠO CONNECT ĐẾN SQL
			String sql = "select * from NHANVIEN";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("HONV") + "\t" + rs.getString("TENLOT") + "\t" + rs.getString("TENNV")
						+ "\t" + rs.getString("MANV") + "\t" + rs.getString("NGSINH") + "\t" + rs.getString("DIACHI")
						+ "\t" + rs.getString("PHAI") + "\t" + rs.getInt("LUONG") + "\t" + rs.getString("MA_NQL") + "\t"
						+ rs.getString("PHG"));
			}

		} catch (Exception e) {
			System.out.println("lỗi truy xuất + mã lỗi : "+e.getMessage());
		}
	}
}

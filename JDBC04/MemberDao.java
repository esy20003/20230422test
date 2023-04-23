package JDBC04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch(ClassNotFoundException e) {e.printStackTrace();
		} catch(SQLException e) {e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(SQLException e) {e.printStackTrace();
		}
	}

	public ArrayList<MemberDto> selectMember() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = getConnection();
		String sql = "select * from memberlist order by membernum desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setBirth(rs.getDate("birth"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				list.add(mdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		}
		return list;
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;

		con = getConnection();
		String sql = "insert into memberlist(membernum, name, phone, birth, gender, age)"
				+ "values(member_seq.nextVal, ?, ?, ?, ?, ?)";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName() );
			pstmt.setString(2, mdto.getPhone());
			pstmt.setDate(3, mdto.getBirth());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());

			result = pstmt.executeUpdate();

		} catch(SQLException e) {e.printStackTrace();
		}
		close();
		return result;
	}
	
	public MemberDto getMember(int membernum) {
		MemberDto mdto = null;

		con = getConnection();
		String sql = "select * from memberlist where membernum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getDate("birth"));
				mdto.setAge(rs.getInt("age"));
				mdto.setGender(rs.getString("gender"));
				mdto.setBpoint(rs.getInt("bpoint"));
			}
		} catch (SQLException e) {e.printStackTrace();
		}
		close();
		return mdto;
	}

	public int updateMember(MemberDto mdto) {
		int result = 0;

		con = getConnection();
		String sql = "update memberlist set name=?, phone=?, birth=?, age=?, gender=?, bpoint=?" + "where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setDate(3, mdto.getBirth());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			pstmt.setInt(6, mdto.getBpoint());
			pstmt.setInt(7, mdto.getMembernum());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	public int deleteMember(MemberDto mdto) {
		int result = 0;
		con = getConnection();
		String sql = "delete from memberlist where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mdto.getMembernum());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {e.printStackTrace();
		}
		return result;
	}

}
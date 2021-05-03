package BabyProductsRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_C {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	String sql = "";
	VO_C vo_C = null;
	VOreturn_C VOreturn_C = null;
	VOupdate_C VOupdate_C = null;
	VO_S vo_S = null;
	// JDBC ���� �޼���
	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@222.102.104.14:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("��");

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
//			System.out.println("���");
			e.printStackTrace();
		}
	}public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ������ ���Ǽ��� ���� �޼���
	public int insert_C(String id, String pw, String name, String phonenumber, String address, String account,
			String money) {

		try {

			getConn();
			sql = "insert into customer values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, phonenumber);
			psmt.setString(5, address);
			psmt.setString(6, account);
			psmt.setString(7, money);

			cnt = psmt.executeUpdate();
		} catch (Exception e) {

		}finally {
			close();
		}
		return cnt;
	}

	// �α��� �޼���
	public VO_S loginselect( String id, String pw ) {
		try {
			getConn();

			sql = "select id, pw from customer where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String getid = rs.getString(1);
				String getpw = rs.getString(2);

				vo_S = new VO_S(getid, getpw);
				// VO/DTO : ���ϰ��� �����͸������� �� �ϳ��ϳ��� ������ ������ �� �ƴ϶�
//	                    ��� �����͸� ������ �� �ִ� ��ü
			}
		} catch (Exception e) {
			System.out.println("JDBC����");
		}
		finally {
			close();
		}
		return vo_S;

	}

	// ����Ʈ �޼���
//	public ArrayList<chartVO> rankSmallCTG() {
//		ArrayList<chartVO> al = new ArrayList<chartVO>();
//
//		try {
//			getConn();
//			sql = "SELECT SMALLCTG, SUM(RCOUNT) AS ranking FROM production GROUP BY SMALLCTG";
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while (rs.next()) {
//				String head = rs.getString(1);
//				String rank = rs.getString(2);
//				cvo = new chartVO(head, rank);
//				al.add(cvo);
//			}
//
//		} catch (Exception e) {
//		}
//		return al;
//	}
	
	// �� ȸ������ ���� �޼���
	public int insert_Create(String id, String pw, String name, String phonenumber, String address, String bankaccount,
			int money) {
		try {
			getConn();
			sql = "insert into customer values( ?, ?, ?, ?, ?, ?, 0)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, phonenumber);
			psmt.setString(5, address);
			psmt.setString(6, bankaccount);

			cnt = psmt.executeUpdate();

			if (conn != null) {
				System.out.println("DB���Ἲ��");
			} else {
				System.out.println("DB�������");
			}

		} catch (Exception e) {
			System.out.println("try������ ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;

	}

	// ��ġ����� �޼���
	public String loginMoney(String id) {

		String getMoney = null;
		try {
			getConn();
			sql = "select money from customer where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			System.out.println(rs);

			while (rs.next()) {
				getMoney = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return getMoney;

	}

	// ���̺� ��� �޼���
	public ArrayList<VOreturn_C> select_T() {
		ArrayList<VOreturn_C> arr = new ArrayList<VOreturn_C>();
		try {
			getConn();
			sql = "Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where rback ='�ݳ���û'";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String rnumber = rs.getString(1);
				String deposit = rs.getString(2);
				String rmonth = rs.getString(3);
				String rmoney = rs.getString(4);
				String tpmoney = rs.getString(5);
				String latepayment = rs.getString(6);
				String epayback = rs.getString(7);

				VOreturn_C = new VOreturn_C(rnumber, deposit, rmonth, rmoney, tpmoney, latepayment, epayback);

				arr.add(VOreturn_C);

			}

		} catch (Exception e) {

			System.out.println("try������ �����߻�");
			e.printStackTrace();
		}finally {
			close();
		}
		return arr;
	}
	
	// �� ȸ������ ���� �޼���
	public int update_customer( String id, String pw, String address, String phonenumber, String account  ) {
		try {
			getConn();
			sql = "update CUSTOMER set pw = ?, address = ?, phonenumber = ?, account = ? where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pw);
			psmt.setString(2, address);
			psmt.setString(3, phonenumber);
			psmt.setString(4, account);
			psmt.setString(5, id);

			cnt = psmt.executeUpdate();

			if (conn != null) {
				System.out.println("DB���Ἲ��");
			} else {
				System.out.println("DB�������");
			}

		} catch (Exception e) {
			System.out.println("try������ ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;

	}
	
	// ȸ������������ ���� ������ Select������ ��������
	public VO_C select_C(String id) {
	      try {
	         getConn();
	         sql = "select pw, address,phonenumber,account from CUSTOMER where id = ?";
	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, id);
	         
	         rs = psmt.executeQuery();
	         
	         while (rs.next()) {
	            String pw = rs.getString(1);
	            String phonenumber = rs.getString(2);
	            String address = rs.getString(3);
	            String account = rs.getString(4);

	            vo_C = new VO_C( pw, phonenumber, address, account );

	         }

	      } catch (Exception e) {

	         System.out.println("try������ �����߻�");
	         e.printStackTrace();
	      } finally {
	    	  
	      }
		return vo_C;
	   }
	
	
}

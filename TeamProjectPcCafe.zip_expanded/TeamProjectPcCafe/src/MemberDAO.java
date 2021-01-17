import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String userid="PCUSER";//만든 맴버 클래스의 아이디랑 비밀번호 
		String passwd="12345";

		
		public MemberDAO() {
			try {			
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch

		}// end memberDAO CONS
		
		//로그인 되어있는지 check
		public boolean loginCheck(String id) {
			boolean result = false;
			Connection con= null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rs=null;
	    	
	    	try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT * FROM pc WHERE id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					result=true;
				}
				
				
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  	  return result;
		}//end loginCheck
		
		//pc가 비어있는지 check
		public boolean pcCheck(int seat) {
			boolean result = false;
			Connection con= null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rs=null;
	    	
	    	try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT * FROM pc WHERE pcNum=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, seat);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					result=true;
				}
				
				
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  	  return result;
		}//end pcCheck
		//member id 체크 메서드
	    public boolean isExist(String id, String password) {
	    	boolean result=false;
	    	Connection con= null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rs=null;
	    	
	    	try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT * FROM member WHERE id=? AND password=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					result=true;
				}
				
				
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  	  return result;
	    }//end isExist
	    
	    //pc에 insert
	    public void insert(int pcNum, String id, String password, long time) {
			Connection con = null;
			PreparedStatement pstmt=null;
			
			try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="INSERT INTO pc "
						+ "VALUES(?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				//?안에 실제 데이터 넣기 
				pstmt.setInt(1, pcNum);
				pstmt.setString(2,id.trim());
				pstmt.setString(3,password.trim());
				pstmt.setLong(4, time);
				
				int n=pstmt.executeUpdate();//excuteupdate->sql저장한 것을 실행 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null)pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}//end insert
	    
		public void input(String id,String password,String name,String age,String phone) {
			Connection con=null;
			PreparedStatement pstmt=null;
			
			
			try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="INSERT INTO member (id,password,name,age,phone)"
						+ "VALUES(?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				pstmt.setString(3, name);
				pstmt.setInt(4, Integer.parseInt(age));
				pstmt.setString(5, phone);
				
				int n=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null)pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}//input end


		//¾ÆÀÌµð Áßº¹ °Ë»ç 
		public boolean searchID(String id){
			boolean result=false;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT*FROM member WHERE id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();

				while(rs.next()) {
					result=true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//end finally 
			return result;
			
		}//end serch

		//ÇÏÀÌÇÂ ³Ö¾îÁÖ´Â ¸Þ¼Òµå 
		public String phone(String phone) {
			String phonNumber="";
			
			if(phone==null) {
				return phonNumber="";
			}else if(phone.length()==11) {
				return phonNumber=phone.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
			}
			
			return phonNumber;
		}//end phone
		
		//ÇÚµåÆù ¹øÈ£ ¹®ÀÚ ±¸ºÐ 
		public boolean checkPhone(String phone) {
			char ch;
			boolean check=false;
			
			for (int i = 0; i < phone.length(); i++) {
				ch=phone.charAt(i);
				if(!Character.isDigit(ch)) {
					check=true;
				}
			}
			return check;
			
			
		}//end checkPhone
		
		public boolean checkPc(String pcNum) {
	    	boolean result=false;
	    	Connection con= null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rs=null;
	    	
	    	try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT * FROM pc WHERE pcNum=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(pcNum));
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					result=true;
				}
				
				
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  	  return result;
		}//end checkPc
		
		public long getTime(String pcNum) {
	    	Connection con= null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rs=null;
	    	long time = 0;
	    	try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="SELECT * FROM pc WHERE pcNum=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(pcNum));
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					time = rs.getLong(4);
				}//end while
				
				
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	return time;
		}//end getTime
		
		
		public void insertMoney(int pcNum, long money) {
			Connection con=null;
			PreparedStatement pstmt=null;
			
			try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="INSERT INTO payment (pcNum,money)"
						+ "VALUES(?,?)";
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, pcNum);
				pstmt.setLong(2, money);
	
				
				int n=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null)pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}//end insertMoney
		
		public void deleteLogin(int pcNum) {
			Connection con=null;
			PreparedStatement pstmt=null;
			
			try {
				con=DriverManager.getConnection(url,userid,passwd);
				String sql="DELETE FROM pc WHERE pcNum=?";
				pstmt=con.prepareStatement(sql);
				
				pstmt.setInt(1, pcNum);
	
				
				int n=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null)pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//end deleteLogin
		
	public boolean age(String age) {
		char ch;
		boolean check=false;
		
		for (int i = 0; i < age.length(); i++) {
			ch=age.charAt(i);
			if(!Character.isDigit(ch)) {
				check=true;
			}
		}
		return check;
		
	}//end age
	    
	   public void sales() {
		      Connection con=null;
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      
		      try {
		      con=DriverManager.getConnection(url,userid,passwd);   
		      String sql="select sum(money) from payment";
		      pstmt=con.prepareStatement(sql);
		      rs=pstmt.executeQuery();
		      while(rs.next()) {
//		      Total   total=new Total();
		      Total.tf.setText(""+rs.getInt(1));
		      }
		      
		      
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null)pstmt.close();
						if(con != null) con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		      

		   }//end sales
}//end memberDAO

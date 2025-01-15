package residency_project_files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
//import java.util.Map;
import java.util.TreeMap;

public class DAO { //		database access object
	

	
	
	//1----------------------------------------------------------------------------------------------
	
	static TreeMap<Integer, Integer> getRoomId() {
		
			TreeMap<Integer, Integer> bookedRooms = new TreeMap<>();
			
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables","root","tiger");
				Statement smt = con.createStatement();
				String query = "select * from rooms";
				ResultSet rs = smt.executeQuery(query);
				
				while(rs.next()) {
					int roomno = rs.getInt(1);
					int customerid = rs.getInt(2);
					bookedRooms.put(roomno, customerid);
				}
			} catch (SQLException e) {
				System.err.println("problem at DAO.static TreeMap<Integer, Integer> setHashMap()'s database connection");
				return null;
			}
			
			return bookedRooms;
		}
	//2----------------------------------------------------------------------------------------------
	// id ,name ,mail_id ,members ,checkin ,time_by_customer
	static void booking(String name, String mailid, int members, double days, int[] arrayOfRooms) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat s0 = new SimpleDateFormat("aa");
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss");
        try {
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables","root","tiger");
    		Statement smt = con.createStatement();
    //insert into customers(id, name, mail_id, members, check_in, time_by_cust) values (12,'karthi', 'karthikayan@gmail.com', 9, date, 2.5);
    		Date date = new Date();
    		java.sql.Timestamp sqldate = new java.sql.Timestamp(date.getTime());
    		String query1 = "insert into customers values ("+arrayOfRooms[0]+", '"+name+"', '"+mailid+"', "+members+", '"+sqldate+"' , "+days+")";
    		smt.execute(query1);
            DAO.bookRooms(arrayOfRooms);
    		System.out.println("\nConfermation of your details : \n\n");
    		ResultSet rst = getCustomer(mailid);
    		rst.next();
    			int id1 = rst.getInt(1);
    			String name1 = rst.getString(2);
    			String mail_id1 = rst.getString(3);
    			int members1 = rst.getInt(4);
    			Date check_in1 = rst.getTimestamp(5);
    			float time_by_cust1 = rst.getFloat(6);
    			System.out.println("your booking id is : "+id1);
    			System.out.println("your name is : "+name1);
    			System.out.println("your mail id is : "+mail_id1);
    			System.out.println("count of members : "+members1+" and rooms : "+ DAO.getRoomsCount(id1));
    			System.out.println("your needed stay time : "+time_by_cust1);
    			System.out.println("your checkin time  : "+check_in1);

    	        String a = s0.format(check_in1);
    	        String b = "pm";

    	        LocalDateTime lt1 = LocalDateTime.parse(s1.format(check_in1)+'T'+s2.format(check_in1));
    	        double t1 = 0.0;
    	        if(a.equals(b)){
    	            t1 = (time_by_cust1*24)+12;
    	        }
    	        else{
    	            t1 = time_by_cust1*24;
    	        }
    	        int t2 = (int)t1;
    	        LocalDateTime lt = lt1.plusHours(t2);
    			System.out.println("your checkout time : "+lt);
    			
    		con.close();
        } catch (SQLException e) {
        	System.err.println("problem at DAO.static void booking(String name, String mailid, int members, double days, int[] arrayOfRooms)'s database connection");
			return;
		}
		
		
	}
	//3----------------------------------------------------------------------------------------------
	static ResultSet getCustomer(String mail_id){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/hotel_tables","root","tiger");
			Statement smt = con.createStatement();
			String query = "select * from customers where mail_id = '"+mail_id+"'";
			return smt.executeQuery(query);
		}  catch (SQLException e) {
			System.err.println("problem at DAO.static ResultSet getCustomer(String mail_id)'s database connection");
			return null;
		}
	}
	//4----------------------------------------------------------------------------------------------
	static ResultSet getLiveCustomers() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/hotel_tables","root","tiger");
			Statement smt = con.createStatement();
			String query = "select * from customers";
			return smt.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static ResultSet getLiveCustomers()'s database connection");
			return null;
		}
	}
	//----------------------------------------------------------------------------------------------
//	static ResultSet getCustomersIdNameMail () throws SQLException {
//		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/hotel_tables","root","tiger");
//		Statement smt = con.createStatement();
//		String query = "select id, name, mail_id from customers";
//		return smt.executeQuery(query);
//	}
	//5----------------------------------------------------------------------------------------------
	static void bookRooms(int[] array){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables","root","tiger");
			Statement smt = con.createStatement();
			for(int a:array) {
				String query = "insert into rooms values ("+a+", "+array[0]+")";
				smt.execute(query);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("problem at DAO.static void bookRooms(int[] array)'s database connection");
			return;
		}
	}
	//6----------------------------------------------------------------------------------------------
	static boolean checkMail (String mail){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select true from statistics where mail_id = '"+mail+"'";
			ResultSet rst = smt.executeQuery(query);
			if(!rst.next()) {
				return false;
			}
			return rst.getBoolean(1);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static boolean checkMail (String mail)'s database connection");
			return false;
		}
	}
	//7----------------------------------------------------------------------------------------------
	static ResultSet getStatistics(String mail){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select * from statistics where mail_id = '"+mail+"'";
			return smt.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static ResultSet getStatistics(String mail)'s database connection");
			return null;
		}
	}
	//8----------------------------------------------------------------------------------------------
	static ResultSet getmail(int id) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select mail_id from customers where id = "+id;
			return smt.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static ResultSet getmail(int id)'s database connection");
			return null;
		}
	}
	//9----------------------------------------------------------------------------------------------
	static int getRoomsCount(int id) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select count(room_no) from rooms where customer_id = "+id;
			ResultSet rst = smt.executeQuery(query);
			rst.next();
			return rst.getInt(1);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static int getRoomsCount(int id)'s database connection");
			return -1;
		}
	}
	//10----------------------------------------------------------------------------------------------
	static void vacate(int id){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "delete from customers where id = "+id;
			smt.execute(query);
			con.close();
		} catch (SQLException e) {
			System.err.println("problem at DAO.static TreeMap<Integer, Integer> setHashMap()'s database connection");
			return;
		}
	}
	//----------------------------------------------------------------------------------------------
/*	static void vacate(String mail) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
		Statement smt = con.createStatement();
		String query = "delete from customers where mail_id = '"+mail+"'";
		smt.execute(query);
		con.close();
	}
*/
	//11----------------------------------------------------------------------------------------------
	static void statisticsUpdate(String mail, int repeat, int newhours){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "update statistics set repeatation = "+repeat+" ,total_time = "+newhours+" where mail_id = '"+mail+"'";
			smt.execute(query);
			con.close();
		} catch (SQLException e) {
			System.err.println("problem at DAO.static void statisticsUpdate(String mail, int repeat, int newhours)'s database connection");
			return;
		}
	}
	//12----------------------------------------------------------------------------------------------
	static void statisticsInsert(String mail, int newhours) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "insert into statistics values ('"+mail+"',"+newhours+",1)";
			smt.execute(query);
			con.close();
		}  catch (SQLException e) {
			System.err.println("problem at DAO.static void statisticsInsert(String mail, int newhours)'s database connection");
			return;
		}
	}
	//13----------------------------------------------------------------------------------------------
	static ResultSet getStatistics(){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select * from statistics";
			return smt.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static ResultSet getStatistics()'s database connection");
			return null;
		}
	}
	//14----------------------------------------------------------------------------------------------
	static int getProfit(){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select profit from hotel_settings";
			ResultSet rst = smt.executeQuery(query);
			rst.next();
			return rst.getInt(1);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static int getProfit()'s database connection");
			return -1;
		}
	}
	//15----------------------------------------------------------------------------------------------
	static void setProfit(int total){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "update hotel_settings set profit = "+total+" where hotel_id = 1";
			smt.execute(query);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static void setProfit(int total)'s database connection");
			return;
		}
	}
	//16----------------------------------------------------------------------------------------------
	static int getRoomsCount() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select rooms_count from hotel_settings";
			ResultSet rst = smt.executeQuery(query);
			rst.next();
			return rst.getInt(1);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static int getRoomsCount()'s database connection");
			return -1;
		}
	}
	//17----------------------------------------------------------------------------------------------
	static int gethourCost() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_tables", "root", "tiger");
			Statement smt = con.createStatement();
			String query = "select hour_cost from hotel_settings";
			ResultSet rst = smt.executeQuery(query);
			rst.next();
			return rst.getInt(1);
		} catch (SQLException e) {
			System.err.println("problem at DAO.static int getHourCost()'s database connection");
			return -1;
		}
	}
	
}

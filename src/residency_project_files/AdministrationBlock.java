package residency_project_files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministrationBlock {
	AdministrationBlock() throws SQLException, IOException{
        
        Scanner in = new Scanner(System.in);
        int adminBlOption = 1;
        lable :
        while(true) {
        Utils.blockTitle("ADMINISTRATION BLOCK");
        System.out.println("\nENTER 1 FOR ROOMS DETAILS");
        System.out.println("ENTER 2 FOR LIVE CUSTOMER DETAILS");
        System.out.println("ENTER 3 FOR REPEATED CUSTOMERS LIST");
        System.out.println("ENTER 4 FOR ALL CUSTOMERS mail id and count LIST");
        System.out.println("ENTER 5 FOR TOTAL PROFIT");
        System.out.println("ENTER 6 FOR REPORT DISPLAY");
        System.out.println("ENTER 7 FOR DOWNLOAD REPORT TEXT FILE");
        System.out.println("ENTER 8 FOR CUSTOM SETTINGS");
        System.out.println("ENTER NUMBERS EXCEPT OPTION TO EXIT");
        System.out.println("\n\t\t//must once it will use before any transaction");
        System.out.print("\nENTER YOUR VALUE HERE : ");

        try {
            adminBlOption = in.nextInt();
        }
        catch(InputMismatchException e) {
        	System.err.println("! enter option rightly");
        	AdministrationBlock ab = new AdministrationBlock();
        }
        switch(adminBlOption) {
        //----------------------------------------------------------------------------------------------
        case 1:{

        	int[] aofr = AllMethodsBlock.arrayOfRooms();
        	int totalRooms = aofr.length; 
        	Utils.boxTitle("ROOMS DETAILS");
        	System.out.println("\n");
        	Utils.subTitle("TOTAL BOOKED ROOMS");
        	System.out.println("TOTAL BOOKED ROOMS : "+totalRooms);
        	System.out.println("\n");
        	Utils.subTitle("BOOKED ROOMS LIST");
        	System.out.print("BOOKED ROOMS LIST : ");
        	for(int i = 0; i < totalRooms; i++) {
        		System.out.print(aofr[i]);
        		if(i == totalRooms-1) {
        			System.out.println('.');
        		}
        		else {
        			System.out.print(", ");
        		}
        	}
        	System.out.println("\n");
        	Utils.subTitle("BUILDING VIEW");
        	System.out.println("BUILDING VIEW OF ROOMS : ");
        	AllMethodsBlock.printRooms('a', aofr);
            break;
        }
        //----------------------------------------------------------------------------------------------
        case 2:{
        	Utils.boxTitle("LIVE CUSTOMER DETAILS");
        	System.out.println("\n");
        	ResultSet rst = DAO.getLiveCustomers();
        	while(rst.next()) {
        		System.out.printf("%2d  %-20s %s\n",rst.getInt(1),rst.getString(2),rst.getString(3));
        	}
            break;
        }
        //----------------------------------------------------------------------------------------------
        case 3:{
        	Utils.boxTitle("REPEATED CUSTOMERS LIST");
        	System.out.println("\n");
        	ResultSet rst = DAO.getStatistics();
        	while(rst.next()) {
        		if(rst.getInt(3) > 1) {
            		System.out.printf("%35s %2d\n",rst.getString(1),rst.getInt(3));
        		}
        	}
        	break;
        }
        //----------------------------------------------------------------------------------------------
        case 4:{
        	Utils.boxTitle("ALL CUSTOMERS mail id and count LIST");
        	System.out.println("\n");
        	int count = 0;
        	ResultSet rst = DAO.getStatistics();
        	while(rst.next()) {
        		System.out.println(rst.getString(1));
        		count++;
        	}
        	ResultSet rst1 = DAO.getLiveCustomers();
        	while(rst1.next()) {
        		if(!DAO.checkMail(rst1.getString(3))) {
        			System.out.println(rst1.getString(3));
        			count++;
        		}
        	}
        	System.out.println("\n");
        	Utils.boxTitle("total customers");
        	System.out.println("\n");
        	System.out.println("total customers : "+count);
        	break;
        }
        //----------------------------------------------------------------------------------------------
        case 5:{
        	Utils.boxTitle("TOTAL PROFIT");
        	System.out.println("\n");
        	System.out.println("total profit is : "+DAO.getProfit());
        	break;
        }
        //----------------------------------------------------------------------------------------------
        case 6:{
        	
        	Utils.starTitle('#');
        	
        	System.out.println("\n");
        	Utils.boxTitle("ROOMS DETAILS");
        	System.out.println("\n");
        	Utils.subTitle("TOTAL BOOKED ROOMS");
        	int[] aofr = AllMethodsBlock.arrayOfRooms();
        	int totalRooms = aofr.length;
        	System.out.println("TOTAL BOOKED ROOMS : "+totalRooms);
        	System.out.println("\n");
        	Utils.subTitle("BOOKED ROOMS LIST");
        	System.out.print("BOOKED ROOMS LIST : ");
        	for(int i = 0; i < totalRooms; i++) {
        		System.out.print(aofr[i]);
        		if(i == totalRooms-1) {
        			System.out.println('.');
        		}
        		else {
        			System.out.print(", ");
        		}
        	}
        	System.out.println("\n");
        	Utils.subTitle("BUILDING VIEW");
        	System.out.println("BUILDING VIEW OF ROOMS : ");
        	AllMethodsBlock.printRooms('a', aofr);
        	System.out.println("\n");
        	//-----------------------------------------------------------------------------------------

        	Utils.boxTitle("LIVE CUSTOMER DETAILS");
        	System.out.println("\n");
        	ResultSet rst = DAO.getLiveCustomers();
        	while(rst.next()) {
        		System.out.printf("%2d  %-20s %s\n",rst.getInt(1),rst.getString(2),rst.getString(3));
        	}
        	System.out.println("\n");

        	//-----------------------------------------------------------------------------------------

        	Utils.boxTitle("REPEATED CUSTOMERS LIST");
        	System.out.println("\n");
        	ResultSet rst1 = DAO.getStatistics();
        	while(rst1.next()) {
        		if(rst1.getInt(3) > 1) {
            		System.out.printf("%35s %2d\n",rst1.getString(1),rst1.getInt(3));
        		}
        	}
        	System.out.println("\n");
        	
        	

        	//-----------------------------------------------------------------------------------------
        	Utils.boxTitle("ALL CUSTOMERS mail id and count LIST");
        	System.out.println("\n");
        	int count = 0;
        	ResultSet rst11 = DAO.getStatistics();
        	while(rst11.next()) {
        		System.out.println(rst11.getString(1));
        		count++;
        	}
        	ResultSet rst111 = DAO.getLiveCustomers();
        	while(rst111.next()) {
        		if(!DAO.checkMail(rst111.getString(3))) {
        			System.out.println(rst111.getString(3));
        			count++;
        		}
        	}

        	System.out.println("\n");
        	Utils.boxTitle("total customers");
        	System.out.println("\n");
        	System.out.println("total customers : "+count);
        	System.out.println("\n");

        	//-----------------------------------------------------------------------------------------
        	

        	Utils.boxTitle("TOTAL PROFIT");
        	System.out.println("\n");
        	System.out.println("total profit is : "+DAO.getProfit());
        	break;
        }
        //----------------------------------------------------------------------------------------------
        case 7:{
        	File folder = new File("C:\\Users\\HP\\Desktop\\Residency_project_folder");
        	File file = new File("C:\\Users\\HP\\Desktop\\Residency_project_folder\\Report.txt");
        	if(!folder.exists()) {
        		folder.mkdir();
        	}
        	if(!file.exists()) {
        		file.createNewFile();
        		FileWriter writer = new FileWriter(file);
        		writer.write( AllMethodsBlock.forTXT());
        		writer.flush();
        		writer.close();
        	}else {
        		file.delete();
        		file.createNewFile();
        		FileWriter writer = new FileWriter(file);
        		writer.write( AllMethodsBlock.forTXT());
        		writer.flush();
        		writer.close();
        	}
        	
        	break;
        }
        //----------------------------------------------------------------------------------------------
        case 8:{
            Utils.blockTitle("CUSTOM Settings BLOCK");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/hotel_tables","root","tiger");
            Statement smt = con.createStatement();

            String query = "select * from hotel_settings";
            ResultSet rst = smt.executeQuery(query);
            rst.next();
            boolean state = rst.getBoolean(4);
            if(state == false) {
            	System.out.println("\n//must once it will use before any transaction");
            	System.out.println("so you can't change it");
            	break;
            }
            else if(state == true) {
            	String query1 = "select * from statistics;";
            	ResultSet rst1 = smt.executeQuery(query1);
            	boolean a = rst1.next();
            	String query2 = "select * from customers;";
            	ResultSet rst2 = smt.executeQuery(query2);
            	boolean b = rst2.next();
            	if((a == false)&&(b == false)) {

                	int hourCost = 50;
                	int roomCount = 50;
                	System.out.print("enter how many number of rooms you need to set : ");
                	try {
                    	roomCount = in.nextInt();
                	} catch (InputMismatchException e) {
                    	System.err.println("! enter your rooms count rightly");
                    	System.err.println("! run the program from first");
                    	return;
                    }
                	
                	System.out.print("enter the cost per hour you need to set : ");
                	try {
                		hourCost = in.nextInt();
                	} catch (InputMismatchException e) {
                    	System.err.println("! enter your rooms count rightly");
                    	System.err.println("! run the program from first");
                    	return;
                    }
                	String queryToSet = "update hotel_settings set rooms_count = "+roomCount+", hour_cost = "+hourCost+", modify_state = "+false+" where hotel_id = 1";
                	smt.execute(queryToSet);
                	System.out.println("updated");
            	}
            	else {
            		System.out.println("\n//must once it will use before any transaction");
                	System.out.println("so you can't change it");
                	String query3 = "update hotel_settings set modify_state = "+false+ " where hotel_id = 1";
                	smt.execute(query3);
            	}
            }
      }
        //----------------------------------------------------------------------------------------------
        default :{
        	System.out.println("thank you");
        	break lable;
        }
        //----------------------------------------------------------------------------------------------
        }
    }
    
//    ResultSet rst1 = smt.executeQuery(Query);
//    if(rst1.next()) {
//    	state = false;
//    }
//    con.close();
//    break;
    }
}

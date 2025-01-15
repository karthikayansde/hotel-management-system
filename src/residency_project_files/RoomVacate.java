package residency_project_files;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomVacate {
	RoomVacate() throws SQLException {
		
		int roomId = 0, costPerHour = DAO.gethourCost();
		Scanner in = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
		Utils.blockTitle("ROOM VACATING BLOCK");
		System.out.print("you can vacate rooms using your room id : ");
/*		System.out.println("enter 1 for id : ");
		System.out.println("enter 2 for mail id : ");
        System.out.print("\nenter your value here : ");
*/
		
		
        try {
            roomId = in.nextInt();
        }
        catch(InputMismatchException e) {
        	System.err.println("! enter your id rightly");
        	RoomVacate rv = new RoomVacate();
        }
        
        
        ResultSet rst = DAO.getmail(roomId);
        
        if(!rst.next()) { 		//check id is valid or not
        	System.err.println("! enter right id");
        	RoomVacate rv = new RoomVacate();
        }
        
        String mail = rst.getString(1);
        
        ResultSet rst2 = DAO.getCustomer(mail);
        rst2.next();
        int totalRooms = DAO.getRoomsCount(roomId);
        double days = rst2.getDouble(6);
        double oldCost = 24*days*costPerHour*totalRooms; 		// old cost without discount
        
        Date dNow = new Date();
        Date dOld = rst2.getTimestamp(5);
		long diff = dNow.getTime() - dOld.getTime();
		long diffhours = diff / (60*60*1000);
		double newCost = diffhours*costPerHour*totalRooms; 		// new cost without discount
		
        if(DAO.checkMail(mail)) {
        	ResultSet rst1 = DAO.getStatistics(mail);
        	rst1.next();
    		int totalCost = rst1.getInt(2)*costPerHour;
    		double discount = (double)10/100*totalCost;
    		System.out.println("hours you spand : "+diffhours);
        	System.out.println("your payed cost : "+(oldCost-discount));
        	System.out.println("your new cost : "+(newCost+discount));
        	if((oldCost-discount) == (newCost+discount)) {
        		System.out.println("thank you");
        	}
        	else if((oldCost-discount) < (newCost+discount)) {
        		System.out.println("press enter to pay balence : "+((newCost+discount)-(oldCost-discount)));
                in.nextLine();
                in.nextLine();
                
                DAO.setProfit((int)(DAO.getProfit()+((newCost+discount)-(oldCost-discount))));
                
        		System.out.println("thank you");
        	}
        	else {
        		System.out.println("press enter to get balence : "+((oldCost-discount) - (newCost+discount)));
                in.nextLine();
                in.nextLine();
                
                DAO.setProfit((int)(DAO.getProfit()-((oldCost-discount)-(newCost+discount))));
                
        		System.out.println("thank you");
        	}
        	int repeatation = rst1.getInt(3);
        	DAO.statisticsUpdate(mail, repeatation+1, (int)(diffhours));
        }
        else {
        	DAO.statisticsInsert(mail, (int)diffhours);
    		System.out.println("hours you spand : "+diffhours);
        	System.out.println("your payed cost : "+oldCost);
        	System.out.println("your new cost : "+newCost);
        	if(oldCost == newCost) {
        		System.out.println("thank you");
        	}
        	else if(oldCost < newCost) {
        		System.out.println("press enter to pay balence : "+(newCost-oldCost));
                in.nextLine();
                in.nextLine();

                DAO.setProfit((int)(DAO.getProfit()+((newCost)-(oldCost))));
                
        		System.out.println("thank you");
        	}
        	else {
        		System.out.println("press enter to get balence"+(oldCost-newCost));
                in.nextLine();
                in.nextLine();
                
                DAO.setProfit((int)(DAO.getProfit()-((oldCost)-(newCost))));
                
        		System.out.println("thank you");
        	}
        }
        DAO.vacate(roomId);
	}
}

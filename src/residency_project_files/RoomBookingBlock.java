package residency_project_files;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomBookingBlock {
	RoomBookingBlock() throws SQLException{
    	
        int totalMembers = 0,totalRooms = 0, roomsCount = DAO.getRoomsCount(),  costPerHour = DAO.gethourCost();
        Scanner in = new Scanner(System.in);

        Utils.blockTitle("ROOM BOOKING BLOCK");
        Utils.subTitle("room allocation");
        System.out.print("\tHOW MANY MEMBERS TO STAY : ");
        
        //		
        try {
            totalMembers = in.nextInt();
        }
        catch(InputMismatchException e) {
        	System.err.println("! enter right members count");
        	RoomBookingBlock rbb = new RoomBookingBlock();
        }
        
        
        if(totalMembers > 2){
            if(totalMembers%2 == 0){
                totalRooms = totalMembers / 2;
            }
            else{
                totalRooms = (totalMembers / 2) + 1;
            }
        }
        else{
            totalRooms = 1;
        }
        String s = totalRooms == 1 ? " room" : " rooms";
        System.out.println("\t\t// you need minimum " + totalRooms + s);
        
        
        System.out.print("\tHOW MANY ROOMS IF YOU NEED : ");
        
        try {
            totalRooms = in.nextInt();
        }
        catch(InputMismatchException e) {
        	System.err.println("! enter right rooms count");
        	RoomBookingBlock rbb = new RoomBookingBlock();
        }
        
        if((roomsCount-AllMethodsBlock.roomsCount()) >= totalRooms) {
        	Utils.boxTitle("rooms are avilable.");
        }
        else {
        	Utils.boxTitle("rooms are not avilable.");
        	System.out.println("\t\t//only "+(roomsCount-AllMethodsBlock.roomsCount())+"rooms are avilable.");
        	RoomBookingBlock rbb = new RoomBookingBlock();
        }

		int[] a = AllMethodsBlock.roomChooser(totalRooms);
		System.out.print("\nyour booked rooms : ");
		for(int b : a) {
			System.out.print(b+" ");
		}
		System.out.println("\n\nfloor view : ");
        AllMethodsBlock.printRooms('c', a);
        
        System.out.println("\n");
        
        
        
        
        String name,mailid;
        double days = 0.0;
        Utils.subTitle("for rigistration");
        
        System.out.print("\nENTER YOUR NAME\n\t: ");
        in.nextLine();
        name = in.nextLine();
        System.out.print("ENTER YOUR MAIL ID \t ! without mistake ! without space !\n\t: ");
        mailid = in.nextLine();
        System.out.print("ENTER HOW MANY DAYS YOU NEED TO STAY \t ! minimum helf day, enter 0.5 to helf day\n\t: ");
        

        try {
            days = in.nextDouble();
        }
        catch(InputMismatchException e) {
        	System.err.println("! enter days rightly\n\t! one and half day means enter like 1.5");
        	RoomBookingBlock rbb = new RoomBookingBlock();
        }
        
        
        System.out.println("\t// "+costPerHour+" rs per hour");
        double actualCost = 24*days*costPerHour*totalRooms;
        
        
        if(DAO.checkMail(mailid)) {
        	ResultSet rst = DAO.getStatistics(mailid);
        	rst.next();
        	System.out.println("your old lived hours : "+rst.getInt(2));
    		int totalCost = rst.getInt(2)*costPerHour;
        	System.out.println("your payed cost per room : "+totalCost);
    		double discount = ((double)10/100*totalCost*totalRooms);
    		double costAfterDiscount = actualCost-discount;
        	System.out.println("your actual payment is : "+actualCost+" but your our regular customer so we discount 10% of your old payment on this payment.");
        	System.out.println("your total discount amount is "+discount);
            System.out.println("press enter to pay after discount prise rs "+costAfterDiscount+" for your booking");
            in.nextLine();
            in.nextLine();
            
            DAO.setProfit((int)(DAO.getProfit()+costAfterDiscount));
            
        }
        else {
            System.out.println("press enter to pay rs "+actualCost+" for your booking");
            in.nextLine();
            in.nextLine();
            
            DAO.setProfit((int)(DAO.getProfit()+actualCost));
            
        }
        System.out.println("thank, you are paid successfully");
        DAO.booking(name, mailid, totalMembers, days,a);
    }
}

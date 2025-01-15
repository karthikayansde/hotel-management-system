package residency_project_files;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerBlock {
    CustomerBlock(){
    	
        int custBlOption = 0;
        Scanner in = new Scanner(System.in);

        Utils.blockTitle("CUSTOMER BLOCK");
        
        System.out.println("\nENTER 1 FOR ROOM BOOKING");
        System.out.println("ENTER 2 FOR VACATE A ROOM");
        System.out.print("\nENTER YOUR VALUE HERE : ");

        try{
                custBlOption = in.nextInt();
            if(custBlOption > 2 || custBlOption < 1) {
            	throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
        	System.err.println("! enter your option rightly");
        	CustomerBlock cb = new CustomerBlock();
        }

        switch(custBlOption){
            case 1:{
                try {
					RoomBookingBlock rbb = new RoomBookingBlock();
				} catch (SQLException e) {
					System.err.println("! problem at RoomBookingBlock");
				}
                break;
            }
            case 2:{
            	try {
					RoomVacate rv = new RoomVacate();
				} catch (SQLException e) {
					System.err.println("! problem at RoomVacate");
				}
                break;
            }
        }
    }
}

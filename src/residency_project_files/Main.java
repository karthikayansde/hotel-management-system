package residency_project_files;        // my project's user-defined package

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        int firstOption = 0;
        Scanner in = new Scanner(System.in);
        Utils.starTitle('#');

        System.out.println("\nENTER 1 IF YOU ARE CUSTOMER");
        System.out.println("ENTER 2 IF YOU ARE ADMINISTATOR");
        System.out.print("\nENTER YOUR VALUE HERE : ");
        
        try{
            firstOption = in.nextInt();
            if(firstOption > 2 || firstOption < 1) {
            	throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e) {
        	System.err.println("! enter your value rightly");
        	System.err.println("! run the program from first");
        	return;
        }
        switch(firstOption){
            case 1:
            {
                CustomerBlock cb = new CustomerBlock();
                break;
            }
            case 2:
            {
                try {
					AdministrationBlock ab = new AdministrationBlock();
				} catch (SQLException | IOException e) {
					System.err.println("problem at Administration Block");
				}
                break;
            }
        }
    }
}
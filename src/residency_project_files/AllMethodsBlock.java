package residency_project_files;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class AllMethodsBlock {
	static int totalRooms = DAO.getRoomsCount();
	//1----------------------------------------------------------------------------------------------
	static int roomsCount() {
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm = DAO.getRoomId();
		int count = 0;
		for(Map.Entry<Integer, Integer> entry:tm.entrySet()) {
			count++;
		}
		return count;
	}
	//2----------------------------------------------------------------------------------------------
	
	static int[] arrayOfRooms(){
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm = DAO.getRoomId();
		int[] array = new int[roomsCount()];
		int ptr = 0;
		for(Map.Entry<Integer, Integer> entry:tm.entrySet()) {
			array[ptr] = entry.getKey();
			ptr++;
		}
		Arrays.sort(array);
		return array;
	}
	//3----------------------------------------------------------------------------------------------
	
	static int[] roomChooser(int roomCount){
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm = DAO.getRoomId();
		int[] array = new int[roomCount];
		int ptr = 0;
		for(int i = 1; i <= totalRooms && ptr < roomCount; i++) {
			if(!tm.containsKey(i)) {
				array[ptr] = i;
				ptr++;
			}
		}
		return array;
	}
	
	//4----------------------------------------------------------------------------------------------
	
	static void printRooms(char AdminOrCust, int[] ar) {
		Arrays.sort(ar);
		int ptr = ar.length-1;
		for(int i = totalRooms; i> 0; i--) {
			
			System.out.println(" ---   ---   ---   ---   --- ");
			
			for(int j = 1; j <= 5; j++) {
				
				boolean b = false;
				if(ptr >= 0) {
					if(i == ar[ptr]) {
						b = true;
						if(ptr>0) {
							ptr--;
						}
					}
				}
				if(AdminOrCust == 'c') {
					if(i<10) {
						if(b) {
							System.out.print("|0"+i+'Y'+"| ");
						}
						else {
							System.out.print("|0"+i+" | ");
						}
					}
					else {
						if(b) {
							System.out.print("|"+i+'Y'+"| ");
						}
						else {
							System.out.print("|"+i+" | ");
						}
					}
				}
				else if(AdminOrCust == 'a') {
					if(i<10) {
						if(b) {
							System.out.print("|0"+i+'B'+"| ");
						}
						else {
							System.out.print("|0"+i+'e'+"| ");
						}
					}
					else {
						if(b) {
							System.out.print("|"+i+'B'+"| ");
						}
						else {
							System.out.print("|"+i+'e'+"| ");
						}
					}
				}
				i--;
			}
			System.out.println("\n ---   ---   ---   ---   --- ");
			i++;
		}
		
	}
	//5----------------------------------------------------------------------------------------------

	static String printRoomsTXT(char AdminOrCust, int[] ar) {
		Arrays.sort(ar);
		int ptr = ar.length-1;
		String totalStr = "";
		for(int i = totalRooms; i> 0; i--) {

			totalStr = totalStr.concat(" ---   ---   ---   ---   --- \n");
			
			for(int j = 1; j <= 5; j++) {
				
				boolean b = false;
				if(ptr >= 0) {
					if(i == ar[ptr]) {
						b = true;
						if(ptr>0) {
							ptr--;
						}
					}
				}
				if(AdminOrCust == 'c') {
					if(i<10) {
						if(b) {
							totalStr = totalStr.concat("|0"+i+'Y'+"| ");
						}
						else {
							totalStr = totalStr.concat("|0"+i+" | ");
						}
					}
					else {
						if(b) {
							totalStr = totalStr.concat("|"+i+'Y'+"| ");
						}
						else {
							totalStr = totalStr.concat("|"+i+" | ");
						}
					}
				}
				else if(AdminOrCust == 'a') {
					if(i<10) {
						if(b) {
							totalStr = totalStr.concat("|0"+i+'B'+"| ");
						}
						else {
							totalStr = totalStr.concat("|0"+i+'e'+"| ");
						}
					}
					else {
						if(b) {
							totalStr = totalStr.concat("|"+i+'B'+"| ");
						}
						else {
							totalStr = totalStr.concat("|"+i+'e'+"| ");
						}
					}
				}
				i--;
			}
			totalStr = totalStr.concat("\n ---   ---   ---   ---   --- \n");
			i++;
		}
		return totalStr;
	}
	//6----------------------------------------------------------------------------------------------
	static String forTXT() throws SQLException {

		String totalStr = Utils.starTitleTXT('#');
    	
		totalStr = totalStr.concat("\n\n");
		totalStr = totalStr.concat(Utils.boxTitleTXT("ROOMS DETAILS"));
		totalStr = totalStr.concat("\n\n");
		totalStr = totalStr.concat(Utils.subTitleTXT("TOTAL BOOKED ROOMS"));
    	int[] aofr = AllMethodsBlock.arrayOfRooms();
    	int totalRooms = aofr.length;
    	totalStr = totalStr.concat("TOTAL BOOKED ROOMS : "+totalRooms);
    	totalStr = totalStr.concat("\n\n");
    	totalStr = totalStr.concat(Utils.subTitleTXT("BOOKED ROOMS LIST"));
    	totalStr = totalStr.concat("BOOKED ROOMS LIST : ");
    	for(int i = 0; i < totalRooms; i++) {
    		totalStr = totalStr.concat(String.format("%d", aofr[i]));
    		if(i == totalRooms-1) {
    			totalStr = totalStr.concat(".\n");
    		}
    		else {
    			totalStr = totalStr.concat(", ");
    		}
    	}
    	totalStr = totalStr.concat("\n\n");
    	totalStr = totalStr.concat(Utils.subTitleTXT("BUILDING VIEW"));
    	totalStr = totalStr.concat("BUILDING VIEW OF ROOMS : \n");
    	totalStr = totalStr.concat(AllMethodsBlock.printRoomsTXT('a', aofr));
    	totalStr = totalStr.concat("\n\n");
    	//-----------------------------------------------------------------------------------------

    	totalStr = totalStr.concat(Utils.boxTitleTXT("LIVE CUSTOMER DETAILS"));
    	totalStr = totalStr.concat("\n\n");
    	ResultSet rst = DAO.getLiveCustomers();
    	while(rst.next()) {
    		totalStr = totalStr.concat(String.format("%2d  %-20s %s\n",rst.getInt(1),rst.getString(2),rst.getString(3)));
    	}
    	totalStr = totalStr.concat("\n\n");

    	//-----------------------------------------------------------------------------------------

    	totalStr = totalStr.concat(Utils.boxTitleTXT("REPEATED CUSTOMERS LIST"));
    	totalStr = totalStr.concat("\n\n");
    	ResultSet rst1 = DAO.getStatistics();
    	while(rst1.next()) {
    		if(rst1.getInt(3) > 1) {
    			totalStr = totalStr.concat(String.format("%35s %2d\n",rst1.getString(1),rst1.getInt(3)));
    		}
    	}
    	totalStr = totalStr.concat("\n\n");
    	
    	

    	//-----------------------------------------------------------------------------------------
    	totalStr = totalStr.concat(Utils.boxTitleTXT("ALL CUSTOMERS mail id and count LIST"));
    	totalStr = totalStr.concat("\n\n");
    	int count = 0;
    	ResultSet rst11 = DAO.getStatistics();
    	while(rst11.next()) {
    		totalStr = totalStr.concat(rst11.getString(1)+"\n");
    		count++;
    	}
    	ResultSet rst111 = DAO.getLiveCustomers();
    	while(rst111.next()) {
    		if(!DAO.checkMail(rst111.getString(3))) {
    			totalStr = totalStr.concat(rst111.getString(3)+"\n");
    			count++;
    		}
    	}

    	totalStr = totalStr.concat("\n\n");

    	totalStr = totalStr.concat(Utils.boxTitleTXT("total customers"));
    	totalStr = totalStr.concat("\n\n");
    	totalStr = totalStr.concat("total customers : "+count);
    	totalStr = totalStr.concat("\n\n");

    	//-----------------------------------------------------------------------------------------
    	

    	totalStr = totalStr.concat(Utils.boxTitleTXT("TOTAL PROFIT"));
    	totalStr = totalStr.concat("\n\n");
    	totalStr = totalStr.concat("total profit is : "+DAO.getProfit());
    	return totalStr;
	}
}

package residency_project_files;

public class Utils {
	
	//----------------------------------------------------------------------------------------------
	
    static void starTitle(char i){

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%c%c%c%c%c   %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c%c%c%c%c    %c%c%c%c%c%c  %c       %c   %c%c%c%c%c  %c       %c        %c%c%c%c%c%c%c       %c%c       %c           %c  %c%c%c%c%c%c  %c%c%c%c%c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c    %c  %c       %c           %c    %c   %c       %c %c     %c  %c        %c     %c            %c       %c      %c    %c     %c     %c  %c       %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c    %c  %c       %c       %c%c  %c     %c  %c       %c  %c    %c  %c         %c   %c             %c      %c        %c   %c    %c %c    %c  %c       %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c%c%c%c%c   %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c     %c  %c%c%c%c%c%c  %c   %c   %c  %c          %c %c              %c     %c          %c  %c   %c   %c   %c  %c%c%c%c%c%c  %c%c%c%c%c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c  %c    %c            %c  %c%c  %c     %c  %c       %c    %c  %c  %c           %c               %c      %c        %c   %c  %c     %c  %c  %c       %c  %c  \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c   %c   %c            %c  %c%c  %c    %c   %c       %c     %c %c  %c          %c                %c       %c      %c    %c %c       %c %c  %c       %c   %c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.printf("%c    %c  %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c%c%c%c%c    %c%c%c%c%c%c  %c       %c   %c%c%c%c%c    %c                 %c          %c%c       %c           %c  %c%c%c%c%c%c  %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    // * -> 42 # 35, $ 36, % 37, & 38, @ 64, ^ 94, ~ 126, £ -> 163, ¥ -> 165, Ö -> 214 , Ü -> 220, ß -> 223 , ö -> 246
    }
	//----------------------------------------------------------------------------------------------
    
    static void blockTitle(String str){
        System.out.print("\n------------------------------------------------------------------------------------------\n|                                                                                        |\n|");
        int totalLength = 88;
        int firstLength = (totalLength/2) - (str.length()/2);
        int lastLength = totalLength - (firstLength+str.length());
        for (int i = 0; i < firstLength; i++) {
            System.out.print(' ');
        }
        System.out.print(str.toUpperCase());
        for (int i = 0; i < lastLength; i++) {
            System.out.print(' ');
        }
        System.out.println("|\n|                                                                                        |\n------------------------------------------------------------------------------------------\n");
    }
	//----------------------------------------------------------------------------------------------
    
    static void subTitle(String str){
        System.out.println(str.toUpperCase());
        for (int i = 0; i < str.length(); i++) {
            System.out.print('-');
        }
        System.out.println("\n");
    }
	//----------------------------------------------------------------------------------------------
    static void boxTitle(String str) {
    	System.out.print("\t");
    	for(int i = 0; i < str.length()+4; i++) {
    		System.out.print('-');
    	}
    	System.out.print("\n\t| "+str+" |\n\t");
    	for(int i = 0; i < str.length()+4; i++) {
    		System.out.print('-');
    	}
    	System.out.println();
    }
	//----------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------
    static String starTitleTXT(char i){
    	String totalStr;
        totalStr = "--------------------------------------------------------------------------------------------------------------------------------------\n";
        totalStr = totalStr.concat(String.format("%c%c%c%c%c   %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c%c%c%c%c    %c%c%c%c%c%c  %c       %c   %c%c%c%c%c  %c       %c        %c%c%c%c%c%c%c       %c%c       %c           %c  %c%c%c%c%c%c  %c%c%c%c%c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c    %c  %c       %c           %c    %c   %c       %c %c     %c  %c        %c     %c            %c       %c      %c    %c     %c     %c  %c       %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c    %c  %c       %c       %c%c  %c     %c  %c       %c  %c    %c  %c         %c   %c             %c      %c        %c   %c    %c %c    %c  %c       %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c%c%c%c%c   %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c     %c  %c%c%c%c%c%c  %c   %c   %c  %c          %c %c              %c     %c          %c  %c   %c   %c   %c  %c%c%c%c%c%c  %c%c%c%c%c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c  %c    %c            %c  %c%c  %c     %c  %c       %c    %c  %c  %c           %c               %c      %c        %c   %c  %c     %c  %c  %c       %c  %c  \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c   %c   %c            %c  %c%c  %c    %c   %c       %c     %c %c  %c          %c                %c       %c      %c    %c %c       %c %c  %c       %c   %c \n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat(String.format("%c    %c  %c%c%c%c%c%c  %c%c%c%c%c%c  %c%c  %c%c%c%c%c    %c%c%c%c%c%c  %c       %c   %c%c%c%c%c    %c                 %c          %c%c       %c           %c  %c%c%c%c%c%c  %c    %c\n",i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i,i));
        totalStr = totalStr.concat("--------------------------------------------------------------------------------------------------------------------------------------\n");
        return totalStr;
    }
	//----------------------------------------------------------------------------------------------

    static String blockTitleTXT(String str){
        String totalStr = "\n------------------------------------------------------------------------------------------\n|                                                                                        |\n|";
        int totalLength = 88;
        int firstLength = (totalLength/2) - (str.length()/2);
        int lastLength = totalLength - (firstLength+str.length());
        for (int i = 0; i < firstLength; i++) {
        	totalStr = totalStr.concat(" ");
//            System.out.print(' ');
        }
        totalStr = totalStr.concat(str.toUpperCase());
        for (int i = 0; i < lastLength; i++) {
        	totalStr = totalStr.concat(" ");
//            System.out.print(' ');
        }
        totalStr = totalStr.concat("|\n|                                                                                        |\n------------------------------------------------------------------------------------------\n");
        return totalStr;
    }
	//----------------------------------------------------------------------------------------------
    
    static String subTitleTXT(String str){
        String totalStr = str.toUpperCase();
        totalStr = totalStr.concat("\n");
        for (int i = 0; i < str.length(); i++) {
            totalStr = totalStr.concat("-");
        }
        totalStr = totalStr.concat("\n");
        return totalStr;
    }
	//----------------------------------------------------------------------------------------------
    static String boxTitleTXT(String str) {
    	String totalStr = "\t";
    	for(int i = 0; i < str.length()+4; i++) {
    		totalStr = totalStr.concat("-");
    	}
    	totalStr = totalStr.concat("\n\t| "+str+" |\n\t");
    	for(int i = 0; i < str.length()+4; i++) {
    		totalStr = totalStr.concat("-");
    	}
    	totalStr = totalStr.concat("\n");
    	return totalStr;
    }
	//----------------------------------------------------------------------------------------------
}

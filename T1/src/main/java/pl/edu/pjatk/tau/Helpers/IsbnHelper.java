package pl.edu.pjatk.tau.Helpers;

public class IsbnHelper {
    public static boolean check(String isbn){
        if(isbn == null)
            return false;
        if(!(isbn.matches("[0-9][0-9-]*[0-9]")))
            return false;
        if(isbn.matches(".*[-]{2}.*"))
            return false;

        isbn = isbn.replaceAll( "-", "" );

        switch (isbn.length()){
            case 10:
                return check10(isbn);
//                break;
            case 13:
                return check13(isbn);
//                break;
            default:
                return false;
//                break;
        }
    }

    static boolean check10(String isbn){
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += Integer.parseInt(isbn.substring(i,i+1))*(i+1);
        }
        return sum%11==0;
    }

    static boolean check13(String isbn){
        int sum = 0;
        for ( int i = 0; i < 12; i++ ){
            sum += (i%2==0)?Integer.parseInt(isbn.substring(i,i+1))*1:Integer.parseInt(isbn.substring(i,i+1))*3;
        }

        return ((10000-sum)%10)-Integer.parseInt(isbn.substring(12)) == 0;
    }
}

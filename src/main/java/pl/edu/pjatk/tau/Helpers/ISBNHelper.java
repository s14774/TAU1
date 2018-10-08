package pl.edu.pjatk.tau.Helpers;

public class ISBNHelper {
    public static int IsbnStringToInt(String isbn){
        if(!isbn.matches("[0-9-]*")){
            return 0;
        }
        isbn = isbn.replaceAll( "-", "" );
        return Integer.parseInt(isbn);
    }

    public static boolean check(String isbn){
        return check(IsbnStringToInt(isbn));
    }

    public static boolean check(int isbn){
        switch ((int)(Math.log10(isbn)+1)){
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

    static boolean check10(int isbn){
        return false;
    }

    static boolean check13(int isbn){
        return false;
    }
}

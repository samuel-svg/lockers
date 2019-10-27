package lockers;

public class OneLocker {
    
    public static int NoLocker;
    public static  String estado ;
    public static int UserID;
    
    public OneLocker(){
        
    }
    
    public static boolean ocupado(){
        return (estado.equals("ocupado"));
    }
    
}

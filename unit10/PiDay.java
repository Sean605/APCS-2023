package unit10;

public class PiDay {
    
    public static double piDay(int n, boolean subtract) {
        if(n >= 1000){
            return 0.0;
        } else{
            if(subtract){
                return -4.0/n + piDay(n + 2, false);
            } else{
                return 4.0/n + piDay(n + 2, true);
            }
        }
    }
  
    public static void main(String args[]) {
        //  Gregory–Leibniz
        double pi = piDay(1, false);
  
        // Nilakantha
        //double pi = 3.0 + piDay(3, false);
  
        System.out.println("pi = " + pi);
    }
}


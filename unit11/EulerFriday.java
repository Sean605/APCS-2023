package unit11;
import java.util.ArrayList;

public class EulerFriday {

    public static void main(String[] args) {

        // 1
        int sum1 = 0;
        for (int i = 0; i < 1000; i++) {
            if(i % 3 == 0 || i % 5 == 0){
                sum1 += i;
            }
        }
        System.out.println(sum1);

        // 2
        int num1 = 0, num2 = 1;
        int counter = 0;
        int sum2 = 0;
 
        while (num2 < 4000000) {
 
            if(num2 % 2 == 0){
                sum2 += num2;
            }
            
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
        System.out.println(sum2);

        //3
        long number = 600851475143l;
        int divisor = 2;
        while(number > 1){
            if((number % divisor) == 0){
                number /= divisor;
                divisor--;
            }
            divisor++;
        }
        System.out.println(divisor);

        //4
        int max = 0;

        for(int i = 100; i < 999; i++){
            for(int j = 100; j < 999; j++){
                if(isPalindrome(i * j) && i * j > max){
                    max = i * j;
                }
            }
        }
        System.out.println(max);

    }

    public static boolean isPalindrome(int number){
        String numberString = Integer.toString(number);
        ArrayList<String> check = new ArrayList<>();

        for(int i = numberString.length(); i > 0; i--){
            check.add(numberString.substring(i - 1, i));
        }

        numberString = "";

        for(int i = 0; i < check.size(); i++){
            numberString += check.get(i);
        }

        if(Integer.parseInt(numberString) == number){
            return true;
        }

        return false;
    }
}

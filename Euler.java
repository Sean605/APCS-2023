import java.math.BigInteger;
import java.util.ArrayList;

public class Euler{

    // Calculates if a number "number" is a palindrome
    // Returns true if "number" is a palindrome, and false if it is not

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

    // Problem 1
    public static int problem1(){
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }

        return sum;
    }

    public static int problem2(){
        int num1 = 0, num2 = 1;
        int counter = 0;
        int sum = 0;
 
        while (num2 < 4000000) {
 
            if(num2 % 2 == 0){
                sum += num2;
            }
            
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }

        return sum;
    }

    public static int problem3(){
        long number = 600851475143l;
        int divisor = 2;
        while(number > 1){
            if((number % divisor) == 0){
                number /= divisor;
                divisor--;
            }
            divisor++;
        }

        return divisor;
    }

    public static int problem4(){
        int max = 0;

        for(int i = 100; i < 999; i++){
            for(int j = 100; j < 999; j++){
                if(isPalindrome(i * j) && i * j > max){
                    max = i * j;
                }
            }
        }

        return max;
    }

    public static int problem5(){
        int num = 0;
        int temp = 0;
        
        for(int i = 1; num == 0; i++){
            for(int j = 1; j <= 20; j++){
                if(i % j == 0){
                    temp = i;
                }
                else{
                    temp = 0;
                    j = 20;
                }
            }
            num = temp;
        }

        return num;
    }

    public static long problem6(){
        long sumOfSquares = 0l;
        long squareOfSums = 0l;

        for(int i = 1; i <= 100; i++){
            sumOfSquares += Math.pow(i, 2);
            squareOfSums += i;
        }
        squareOfSums = (long) Math.pow(squareOfSums, 2);

        return squareOfSums - sumOfSquares;
    }

    public static boolean isPrime(long num){
        int counter = 0;
        int sqrt = (int) Math.sqrt(num);

        for(int i = 1; i <= sqrt; i++){
            if(num % i == 0){
                counter++;
            }
            if(counter > 1){
                return false;
            }
        }
        return true;
    }

    public static long problem7(){
        long prime = 0l;
        long test = 1l;

        while(prime < 10001){
            test++;
            if(isPrime(test)){
                prime++;
            }
        }
        return test;
    }

    public static long problem8(){
        String number = 
        "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" + 
        "12540698747158523863050715693290963295227443043557" + 
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450";

        long max = 0l;
        long product = 1l;

        for(int i = 0; i < number.length() - 13; i++){
            for(int j = 1; j <= 13; j++){
                product *= Integer.parseInt(number.substring(i + j - 1, i + j));
            }

            if(product > max){
                max = product;
            }
            product = 1;
        }

        return max;
    }

    public static int problem9(){
        int result = 0;

        for(int a = 1; a < 500; a++){
            for(int b = 1; b < 500; b++){
                for(int c = 1; c < 500; c++){
                    if((a * a) + (b * b) == (c * c) && a + b + c == 1000){
                        result = a*b*c;
                    }
                }
            }
        }
        return result;
    }

    public static BigInteger problem10(){
        BigInteger sum = BigInteger.valueOf(2);
        for(long i = 3; i < 2000000; i += 2){
            if(isPrime(i)){
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        return sum;
    }

    public static long problem11(){
        int[][] will = { {8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8}, 
                         {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00}, 
                         {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65}, 
                         {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91}, 
                         {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80}, 
                         {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50}, 
                         {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70}, 
                         {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21}, 
                         {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72}, 
                         {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95}, 
                         {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92}, 
                         {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57}, 
                         {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58}, 
                         {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40}, 
                         {04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66}, 
                         {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69}, 
                         {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36}, 
                         {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16}, 
                         {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54}, 
                         {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48}, };
        
        int max = 0;
        int temp = 0;

        for(int r = 0; r < will.length; r++){
            for(int c = 0; c < will[r].length; c++){
                //Check down
                if(r < will.length - 4){
                    temp = will[r][c] * will[r + 1][c] * will[r + 2][c] * will[r + 3][c];
                }
                //Check up
                if(r > 4){
                    temp = will[r][c] * will[r - 1][c] * will[r - 2][c] * will[r - 3][c];
                }
                //Check left
                if(c > 4){
                    temp = will[r][c] * will[r][c - 1] * will[r][c - 2] * will[r][c - 3];
                }
                //Check right
                if(c < will[r].length - 4){
                    temp = will[r][c] * will[r][c + 1] * will[r][c + 2] * will[r][c + 3];
                }
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(problem1());
        //System.out.println(problem2());
        //System.out.println(problem3());
        //...
        System.out.println(problem11());
    }

}

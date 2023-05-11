import java.util.ArrayList;

public class Euler{
    public static void main(String[] args) {
        //System.out.println(problem1());
        //System.out.println(problem2());
        //System.out.println(problem3());
        //...
        System.out.println(problem10());

    }

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

        for(int i = 2; i <= num / 2; ++i){
            if(num % i == 0){
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
                product = 1;
            } else{
                product = 1;
            }
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

    public static long problem10(){
        long sum = 2l;
        for(long i = 3l; i < 2000000; i++){
            if(isPrime(i)){
                sum += i;
            }
        }

        return sum;
    }

}

// I pledge my honor that I have abided by the Stevens Honor System.
//HW2 for cpe593 
//author yuzhen Zhang
/** Write a program that takes in 3 integers in the command line, a, b, and r.
and returns gcd(a, b), lcm(a, b), and powermod(a, b, r).
*/

public class HW2{
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return a*b / gcd (a , b);
    }

    public static int powermod(int a, int b, int r){
        int result = 1;
        while(b > 0){
            if (b % 2 != 0) {
                result = result * a % r;
                        }
            a = (a * a )%r;
            b /= 2;
        }
        return result;

    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Please provide exactly three integers: a, b, and r.");
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int r = Integer.parseInt(args[2]);
        int gcd = gcd(a, b);
        int lcm = lcm(a, b);
        int powermod = powermod(a, b, r);
        System.out.println("The gcd of " + a + " and " + b + " is " + gcd);
        System.out.println("The lcm of " + a + " and " + b + " is " + lcm);
        System.out.println("The powermod of " + a + "^" + b + " % " + r + " is " + powermod);
    }
}
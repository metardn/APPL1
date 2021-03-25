// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
//
// **************************************************************** 
package factorials;

import java.util.Scanner;

public class Factorials {
    public static void main(String[] args) {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            System.out.print("Enter an integer: ");
            try{
                int val = scan.nextInt();
                System.out.println("Factorial(" + val + ") = "
                                + MathUtils.factorial(val));
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        } 
    }
    
}
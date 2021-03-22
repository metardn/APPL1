// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// **************************************************************** 
package factorials;

public class MathUtils {
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException{
        if(n>=17)
            throw new IllegalArgumentException( n + " is not under 17, can't operate it");
        if(n<0)
            throw new IllegalArgumentException(n + " is negative, can't operate it");
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    } 
}
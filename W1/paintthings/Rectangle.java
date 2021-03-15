//*****************************************
// Rectangle.java  Author: Meta Arda Nabila
//
//*****************************************
package paintthings;

public class Rectangle extends Shape {
    private double length;
    private double width;
    
    //----------------------------------
    // Constructor: Sets up the rectangle.
    //----------------------------------
    public Rectangle(double Length, double Width) {
        super("Rectangle");
        length = Length;
        width = Width;
    }
    
    //-----------------------------------------
    // Returns the surface area of the rectangle.
    //-----------------------------------------
    public double area() {
        return length * width;
    }
    
    //-----------------------------------
    // Returns the rectangle as a String.
    //-----------------------------------
    public String toString()
    {
        return super.toString() + " of length " + length + " and witdh " + width;
    }
}

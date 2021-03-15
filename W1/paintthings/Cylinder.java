//*****************************************
// Cylinder.java  Author: Meta Arda Nabila
//
//*****************************************
package paintthings;

public class Cylinder extends Shape {
    private double radius;
    private double height;
    
    //----------------------------------
    // Constructor: Sets up the cylinder.
    //----------------------------------
    public Cylinder(double Radius, double Height) {
        super("Cylinder");
        radius = Radius;
        height = Height;
    }
    
    //-----------------------------------------
    // Returns the surface area of the cylinder.
    //-----------------------------------------
    public double area() {
        return Math.PI*radius*radius*height;
    }
    
    //-----------------------------------
    // Returns the cylinder as a String.
    //-----------------------------------
    public String toString()
    {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}

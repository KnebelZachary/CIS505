

public class Fan {
     // Constants for fan speed
     public static final int STOPPED = 0;
     public static final int SLOW = 1;
     public static final int MEDIUM = 2;
     public static final int FAST = 3;
 
     // Private data fields
     private int speed;
     private boolean on;
     private double radius;
     private String color;
 
     // No-argument constructor
     public Fan() {
         this.speed = STOPPED;
         this.on = false;
         this.radius = 6;
         this.color = "white";
     }
 
     // Argument constructor
     public Fan(int speed, boolean on, double radius, String color) {
         this.speed = speed;
         this.on = on;
         this.radius = radius;
         this.color = color;
     }
 
     // Accessor methods
     public int getSpeed() {
         return speed;
     }
 
     public boolean isOn() {
         return on;
     }
 
     public double getRadius() {
         return radius;
     }
 
     public String getColor() {
         return color;
     }
 
     // Mutator methods
     public void setSpeed(int speed) {
         this.speed = speed;
     }
 
     public void setOn(boolean on) {
         this.on = on;
     }
 
     public void setRadius(double radius) {
         this.radius = radius;
     }
 
     public void setColor(String color) {
         this.color = color;
     }
 
// Override toString method
@Override
public String toString() {
    if (on) {
        return "The fan speed is set to " + speed + " with a color of " + color + " and a radius of " + radius;
    } else {
        return "The fan is " + color + " with a radius of " + radius + " and the fan is off";
    }
}
}

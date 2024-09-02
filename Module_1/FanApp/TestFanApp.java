public class TestFanApp {
    public static void main(String[] args) {
        // Create an instance of Fan using the default constructor
        Fan defaultFan = new Fan();

        // Create an instance of Fan using the argument constructor
        Fan customFan = new Fan(Fan.MEDIUM, true, 10, "blue");

        // Display the objects by invoking the toString() method
        System.out.println("Default Fan: " + defaultFan.toString());
        System.out.println("Custom Fan: " + customFan.toString());
    }
}

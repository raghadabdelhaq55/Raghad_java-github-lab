// RobotDog.java
public class RobotDog extends Animal implements Rechargeable {
    private int batteryLevel;

    public RobotDog(String name, int age, int batteryLevel) {
        super(name, age); // Call parent constructor
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void makeSound() {
        System.out.println("Beep! Woof! (Robot Dog Sound)");
    }

    @Override
    public void eat() {
        super.eat(); // Call parent version
        System.out.println("RobotDog uses electricity instead of food.");
    }

    @Override
    public void recharge() {
        batteryLevel = 100;
        System.out.println(Name + " is recharged to " + batteryLevel + "%.");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    // for demonstration
    public void drain(int amount) {
        batteryLevel = Math.max(0, batteryLevel - amount);
    }
}

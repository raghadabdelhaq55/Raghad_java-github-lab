public class OOPExperiments {
    public static void main(String[] args) {
        //RobotDog dog = new Animal();         //  Compile error – A parent (Animal) can't be stored in a child (RobotDog) variable.
        Animal dog2 = new RobotDog("Bolt", 2, 80);   // ✅
        Rechargeable dog3 = new RobotDog("Rex", 3, 90);  // ✅ if RobotDog implements Rechargeable
        Animal a = new RobotDog("Bolt", 2, 90);
        a.eat();
        a.makeSound();
    }
}

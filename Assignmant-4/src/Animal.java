
public abstract class Animal {
    protected String Name;
    protected int Age;


    public Animal(String name, int age) {
        this.Name = name;
        this.Age = age;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println(Name + " is eating...");
    }
}


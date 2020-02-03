public class Teacher extends Person {

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("I'm a Teacher");
    }
}

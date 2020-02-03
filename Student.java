public class Student extends Person {
    public Student(String name,int age){
        super(name, age);
    }

    @Override
    public void say() {
        System.out.println("I'm a student");
    }

}

public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //phan nay de cac class con override
    public abstract void say();
    public String toString(){
        return ("Name: " + name +", age: " + age);
    }
}



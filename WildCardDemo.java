import java.util.ArrayList;
import java.util.List;


//http://tunghuynh.net/programer/java/1916/java-phan-3-cach-su-dung-wildcard-trong-java/
public class WildCardDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Danny", 29));

        List<Teacher> lstTeacher = new ArrayList<>();
        lstTeacher.add(new Teacher("Andrew", 20));

        System.out.println(list.toString());

        findMaxAge(list);
    }
    /**
     * Ta hoàn toàn có thể truyền 1 đối tượng của lớp Student hoặc Teacher
     * vào method showInfor() nhưng lại không thể truyền trực tiếp List<Student>
     *     hay List<Teacher>
     *     vào method findMaxAge() ở trên vì lỗi sai kiểu.
     *
     * Đây là lúc cần biết đến Wildcard.
     * Kỹ thuật này giúp ta có thể truyền 1 collection
     * của lớp con vào collection lớp cha theo cách giống như method showInfor()*/

    public static void findMaxAge(List<? extends Person> person){
            Person maxAge = null;
            for (Person p : person){
                if (maxAge == null || maxAge.age < p.age) {
                    maxAge = p;
                }
            }
            if (maxAge != null){
                showInfo(maxAge);
            }
    }


    public static void showInfo(Person p) {
        System.out.println(String.format("%s, %d years old", p.name, p.age));
        p.say();
    }

}

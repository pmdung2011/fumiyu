//https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/
public class GenericMethod {
    //Create generic method
//    E	Element – phần tử
//    K	Key – khóa
//    V	Value – giá trị
//    T	Type – kiểu dữ liệu
//    N	Number – số
    public <T> void printArray(T[] inputArray){
        //Display array method using for loop
        for (T element : inputArray){
            System.out.print(element);
        }
        System.out.println();
    }

    public static void main(String[] args){
        //Create # arrays
        Integer[] integerArr = {1,2,3,4,5};
        String[] stringArr = {"str","arr","1"};
        GenericMethod gene = new GenericMethod();
        System.out.println("Test with Integer: ");
        gene.printArray(integerArr);
        System.out.println();
        gene.printArray(stringArr);
    }
}

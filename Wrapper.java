import java.util.ArrayList;
public class Wrapper{
    public static void main(String[] args){
        Integer myInt = 5;
        Double myDouble = 5.0;
        Character myChar = 'a';
        /*
        Sometimes you must use wrapper classes,
        for example when working with Collection objects, such as ArrayList,
        where primitive types cannot be used (the list can only store objects)
        * */
        ArrayList <Integer> myNumbers = new ArrayList<Integer>();

        /**Since you're now working with objects, 
         * you can use certain methods to get information about 
         * the specific object.

         For example, the following methods are used to get the value associated
         with the corresponding wrapper object:
         intValue(), byteValue(), shortValue(), longValue(),
         floatValue(), doubleValue(), charValue(),
         booleanValue() */

        System.out.println("myInt Double Value:" + myInt.doubleValue());
        System.out.println("myInt Integer Value:" +myInt.intValue());
        System.out.println("myChar charValue: " + myChar.charValue());

        /*method is the toString() method,
        which is used to convert wrapper objects to strings*/
        String myString = myInt.toString();
        System.out.println(myString.length());
        System.out.println(myString);
    }
}
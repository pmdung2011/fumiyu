//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.Scanner;
//
//public class CreateFile {
//
//    static void writeFile(String name) throws IOException {
//
//        FileWriter file = new FileWriter(name);
//        file.write("Let see what is happening in here.");
//        file.close();
//        System.out.println("Written");
//
//    }
//
//    static void createFile(String name) throws IOException {
//
//        File f = new File(name);
//        if (f.createNewFile()) {
//            System.out.println("File created: " + f.getName());
//        } else {
//            System.out.println("File already exists");
//
//        }
//    }
//
//    static void tryCatch (Method method){
//            try {
//                .invoke();
//            } catch (IOException e) {
//                System.out.println("ERROR");
//                e.printStackTrace();
//            }
//
//    }
//
//    static void readFile(String name) throws IOException{
//        File myObj = new File(name);
//        Scanner read = new Scanner(myObj);
//        while(read.hasNextLine()){
//            String data = read.nextLine();
//            System.out.println(data);
//        }
//        read.close();
//    }
//    public static void main(String[] args) throws IOException {
//        CreateFile.tryCatch(createFile("test.txt"));
//
//    }
//
//}
//
//

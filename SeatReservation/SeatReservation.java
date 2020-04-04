import java.util.Scanner;

public class SeatReservation {

    public static void main(String[] args){

        Theater theatre = new Theater("Galaxy", 10, 15);
        theatre.getSeats();

        Scanner sc = new Scanner(System.in);

        boolean quit = false;

        while(!quit){
            System.out.print("Enter seat number: ");
            String ans = sc.nextLine();
            String name = ans.substring(0,1).toUpperCase() + ans.substring(1);
            if(theatre.reserveSeat(name)){
                System.out.println("Please pay.");
            }
            else{
                System.out.println("Seat is taken.");
            }
            System.out.println("Continue ? (Y/N)");
            String rep = sc.next();
            if(rep.equals("N") || rep.equals("n")){
                quit = true;
            }
        }
    }
}


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayListOperator {

    public static void play(LinkedList<Song> playlist) {
        Playlist pl = new Playlist("playlist");
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> iterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in the playlist.");
            return;
        }
        else
        {
            System.out.print("Now playing: \n");
            System.out.println(iterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward){ //Note that alternating calls to next and previous will return the same element repeatedly.
                                    //vd: A B C, next() = A, next() = B
                                    // next() = A, prev() = A;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        forward = true;
                    }
                    if(iterator.hasNext()){
                        System.out.println("Now playing " + iterator.next().toString());
                    }
                    else{
                        System.out.println("End of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()){
                        System.out.println("Now playing " + iterator.previous().toString());
                    }
                    else{
                        System.out.println("Start of the list.");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(iterator.hasPrevious()){
                            System.out.println("Replaying " + iterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("At the start of the list");
                        }
                    }
                    else{
                        if(iterator.hasNext()){
                            System.out.println("Replaying " + iterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("Reach end of the list.");
                        }
                    }
                    break;
                case 4:
                    pl.playListPrint(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0){
                        iterator.remove();
                        if(iterator.hasNext()){
                            System.out.println("Now playing " + iterator.next());
                        }
                        else if(iterator.hasPrevious()){
                            System.out.println("Now playing " + iterator.previous());
                        }
                    }
                    break;
            }

        }
    }

    private static void printMenu(){
        System.out.println("Menu: ");
        System.out.println("0-Quit\n"
        + "1-Next song\n"
        +"2-Previous song\n"
        +"3-Replay the song\n"
                +"4-List songs\n"
        +"5-Menu options\n"
        +"6-Delete current song");
    }
}

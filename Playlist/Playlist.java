import java.util.Iterator;
import java.util.LinkedList;

public class Playlist{

    LinkedList<Song> playlist;
    private String playListName;
    public Playlist(String playlistName) {
        playlist = new LinkedList<>();
        this.playListName = playlistName;
    }

    public void playListPrint(LinkedList<Song> playlist){
//        System.out.println(playListName + "'s info:");
//        toString(playlist);
//    }
//
//    private static void toString(LinkedList<Song> pl){
//        for(Song i : pl){
//            System.out.print("Title: " + i.getTitle() +" - Duration: " + i.getDuration());
//            System.out.println("");
//        }
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("========================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=========================");
    }

}

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/*
        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()
        //LinkedList is faster in add and remove, so the Playlist should be in Linkedlist
        */
public class LinkedListSongPlaylist {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void play(LinkedList<Song> playlist) {
        ListIterator<Song> iterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in the playlist.");
            return;
        }
        else System.out.println("Now playing: " + iterator.next().toString());
    }


    public static void main(String[] args) throws Exception {
        //PlayListOperator op = new PlayListOperator();

        Album album = new Album("Stormy Night", "Nightwish");
        album.addSong("NightSun", 3.2);
        album.addSong("NightWindy", 1.2);
        album.addSong("NightRain", 32.2);
        album.addSong("NightFall", 12.2);
        album.addSong("NightSummer", 5.2);
        album.addSong("NightWinter", 6.2);
        album.addSong("NightPapa", 7.2);
        album.addSong("NightMama", 12.2);
        albums.add(album);

        album = new Album("My Love", "BSB");
        album.addSong("Welcome back", 3.4);
        album.addSong("Welcome Home", 2.4);
        album.addSong("Olah", 3.6);
        album.addSong("Amigo", 5.4);
        album.addSong("BIg Burro", 1.1);
        album.addSong("Pendejo", 2.6);
        albums.add(album);

        Playlist pl = new Playlist("playList1");

        albums.get(0).addToPlaylist("NightSun", pl.playlist);
        albums.get(0).addToPlaylist("NightSummer", pl.playlist);
        albums.get(0).addToPlaylist("NightFallen", pl.playlist); //Not exist
        albums.get(1).addToPlaylist("Welcome Home", pl.playlist);
        albums.get(1).addToPlayList(5,pl.playlist);


        pl.playListPrint(pl.playlist);
        PlayListOperator.play(pl.playlist);
    }

}

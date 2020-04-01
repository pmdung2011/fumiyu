import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    //add song to album
    public boolean addSong(String title, double duration){
        if(!findSong(title)){
            songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private boolean findSong(String title){
        for (Song i : songs){
            if(i.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    private Song getSong(String title){
        HashMap<String, Song> songHashMap = ConvertToHashMap(songs);
        Song song = songHashMap.get(title);
        return song;


    }

    private HashMap<String, Song> ConvertToHashMap(ArrayList<Song> aL)
    {
        //TODO: Convert arraylist to hashmap
        HashMap<String,Song> hashmap = new HashMap<>();
        for(Song i : aL){
            hashmap.put(i.getTitle(), i);
        }
        return hashmap;
        /*
         * Method 2:
         * for(Song checkedSong : this.songs){
         *   if(checkedSong.getTitle().equals(title)){
         *       return checkedSong;
         *   }
         * }
         * return null;
         * */
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playListName){
        //boolean isOK = findSong(title);
        //System.out.println(title + " " + isOK);
        if(findSong(title)){
            playListName.add(getSong(title));
            return true;
        }
        System.out.println("The song: " + title + " does not exist.");
        return false;
    }

    //Instead of input the name of a song, we can input trackNo in the list
    public boolean addToPlayList(int trackNo, LinkedList<Song> playListName){
        int index = trackNo - 1;
        if((index >= 0) && (index <= songs.size())){
            playListName.add(songs.get(index));
            return true;
        }
        System.out.println("The song: "  + songs.get(index) + " does not exist.");
        return false;
    }


}

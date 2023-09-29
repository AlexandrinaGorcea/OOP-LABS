public class Main{
    public static void main(String[] args) {
        Song song1 = new Song("Song Title 1", "Artist 1", 182);
        Song song2 = new Song("Song Title 2", "Artist 2", 215);

        song1.displayInfo();
        System.out.println();
        song2.displayInfo();
    }
}
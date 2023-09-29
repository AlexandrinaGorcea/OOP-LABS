class Song {
    private String title;
    private String artist;
    private int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration + " seconds");
    }
}
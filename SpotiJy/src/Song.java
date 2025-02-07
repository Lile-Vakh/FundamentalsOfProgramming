import java.util.Objects;

public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;

    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }
    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }
    public boolean changeDuration(int duration) {
        if(duration < 0 || duration > 720 || duration == this.getDuration()) {
            return false;
        }
        this.duration = duration;
        return true;
    }

    public void like() {
        this.likes++;
    }

    public void unlike() {
        if(this.likes > 0) this.likes--;
    }

    public String toString() {
        return "Title:" + title +
                ",Duration:" + (float)duration / 60 + " minutes,Release year:" + releaseYear +
                ",Likes:" + likes;
    }

    public boolean isEqual(Song other) {
        return Objects.equals(this.getTitle(), other.title)
                && this.getReleaseYear() == other.releaseYear
                && this.getDuration() == other.duration;
    }


}

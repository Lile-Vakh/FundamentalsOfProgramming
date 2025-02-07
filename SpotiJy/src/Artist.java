import java.util.Objects;

public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getSecondName () {
        return this.lastName;
    }

    public int getBirthYear () {
        return this.birthYear;
    }

    public Album []getAlbums () {
        return this.albums;
    }

    public Song[] getSingles () {
        return this.singles;
    }

    public Song mostLikedSong () {
        Song mostLiked1 = null;
        for(int k = 0; k < albums.length; k++) {
            Song[] temp = albums[k].getSongs();
            mostLiked1 = temp[0];
            for(int i = 1; i < temp.length; i++) {
                if (mostLiked1.getLikes() > temp[i].getLikes())
                    mostLiked1 = temp[i];
            }
        }

        Song mostLiked2 = this.singles[0];
        for(int k = 1; k < singles.length; k++) {
            if (mostLiked2.getLikes() > this.singles[k].getLikes())
                mostLiked2 = this.singles[k];
        }

        return (mostLiked1.getLikes() > mostLiked2.getLikes()) ? mostLiked1 : mostLiked2;
    }

    public Song leastLikedSong () {
        Song leastLiked1 = null;
        for(int k = 0; k < albums.length; k++) {
            Song[] temp = albums[k].getSongs();
            leastLiked1 = temp[0];
            for(int i = 1; i < temp.length; i++) {
                if (leastLiked1.getLikes() < temp[i].getLikes())
                    leastLiked1 = temp[i];
            }
        }

        Song leastLiked2 = this.singles[0];
        for(int k = 1; k < singles.length; k++) {
            if (leastLiked2.getLikes() < this.singles[k].getLikes())
                leastLiked2 = this.singles[k];
        }

        return (leastLiked1.getLikes() < leastLiked2.getLikes()) ? leastLiked1 : leastLiked2;
    }

    public int totalLikes () {
        int total = 0;
        for(int k = 0; k < albums.length; k++) {
            Song[] temp = albums[k].getSongs();
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] != null)
                    total += temp[i].getLikes();
            }
        }

        for(int k = 0; k < singles.length; k++)
            total += singles[k].getLikes();


        return total;
    }

    public boolean isEqual(Artist other) {
        return (Objects.equals(this.getFirstName(), other.firstName)
                && Objects.equals(this.getSecondName(), other.lastName)
                && this.getBirthYear() == other.birthYear);
    }

    public String toString() {
        return "'Name:" + firstName + " " + lastName + ",Birth year:" + birthYear +
                ",Total likes:" + totalLikes() + "'";
    }
}
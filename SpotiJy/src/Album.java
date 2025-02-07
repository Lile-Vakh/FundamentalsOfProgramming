public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs;

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public Song[] getSongs() {
        return songs;
    }
    public Album(String title, int releaseYear, Song[] songs) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }

    public int addSongs(Song[] songs) {
        int cnt = 0;
        for (int i = 0; i < songs.length; i++) {
            for (int j = 0; j < this.songs.length; j++) {
                if (songs[i].isEqual(this.songs[j])) {
                    cnt++;
                    break;
                }
            }
            Song[] temp = new Song[this.songs.length + 1];
            for (int k = 0; k < this.songs.length - 1; k++) {
                temp[k] = this.songs[k];
            }

            temp[temp.length - 1] = songs[i];
            this.songs = temp;
        }

        return cnt;
    }

    public Song[] shuffle() {
        Song[] temp = new Song[songs.length];
        for(int k = 0; k < songs.length; k++) {
            temp[k] = songs[(int)(Math.random() * songs.length - 1)];
        }
        return temp;
    }

    public Song[] sortByDuration(boolean isAscending) {
        Song[] temp = new Song[songs.length];
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getDuration() > songs[j].getDuration()) {
                    Song t = songs[i];
                    songs[i] = songs[j];
                    songs[j] = t;
                }
            }
        }

        for (int k = 1; k < songs.length; k++) {
            if(songs[k -1].getDuration() >= songs[k].getDuration())
                isAscending = false;
        }

        if(!isAscending) {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[songs.length - k - 1];
        }
        else {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[k];
        }

        return temp;
    }

    public Song[] sortByReleaseYear(boolean isAscending) {
        Song[] temp = new Song[songs.length];
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getReleaseYear() > songs[j].getReleaseYear()) {
                    Song t = songs[i];
                    songs[i] = songs[j];
                    songs[j] = t;
                }
            }
        }

        for (int k = 1; k < songs.length; k++) {
            if(songs[k -1].getReleaseYear() >= songs[k].getReleaseYear())
                isAscending = false;
        }

        if(!isAscending) {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[songs.length - k - 1];
        }
        else {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[k];
        }

        return temp;
    }

    public Song[] sortByPopularity(boolean isAscending) {
        Song[] temp = new Song[songs.length];
        for (int i = 0; i < songs.length; i++) {
            for (int j = i + 1; j < songs.length; j++) {
                if (songs[i].getLikes() > songs[j].getLikes()) {
                    Song t = songs[i];
                    songs[i] = songs[j];
                    songs[j] = t;
                }
            }
        }

        for (int k = 1; k < songs.length; k++) {
            if(songs[k -1].getLikes() >= songs[k].getLikes())
                isAscending = false;
        }

        if(!isAscending) {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[songs.length - k - 1];
        }
        else {
            for(int k = 0; k < songs.length; k++)
                temp[k] = songs[k];
        }

        return temp;
    }

    public static Song[] reverse(Song[] songs) {
        Song[] temp = new Song[songs.length];
        for(int k = 0; k < songs.length; k++)
            temp[k] = songs[songs.length - k - 1];

        return temp;
    }

    public String toString() {
        String result = "'Title:'" + title + ",Release year:" + releaseYear + ",songs:{";
        for(int k = 0; k < songs.length; k++) {
            result += songs[k].toString();
            if(k != songs.length - 1) result += "|";
        }
        result += "}";
        return result;
    }


}

public class SpotiJy {
    private Artist[] artists;

    public SpotiJy() {
        this.artists = null;
    }

    public Artist[] getArtists () {
        return this.artists;
    }

    public void addArtists(Artist[] artists) {
        for (int i = 0; i < artists.length; i++) {
            for (int j = 0; j < this.artists.length; j++) {
                if (artists[i].isEqual(this.artists[j]))
                    break;
            }
            Artist[] temp = new Artist[this.artists.length + 1];
            for (int k = 0; k < this.artists.length - 1; k++)
                temp[k] = this.artists[k];

            temp[this.artists.length] = artists[i];
            this.artists = temp;
        }
    }

    public String [] getTopTrendingArtist () {
        String[] temp = new String[2];
        int first = this.artists[0].totalLikes();
        for(int k = 1; k < this.artists.length; k++) {
            if(this.artists[k].totalLikes() > first) {
                first = this.artists[k].totalLikes();
                temp[0] = this.artists[k].getFirstName();
                temp[1] = this.artists[k].getSecondName();
            }
        }
        return temp;
    }

    public String getTopTrendingAlbum () {
        int total = 0, mxtotal = 0;
        String title = null;
        for(int k = 0; k < this.artists.length; k++) {
            Album[] curr = this.artists[k].getAlbums();
            for(int i = 0; i < curr.length; i++) {
                Song[] st = curr[i].getSongs();
                for (int j = 0; j < st.length; j++) {
                    total += st[j].getLikes();
                }
                if (total > mxtotal) {
                    mxtotal = total;
                    title = curr[i].getTitle();
                }
            }
        }
        return title;
    }

    public String getTopTrendingSong () {
        Song first = this.artists[0].mostLikedSong();
        for(int k = 1; k < this.artists.length; k++) {
            if(this.artists[k].mostLikedSong().getLikes() > first.getLikes()){
                first = this.artists[k].mostLikedSong();
            }
        }
        return first.getTitle();
    }
}

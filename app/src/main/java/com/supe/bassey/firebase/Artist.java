package com.supe.bassey.firebase;

public class Artist {

    String artistId;
    String artistName;
    String artistGenre;
    String artistCountry;

    public Artist(){

    }

    public Artist(String artistId, String artistName, String artistGenre, String artistCountry) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
        this.artistCountry = artistCountry;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }

    public String getArtistCountry() {
        return artistCountry;
    }
}

package com.DanielKeane.entities;

import java.time.LocalDate;

public class Album {
    private final String id;
    private final String name;
    private final String albumGroup;
    private final int totalTracks;
    private final LocalDate releaseDate;
    private final String imageUrl;

    public Album(String id, String name, String albumGroup, int totalTracks, LocalDate releaseDate, String imageUrl) {
        this.id = id;
        this.name = name;
        this.albumGroup = albumGroup;
        this.totalTracks = totalTracks;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", albumGroup='" + albumGroup + '\'' +
                ", totalTracks=" + totalTracks +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        return getId().equals(album.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlbumGroup() {
        return albumGroup;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

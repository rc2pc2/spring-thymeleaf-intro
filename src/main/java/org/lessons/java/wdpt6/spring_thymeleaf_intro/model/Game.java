package org.lessons.java.wdpt6.spring_thymeleaf_intro.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Game implements Serializable {
    private LocalDate releaseDate;
    private String version;
    private String genre;
    private String name;

    public Game(){}

    public Game(String name, String genre, LocalDate releaseDate, String version){
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.version = version;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%s, v%s, part of %s genre, published on %s", this.name, this.version, this.genre, this.releaseDate.toString());
    }
}

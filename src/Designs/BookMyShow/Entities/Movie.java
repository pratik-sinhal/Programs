package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.Language;

public class Movie {
    int id;
    String title;
    String description;
    String thumbnail;
    Language language;
    int duration;

    public Movie(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

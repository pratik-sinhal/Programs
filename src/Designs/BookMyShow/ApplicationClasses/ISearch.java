package Designs.BookMyShow.ApplicationClasses;

import Designs.BookMyShow.Entities.Show;
import Designs.BookMyShow.Entities.Theatre;

import java.util.Date;
import java.util.List;

public interface ISearch {
    List<Show> listAllShowsInCityForMovie(String city, int movieId, Date date);
}

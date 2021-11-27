package Designs.BookMyShow.ApplicationClasses;

import Designs.BookMyShow.Entities.Show;
import Designs.BookMyShow.Entities.Theatre;

import java.util.Date;
import java.util.List;

public class Search implements ISearch{
    @Override
    public List<Show> listAllShowsInCityForMovie(String city, int movieId, Date date){
        // iterate through all operational theatres in city - scan shows with them and return
        return null;
    }
}

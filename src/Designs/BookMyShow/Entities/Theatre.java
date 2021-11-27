package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Actors.Address;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Theatre {
    int id;
    String name;
    Address address;
    List<Integer> seatArrangementIds;
    //Map<Date, List<Integer>> showIds;
    Map<Date, Boolean> isOperational;

    public Theatre(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

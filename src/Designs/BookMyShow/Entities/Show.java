package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.SeatCategory;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Show {
    int id;
    int movieId;
    int theatreId;
    int seatArrangementId;
    Date date;
    String to;
    String from;
    List<LockedSeat> lockedSeats;
    Map<SeatCategory, Double> seatPricing;

    public Show(int id, int movieId, int theatreId, int seatArrangementId, Date date, String to, String from, List<LockedSeat> lockedSeat, Map<SeatCategory, Double> seatPricing) {
        this.id = id;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.seatArrangementId = seatArrangementId;
        this.date = date;
        this.to = to;
        this.from = from;
        this.lockedSeats = lockedSeat;
        this.seatPricing = seatPricing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public int getSeatArrangementId() {
        return seatArrangementId;
    }

    public void setSeatArrangementId(int seatArrangementId) {
        this.seatArrangementId = seatArrangementId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<LockedSeat> getLockedSeats() {
        return lockedSeats;
    }

    public void setLockedSeats(List<LockedSeat> lockedSeats) {
        this.lockedSeats = lockedSeats;
    }

    public Map<SeatCategory, Double> getSeatPricing() {
        return seatPricing;
    }

    public void setSeatPricing(Map<SeatCategory, Double> seatPricing) {
        this.seatPricing = seatPricing;
    }
}

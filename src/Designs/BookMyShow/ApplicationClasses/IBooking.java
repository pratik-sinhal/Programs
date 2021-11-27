package Designs.BookMyShow.ApplicationClasses;

import Designs.BookMyShow.Entities.Booking;

import java.util.List;

public interface IBooking {
    Booking bookTicket(int userId, int showId, List<Integer> seatIds);
}

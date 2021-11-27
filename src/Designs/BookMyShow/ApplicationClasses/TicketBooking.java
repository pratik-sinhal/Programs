package Designs.BookMyShow.ApplicationClasses;

import Designs.BookMyShow.Constants.BookingStatus;
import Designs.BookMyShow.Constants.LockStatus;
import Designs.BookMyShow.Constants.PaymentMethod;
import Designs.BookMyShow.Constants.PaymentStatus;
import Designs.BookMyShow.Entities.Booking;
import Designs.BookMyShow.Entities.LockedSeat;
import Designs.BookMyShow.Entities.Movie;
import Designs.BookMyShow.Entities.Payment;
import Designs.BookMyShow.Entities.PaymentInfo;
import Designs.BookMyShow.Entities.SeatArrangement;
import Designs.BookMyShow.Entities.Show;
import Designs.BookMyShow.Entities.Theatre;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TicketBooking implements IBooking{

    Movie movie;
    Theatre theatre;
    SeatArrangement seatArrangement;
    Show show;

    public TicketBooking() {
        movie = new Movie(1);
        theatre = new Theatre(1);
        seatArrangement = new SeatArrangement(1);
        show = new Show(1, movie.getId(), theatre.getId(), seatArrangement.getId(), new Date(),
                null, null, new ArrayList<>(), new HashMap<>());
    }

    @Override
    public synchronized Booking bookTicket(int userId, int showId, List<Integer> seatIds) {
        // getShowById - already defined

        // lock the seats - is not already booked - make entry for each seat in LocketSeat class - else just return null
        List<LockedSeat> lockedSeats = show.getLockedSeats();
        if(lockedSeats.size() > 0) {
            for (LockedSeat lockedSeat : lockedSeats) {
                if (lockedSeat.getShowId() == showId && seatIds.contains(lockedSeat.getSeatId())) {
                    System.out.println(Thread.currentThread().getName() + " - seat(s) are already locked");
                    return null;
                }
            }
        }
        seatIds.forEach(seatId -> lockedSeats.add(new LockedSeat(1, seatId, showId, LockStatus.BOOKED)));

        // if locking successful - calculate total payment
        double amount = 500.00;

        // get payment info
        PaymentInfo paymentInfo = new PaymentInfo(PaymentMethod.CREDIT_CARD, "3454", null);

        // initiate payment
        Payment payment = new Payment(1,1L, userId, PaymentStatus.SUCCESSFUL, amount, paymentInfo);

        // if payment succeeded - create booking instance and return
        Booking booking = null;
        if(payment.getStatus() == PaymentStatus.SUCCESSFUL) {
            booking = new Booking(1, payment.getId(), userId, showId, seatIds, BookingStatus.BOOKED);
        }

        return booking;
    }
}

package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.BookingStatus;

import java.util.List;

public class Booking {
    int id;
    int paymentId;
    int userId;
    int showId;
    List<Integer> seatIds;
    BookingStatus status;

    public Booking(int id, int paymentId, int userId, int showId, List<Integer> seatIds, BookingStatus status) {
        this.id = id;
        this.paymentId = paymentId;
        this.userId = userId;
        this.showId = showId;
        this.seatIds = seatIds;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", paymentId=" + paymentId +
                ", userId=" + userId +
                ", showId=" + showId +
                ", seatIds=" + seatIds +
                ", status=" + status +
                '}';
    }
}

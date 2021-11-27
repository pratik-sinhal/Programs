package Designs.BookMyShow.ApplicationClasses;

import Designs.BookMyShow.Entities.Booking;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        IBooking ticketBooking = new TicketBooking();

        new Thread(() -> {
            Booking booking = ticketBooking.bookTicket(1, 1, Arrays.asList(1, 2, 3));
            if(booking != null) {
                System.out.println("booking successful");
                System.out.println(booking);
            } else {
                System.out.println("booking un-successful");
            }
        }).start();

        new Thread(() -> {
            Booking booking = ticketBooking.bookTicket(2, 1, Arrays.asList(1, 2, 3));
            if(booking != null) {
                System.out.println("booking successful");
                System.out.println(booking);
            } else {
                System.out.println("booking un-successful");
            }
        }).start();
    }
}

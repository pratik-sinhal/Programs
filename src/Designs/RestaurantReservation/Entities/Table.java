package Designs.RestaurantReservation.Entities;

import Designs.RestaurantReservation.Enums.ReservationStatus;
import Designs.RestaurantReservation.Enums.TableType;

public abstract class Table {
    private int tableNo;
    private final TableType tableType;
    private ReservationStatus reservationStatus;

    protected Table(TableType tableType) {
        this.tableType = tableType;
    }

    public boolean isBooked() {
        return reservationStatus == ReservationStatus.BOOKED;
    }

    public boolean isAvailable() {
        return reservationStatus == ReservationStatus.AVAILABLE;
    }
}

package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.LockStatus;

public class LockedSeat {
    int id;
    int seatId;
    int showId;
    LockStatus lockStatus;

    public LockedSeat(int id, int seatId, int showId, LockStatus lockStatus) {
        this.id = id;
        this.seatId = seatId;
        this.showId = showId;
        this.lockStatus = lockStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public LockStatus getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(LockStatus lockStatus) {
        this.lockStatus = lockStatus;
    }
}

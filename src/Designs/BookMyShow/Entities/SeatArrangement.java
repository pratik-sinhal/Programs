package Designs.BookMyShow.Entities;

public class SeatArrangement {
    int id;
    int theatreId;
    int numRows;
    int numCols;
    Seat[][] seats;

    public SeatArrangement(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

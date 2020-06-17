package Designs.RestaurantReservation.Actors;

public class Admin extends Account {
    @Override
    public boolean resetPassword() {
        return false;
    }
}

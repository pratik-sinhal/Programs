package Designs.RestaurantReservation.UseCaseClasses;

import Designs.RestaurantReservation.Entities.Restaurant;

import java.util.List;

public interface IReservation {
    List<Restaurant> searchRestaurants(String searchStr);
    Restaurant addRestaurant(Restaurant restaurant);
    boolean removeRestaurant(Restaurant restaurant);
    boolean bookTable();
}

package Designs.RestaurantReservation.Entities;

import Designs.RestaurantReservation.Actors.Address;
import Designs.RestaurantReservation.Enums.RestaurantStatus;
import Designs.RestaurantReservation.Enums.RestaurantType;
import Designs.RestaurantReservation.Enums.TableType;

import java.util.List;
import java.util.Map;

public abstract class Restaurant {
    private Long restaurantNo;
    private RestaurantStatus restaurantStatus;
    private RestaurantType restaurantType;
    private Address address;
    Map<Integer, List<RestaurantFloor>> floors;

    public void addFloor(RestaurantFloor floor) {}

    public boolean isTableAvailable() { return true;}


}

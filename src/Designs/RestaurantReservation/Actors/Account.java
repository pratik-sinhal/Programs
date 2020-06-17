package Designs.RestaurantReservation.Actors;

import Designs.RestaurantReservation.Enums.AccountStatus;

public abstract class Account {
    private Long id;
    private String password;
    private AccountStatus status;
    private Person person;

    public abstract boolean resetPassword();
}

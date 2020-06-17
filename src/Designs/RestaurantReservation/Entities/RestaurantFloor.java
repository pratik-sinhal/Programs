package Designs.RestaurantReservation.Entities;

import Designs.RestaurantReservation.Actors.Address;
import Designs.RestaurantReservation.Enums.RestaurantStatus;
import Designs.RestaurantReservation.Enums.RestaurantType;
import Designs.RestaurantReservation.Enums.TableType;

import java.util.List;
import java.util.Map;

public class RestaurantFloor {
    private Integer floorNo;
    Map<TableType, List<Table>> tables;
    private Integer noOfTables;
    private Integer freeTables;

    public void addTable(Table table) {}
    public void removeTable(Table table) {}
    public boolean isTableAvailable() { return true;}
}

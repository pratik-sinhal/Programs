package Designs.CarParking.Entities;

import Designs.CarParking.Constants.ParkingSlotType;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    int id;
    List<ParkingFloor> parkingFloors;
    Map<ParkingSlotType, Integer> parkingSlotAvailabilityCount;
}

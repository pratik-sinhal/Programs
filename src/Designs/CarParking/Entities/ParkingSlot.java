package Designs.CarParking.Entities;

import Designs.CarParking.Constants.ParkingSlotType;
import Designs.CarParking.Constants.ParkingStatus;

public class ParkingSlot {
    int id;
    int rowNo;
    int colNo;
    ParkingSlotType parkingSlotType;
    double parkingPrice;
    ParkingStatus parkingStatus;
}

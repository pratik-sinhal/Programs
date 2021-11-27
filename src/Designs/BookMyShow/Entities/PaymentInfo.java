package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.PaymentMethod;

public class PaymentInfo {
    PaymentMethod paymentMethod;
    String cardNo;
    String UPINo;

    public PaymentInfo(PaymentMethod paymentMethod, String cardNo, String UPINo) {
        this.paymentMethod = paymentMethod;
        this.cardNo = cardNo;
        this.UPINo = UPINo;
    }
}

package Designs.BookMyShow.Entities;

import Designs.BookMyShow.Constants.PaymentStatus;

public class Payment {
    int id;
    long transactionId;
    int userId;
    PaymentStatus status;
    double amount;
    PaymentInfo paymentInfo;

    public Payment(int id, long transactionId, int userId, PaymentStatus status, double amount, PaymentInfo paymentInfo) {
        this.id = id;
        this.transactionId = transactionId;
        this.userId = userId;
        this.status = status;
        this.amount = amount;
        this.paymentInfo = paymentInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}

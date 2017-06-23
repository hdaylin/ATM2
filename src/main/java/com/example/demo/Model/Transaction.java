package com.example.demo.Model;

/**
 * Created by student on 6/22/17.
 */
public class Transaction {

    private int id;
    private int acct;
    private String action;
    private double amount;
    private String reason;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcct() {
        return acct;
    }

    public void setAcct(int acct) {
        this.acct = acct;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

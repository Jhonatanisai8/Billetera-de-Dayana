package com.mycompany.billetera;

public class Expense {

    //attribute
    private int id;
    private String type;
    private String date;
    private double amount;

    //constructor
    public Expense(int id, String type, String date, double amount) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

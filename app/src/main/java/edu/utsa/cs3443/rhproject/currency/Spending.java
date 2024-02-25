package edu.utsa.cs3443.rhproject.currency;

public class Spending {
    private String object, type;
    private double cost;

    public Spending(String object, String type, double cost) {
        this.object =object;
        this.type = type;
        this.cost = cost;
    }

    public String getObject() {
        return object;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }
}

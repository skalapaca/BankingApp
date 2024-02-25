package edu.utsa.cs3443.rhproject.currency;

import java.util.ArrayList;

public class DinoMoney {
    private double currBalance;
    private ArrayList<Spending> spendings = new ArrayList<Spending>();


    public DinoMoney(double currBalance) { //Constructor
        this.currBalance = currBalance;
    }

    public void deposit(double leaves) {
        currBalance += leaves;
    }

    public boolean spend(Spending spending){
        double cost = spending.getCost();

        if(cost > currBalance) {
            return false;
        }
        currBalance -= cost;
        spendings.add(spending);

        return true;
    }

    public double getBalance() {
        return currBalance;
    }
}

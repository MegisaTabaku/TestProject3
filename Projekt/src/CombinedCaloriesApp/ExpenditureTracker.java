package CombinedCaloriesApp;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureTracker {
    private List<Double> expenditures = new ArrayList<>();
    private static final double MONTHLY_SPENDING_LIMIT = 1000.0;

    // Method to add a food price
    public void addExpenditure(double price) {
        expenditures.add(price);
    }

    // Method to check if the monthly spending limit has been exceeded
    public boolean isSpendingLimitExceeded() {
        double totalExpenditure = expenditures.stream().mapToDouble(Double::doubleValue).sum();
        return totalExpenditure > MONTHLY_SPENDING_LIMIT;
    }

    // Method to get total expenditure for the month
    public double getTotalExpenditure() {
        return expenditures.stream().mapToDouble(Double::doubleValue).sum();
    }
}

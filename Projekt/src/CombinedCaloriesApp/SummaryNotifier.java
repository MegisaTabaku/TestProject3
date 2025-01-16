package CombinedCaloriesApp;



import java.util.List;

public class SummaryNotifier {
    private int totalCalories;
    private double totalExpenditure;
    private int daysExceeded;

    // Method to generate weekly summary
    public void generateWeeklySummary(List<FoodEntry> foodEntries, ExpenditureTracker expenditureTracker) {
        totalCalories = CalorieManager.getTotalCalories(foodEntries);
        totalExpenditure = expenditureTracker.getTotalExpenditure();
        daysExceeded = (int) foodEntries.stream()
                .filter(entry -> entry.getCalorieValue() > 2500) // Updated to use getter
                .count();
    }

    // Method to notify user of the summary
    public void notifyUser() {
        System.out.println("Weekly Summary:");
        System.out.println("Total Calories Consumed: " + totalCalories);
        System.out.println("Total Expenditure: " + totalExpenditure);
        System.out.println("Days Exceeded Calorie Limit: " + daysExceeded);
    }
}

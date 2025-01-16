package CombinedCaloriesApp;



import java.util.List;

public class AdminManagerComplete {
    public void viewFoodEntries(List<FoodEntry> foodEntries) {
        System.out.println("Food Entries:");
        for (FoodEntry entry : foodEntries) {
            System.out.println("Food: " + entry.getFoodName() + ", Calories: " + entry.getCalorieValue());
        }
    }

    public void generateReport(List<FoodEntry> foodEntries) {
        int totalCalories = 0;
        for (FoodEntry entry : foodEntries) {
            totalCalories += entry.getCalorieValue();
        }
        System.out.println("Total Calories Consumed: " + totalCalories);
    }
}


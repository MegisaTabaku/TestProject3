package CombinedCaloriesApp;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private List<FoodEntry> foodEntries = new ArrayList<>();

    // Method to add a food entry
    public void addFoodEntry(FoodEntry foodEntry) {
        foodEntries.add(foodEntry);
    }

    // Method to update a food entry
    public void updateFoodEntry(int index, FoodEntry updatedEntry) {
        if (index >= 0 && index < foodEntries.size()) {
            foodEntries.set(index, updatedEntry);
        }
    }

    // Method to delete a food entry
    public void deleteFoodEntry(int index) {
        if (index >= 0 && index < foodEntries.size()) {
            foodEntries.remove(index);
        }
    }

    // Method to generate admin reports
    public void generateAdminReport() {
        System.out.println("Admin Report:");
        System.out.println("Total Food Entries: " + foodEntries.size());
        // Additional statistics can be added here
    }
}
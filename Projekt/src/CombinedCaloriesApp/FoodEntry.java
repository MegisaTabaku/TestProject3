package CombinedCaloriesApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodEntry {  
    // Existing fields and constructor remain unchanged

    // Getter for foodName
    public String getFoodName() {
        return foodName;
    }

    // Getter for calorieValue
    public int getCalorieValue() {
        return calorieValue;
    }
    private LocalDateTime dateTime;
    private String foodName;
    private int calorieValue;

    // List to store food entries
    private static List<FoodEntry> foodEntries = new ArrayList<>();

    // Constructor
    public FoodEntry(LocalDateTime dateTime, String foodName, int calorieValue) {
        this.setDateTime(dateTime);
        this.foodName = foodName;
        this.calorieValue = calorieValue;
    }

    // Method to add a new food entry
    public static void addFoodEntry(LocalDateTime dateTime, String foodName, int calorieValue) {
        foodEntries.add(new FoodEntry(dateTime, foodName, calorieValue));
    }

    // Method to retrieve all food entries
    public static List<FoodEntry> getFoodEntries() {
        return foodEntries;
    }

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}


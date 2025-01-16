package CombinedCaloriesApp;

import java.util.ArrayList;
import java.util.List;
import CombinedCaloriesApp.UserAccount;
import CombinedCaloriesApp.ExpenditureTracker;
import CombinedCaloriesApp.CalorieManager;
import CombinedCaloriesApp.AdminManagerComplete;
import CombinedCaloriesApp.AccessControl;
import CombinedCaloriesApp.FoodEntry;
import java.time.LocalDateTime;
import java.util.Scanner;  
import java.util.InputMismatchException;  
import java.util.logging.Logger;  
import java.util.logging.Level;  

@SuppressWarnings("unused")
public class MainCompleteFinalUpdated {  
    private static final Logger logger = Logger.getLogger(MainCompleteFinalUpdated.class.getName());  

    private static void exitConfirmation(Scanner scanner) {  
        System.out.print("Are you sure you want to exit? (yes/no): ");  
        String response = scanner.nextLine();  
        if (response.equalsIgnoreCase("yes")) {  
            System.out.println("Exiting...");  
            scanner.close();  
            System.exit(0);  
        }  
    }  

    private static int getUserChoice(Scanner scanner) {  
        int choice = -1;  
        while (choice < 1 || choice > 3) {  
            try {  
                System.out.print("Choose an option: ");  
                choice = scanner.nextInt();  
                scanner.nextLine(); // Consume newline  
            } catch (InputMismatchException e) {  
                System.out.println("Invalid input. Please enter a number.");  
                scanner.nextLine(); // Clear the invalid input  
            }  
        }  
        return choice;  
    }  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccount userAccount = new UserAccount();
        ExpenditureTracker expenditureTracker = new ExpenditureTracker();
        CalorieManager calorieManager = new CalorieManager();
        AdminManagerComplete adminManager = new AdminManagerComplete();
        AccessControl accessControl;
        List<FoodEntry> foodEntries = new ArrayList<>();

        System.out.println("Welcome to the Calories Calculation Application!");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = getUserChoice(scanner); // Use the new method for user choice

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (userAccount.createAccount(username, password)) {
                        System.out.println("Account created successfully!");
                        logger.info("Account created for user: " + username); // Log account creation
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (userAccount.login(username, password)) {
                        System.out.println("Login successful!");
                        logger.info("User logged in: " + username); // Log login
                        accessControl = new AccessControl("user"); // Set user role

                        // Check if user is admin
                        if (accessControl.isAdmin()) {
                            while (true) {
                                System.out.println("Admin Menu:");
                                System.out.println("1. View Food Entries");
                                System.out.println("2. Generate Report");
                                System.out.println("3. Logout");
                                int adminChoice = getUserChoice(scanner); // Use the new method for admin choice

                                switch (adminChoice) {
                                    case 1:
                                        adminManager.viewFoodEntries(foodEntries);
                                        break;

                                    case 2:
                                        adminManager.generateReport(foodEntries);
                                        break;

                                    case 3:
                                        System.out.println("Logging out...");
                                        logger.info("Admin logged out: " + username); // Log logout
                                        break;

                                    default:
                                        System.out.println("Invalid option. Please try again.");
                                }

                                if (adminChoice == 3) {
                                    break; // Exit admin functionalities
                                }
                            }
                        } else {
                            // User functionalities
                            while (true) {
                                System.out.println("1. Add Food Entry");
                                System.out.println("2. Check Calorie Limit");
                                System.out.println("3. Logout");
                                int userChoice = getUserChoice(scanner); // Use the new method for user choice

                                switch (userChoice) {
                                    case 1:
                                        System.out.print("Enter food name: ");
                                        String foodName = scanner.nextLine();
                                        System.out.print("Enter calorie value: ");
                                        int calorieValue = scanner.nextInt();
                                        foodEntries.add(new FoodEntry(LocalDateTime.now(), foodName, calorieValue));
                                        System.out.println("Food entry added successfully!");
                                        logger.info("Food entry added: " + foodName + " (" + calorieValue + " calories)"); // Log food entry
                                        break;

                                    case 2:
                                        if (CalorieManager.isCalorieLimitExceeded(foodEntries)) {
                                            System.out.println("You have exceeded your daily calorie limit!");
                                        } else {
                                            System.out.println("You are within your daily calorie limit.");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Logging out...");
                                        logger.info("User logged out: " + username); // Log logout
                                        break;

                                    default:
                                        System.out.println("Invalid option. Please try again.");
                                }

                                if (userChoice == 3) {
                                    break; // Exit user functionalities
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 3:
                    exitConfirmation(scanner); // Use the new exit confirmation method
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

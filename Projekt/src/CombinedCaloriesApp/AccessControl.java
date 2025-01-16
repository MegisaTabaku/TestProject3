package CombinedCaloriesApp;


public class AccessControl {
    private String userRole; // "admin" or "user"

    public AccessControl(String userRole) {
        this.userRole = userRole;
    }

    // Method to check if the user is an admin
    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(userRole);
    }

    // Method to restrict access to admin features
    public void restrictAccess() {
        if (!isAdmin()) {
            throw new SecurityException("Access denied: Admins only.");
        }
    }
}


package saikat.system.app.basicbankingsystem;


import static saikat.system.app.util.InputUtil.getIntegerInput;

public class BankAccount {
    private final UserRepository userRepository = new UserRepository();

    public void start() {
        System.out.println("\n\t\tWelcome to the Bank Account System!");
        boolean flag = true;
        while (flag) {
            Integer choice = getIntegerInput("""
                               
                    Please select an option:
                    1. Add a new user
                    2. View all users
                    3. Deposit to a user's account
                    4. Withdraw from a user's account
                    5. Exit
                    Your choice""");
            switch (choice) {
                case 1 -> {
                    userRepository.userAdd();
                    System.out.println("User added successfully!");
                }
                case 2 -> {
                    if (userRepository.getUSER_LIST().isEmpty()) {
                        System.out.println("No users found in the system!");
                    } else {
                        System.out.println("List of all users:");
                        for (User user : userRepository.getUSER_LIST()) {
                            System.out.println(user);
                        }
                    }
                }
                case 3 -> {
                    Integer userId = getIntegerInput("Enter the userId");
                    User user = (User) userRepository.findById(userId);
                    if (user != null) {
                        System.out.println("User found: " + user);
                        System.out.println("Current balance: " + user.getUserBalance());
                        user.deposit();
                        System.out.println("Updated balance: " + user.getUserBalance());
                    } else {
                        System.out.println("User with ID: " + userId + " not found!");
                    }
                }
                case 4 -> {
                    Integer userID = getIntegerInput("Enter the userId");
                    User user2 = userRepository.findById(userID);
                    if (user2 != null) {
                        System.out.println("User found: " + user2 + " ,userBalance: " + user2.getUserBalance());
                        System.out.println("Current balance: " + user2.getUserBalance());
                        user2.withDraw();
                        System.out.println("Updated balance: " + user2.getUserBalance());
                    } else {
                        System.out.println("User with ID: " + userID + " not found!");
                    }
                }
                case 5 -> {
                    System.out.println("Goodbye! Thank you for using our banking system.");
                    flag = false;
                }
                default -> System.out.println("Invalid input,Please try again!");
            }
        }
    }
}

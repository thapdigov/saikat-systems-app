package saikat.system.app.basicbankingsystem;

import static saikat.system.app.util.InputUtil.getDoubleInput;

public class User {
    private Integer userId;
    private String username;
    private Double userBalance;

    public User() {
    }

    public User(Integer userId, String username, Double userBalance) {
        this.userId = userId;
        this.username = username;
        this.userBalance = userBalance;
    }

    public void deposit() {
        boolean flag = true;
        while (flag) {
            try {
                Double depositBalance = getDoubleInput("Enter the deposit amount");
                if (depositBalance <= 0) {
                    throw new IllegalArgumentException("Deposit amount must be greater than 0!");
                }
                setUserBalance(getUserBalance() + depositBalance);
                flag = false;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public void withDraw() {
        boolean flag = true;
        while (flag) {
            try {
                Double withdrawAmount = getDoubleInput("Enter the withdrawal amount");
                if (withdrawAmount <= 0) {
                    throw new IllegalArgumentException("Withdrawal amount must be greater than 0!");
                }
                if (withdrawAmount > getUserBalance()) {
                    throw new IllegalArgumentException("Insufficient balance! Please try a smaller amount!");
                }
                setUserBalance(getUserBalance() - withdrawAmount);
                flag = false;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "User ->" + "userId: " + userId + " ,username: " + username;
    }
}

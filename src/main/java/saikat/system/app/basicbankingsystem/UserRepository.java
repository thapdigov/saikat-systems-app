package saikat.system.app.basicbankingsystem;

import saikat.system.app.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

import static saikat.system.app.util.InputUtil.*;

public class UserRepository {
    private final List<User> USER_LIST = new ArrayList<>();

    public void userAdd() {
        User user = new User();
        Integer userId = getIntegerInput("Enter the user Id");
        String username = InputUtil.getStringInput("Enter the username");
        Double userBalance = getDoubleInput("Enter the user balance");
        user.setUserId(userId);
        user.setUsername(username);
        user.setUserBalance(userBalance);
        USER_LIST.add(user);
    }

    public List<User> getUSER_LIST() {
        return USER_LIST;
    }

    public User findById(int id) {
        return getUSER_LIST().stream()
                .filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
    }
}

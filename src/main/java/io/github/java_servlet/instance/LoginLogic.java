package io.github.java_servlet.instance;

public class LoginLogic {
    public boolean excute(User user) {
        if (user.getPass().equals("1234")) return true;
        return false;
    }
}

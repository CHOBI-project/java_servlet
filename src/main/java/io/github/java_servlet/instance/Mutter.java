package io.github.java_servlet.instance;

public class Mutter {
    private int id;
    private String userName;
    private String text;

    public Mutter() {}
    public Mutter(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }

    public Mutter(int id, String userName, String text) {
        this.id = id;
        this.userName = userName;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }
    public String getText() {
        return text;
    }
}

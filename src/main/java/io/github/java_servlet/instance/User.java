package io.github.java_servlet.instance;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private String name;
    private String pass;

    public User() {}
    public User(String id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public User(String name, String pass) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}

package io.github.java_servlet.instance;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String category;

    public Animal() {}
    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}

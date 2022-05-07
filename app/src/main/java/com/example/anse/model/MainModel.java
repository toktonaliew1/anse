package com.example.anse.model;

public class MainModel {
    public String name;
    public String description;

    public MainModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

package com.example.yourname; // Ensure this matches your package name

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private int id;
    private String title;
    private String description;
    private List<String> signatures;

    public Petition(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getSignatures() { return signatures; }

    public void addSignature(String name) {
        this.signatures.add(name);
    }
}